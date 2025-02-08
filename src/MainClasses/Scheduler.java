/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author david
 */
import EDD.Queue;
import EDD.Nodo;

import java.util.concurrent.Semaphore;

public class Scheduler {
    private String nombreAlgoritmo;
    public Queue<Proceso> ColaListos;
    private Queue<Proceso> ColaBloqueados;
    private Queue<Proceso> ColaTerminados;

    private CPU cpuDefault;
    private Proceso procesoEntrante;

    private final int quantum = 5; //Quantum de tiempo de RR en ciclos
    private Semaphore semaphore; // Semáforo para garantizar exclusión mutua

    public Scheduler(String nombreAlgoritmo, Queue<Proceso> ColaListos, Queue<Proceso> ColaBloqueados, Queue<Proceso> ColaTerminados, CPU cpuDefault) {
        this.nombreAlgoritmo = nombreAlgoritmo;
        this.ColaListos = ColaListos;
        this.ColaBloqueados = ColaBloqueados;
        this.ColaTerminados = ColaTerminados;

        this.cpuDefault = cpuDefault;
        this.semaphore = new Semaphore(1); // Inicializar el semáforo con un permiso disponible
    }

    public void escogerProceso() {
        Proceso proceso = null;
        try {
            semaphore.acquire(); // Adquirir el permiso del semáforo (wait)
            switch (nombreAlgoritmo) {
                case "FCFS":
                    proceso = fcfs();
                    ejecutarFCFS(proceso);
                    break;
                case "RR":
                    proceso = roundRobin();
                    break;
                case "SPN":
                    proceso = spn();
                    break;
                case "SRT":
                    srt(this.cpuDefault);
                    break;
                // Agregar otro caso para el algoritmo que falta
            }
            if (proceso != null) {
                despacharProceso(proceso);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Liberar el permiso del semáforo (signal)
        }
    }

    public void despacharProceso(Proceso proceso) {
        // Lógica para ejecutar el proceso
        ejecutarProcesos(proceso);
    }

    private Proceso fcfs() {
        try {
            semaphore.acquire(); // Adquirir el permiso del semáforo (wait)
            if (ColaListos.isEmpty()) {
                return null; // Si no hay procesos listos, retorna null
            }

            Proceso proceso = ColaListos.getHead().gettInfo(); // Obtener el primer proceso
            ColaListos.desencolar(); // Eliminar de la cola
            return proceso; // Retornar el proceso
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release(); // Liberar el permiso del semáforo (signal)
        }
    }

    /*La diferencia es que este se ejecuta 
    cada vez que termina el quantum de tiempo*/
    private Proceso roundRobin() {
        try {
            semaphore.acquire(); // Adquirir el permiso del semáforo
            if (ColaListos.isEmpty()) {
                return null; // Si no hay procesos listos, retorna null
            }

            Proceso proceso = ColaListos.getHead().gettInfo(); // Obtener el primer proceso 
            ColaListos.desencolar(); // Eliminar de la cola
            return proceso; // Retornar el proceso
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release(); // Liberar el permiso del semáforo
        }
    }
    
    

    private Proceso spn() {
        try {
            semaphore.acquire(); // Adquirir el permiso del semáforo
            if (ColaListos.isEmpty()) {
                return null; // Si no hay procesos listos, retorna null
            }
            System.out.println("Antes de ordenar:");
            System.out.println(ColaListos.travel());

            // Ordenar la cola por número de instrucciones antes de buscar el proceso más corto
            ordenarColaPorNumeroInstrucciones(ColaListos);
            System.out.println("Después de ordenar:");
            System.out.println(ColaListos.travel());
            // Obtener el proceso con el menor número de instrucciones
            Proceso procesoMasCorto = ColaListos.getHead().gettInfo();
            ColaListos.desencolar(); // Eliminar de la cola

            return procesoMasCorto; // Retornar el proceso que se ha ejecutado
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release(); // Liberar el permiso del semáforo
        }
    }

    private void srt(CPU cpuDefault) {
        try {
            semaphore.acquire(); // Adquirir el permiso del semáforo
            if (ColaListos.isEmpty()) {
                return;
            }
            Proceso shorterProcess = spn();
            Proceso cpuCurrentProcess = cpuDefault.getProceso();
            
            if (shorterProcess.getCant_instrucciones() < cpuCurrentProcess.getCant_instrucciones()) {
                cpuDefault.setProceso(shorterProcess);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Liberar el permiso del semáforo
        }
    }

    public void ordenarColaPorNumeroInstrucciones(Queue<Proceso> cola) {
        try {
            semaphore.acquire(); // Adquirir el permiso del semáforo
            if (cola.isEmpty() || cola.getHead().getpNext() == null) {
                return; // La cola está vacía o tiene un solo elemento
            }

            boolean intercambiado;
            do {
                Nodo<Proceso> actual = cola.getHead();
                Nodo<Proceso> siguiente = actual.getpNext();
                intercambiado = false;

                while (siguiente != null) {
                    // Comparar el número de instrucciones entre los nodos
                    if (actual.gettInfo().getCant_instrucciones() > siguiente.gettInfo().getCant_instrucciones()) {
                        // Intercambiar los datos de los nodos
                        Proceso temp = actual.gettInfo();
                        actual.settInfo(siguiente.gettInfo());
                        siguiente.settInfo(temp);
                        intercambiado = true;
                    }
                    // Avanzar a los siguientes nodos
                    actual = siguiente;
                    siguiente = siguiente.getpNext();
                }
            } while (intercambiado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Liberar el permiso del semáforo
        }
    }

    public void ejecutarProcesos(Proceso proceso) {
        if (proceso.getTipo() == "CPU BOUND") {
            if (nombreAlgoritmo == "FCFS"){
                this.escogerProceso();
            }
            this.cpuDefault.setProceso(proceso);
            proceso.start();
        } else if (proceso.getTipo() == "I/O BOUND"){
            
            proceso.start();
            // Agregar el proceso a la cola de bloqueados
            ColaBloqueados.encolar(proceso);
            // Eliminar el proceso de la cola de listos
            //ColaListos.eliminar(proceso);
        }
        // Actualizar las colas según el estado del proceso
        actualizarColas(proceso);
    }

    private void actualizarColas(Proceso proceso) {
//        if (proceso.estaTerminado()) {
//            // Eliminar el proceso de la cola de listos o bloqueados
//            if (ColaListos.contiene(proceso)) {
//                ColaListos.eliminar(proceso);
//            } else if (ColaBloqueados.contiene(proceso)) {
//                ColaBloqueados.eliminar(proceso);
//            }
//            // Agregar el proceso a la cola de terminados
//            ColaTerminados.encolar(proceso);
//        } else if (proceso.estaBloquedo()) {
//            // Eliminar el proceso de la cola de listos
//            ColaListos.eliminar(proceso);
//        } else {
//            // Agregar el proceso a la cola de listos
//            ColaListos.encolar(proceso);
//        }
    }

    public void satisfacerExcepcion(Proceso proceso) {
        // Reactivar el proceso bloqueado
        //ColaBloqueados.eliminar(proceso);
        ColaListos.encolar(proceso);
    }

    public String getNombreAlgoritmo() {
        return nombreAlgoritmo;
    }
    
    private void ejecutarFCFS(Proceso proceso) {
        // Lógica para ejecutar el proceso en FCFS
        cpuDefault.setProceso(proceso);
        proceso.start();
        // Actualizar las colas según el estado del proceso
        actualizarColas(proceso);
    }
}