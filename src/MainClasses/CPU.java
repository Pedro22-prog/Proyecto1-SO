/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.util.concurrent.Semaphore;
import EDD.Lista; 
import EDD.Nodo;
import MainPackage.Main;

/**
 *
 * @author david
 */
public class CPU extends Thread {
    private int id;
    private Proceso proceso;
    private boolean estado;
    private Semaphore s;
    private Scheduller scheduler;
    private Lista listaInterrupts;

    public CPU(int id, boolean estado) {
        this.s = s;
        this.id = id;
        this.proceso = null;
        this.estado = estado;
        this.listaInterrupts= new Lista(); 
    }

    /**
     * @return the id
     */
    public int getCPUid() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the proceso
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

//    public void run() {
//        while (true) {
//            try {
//                Main.semaforo.acquire();
//                if (Main.politicaActual == 0) break; // Si la simulación está detenida
//                
//                if (!Main.colaListos.isEmpty() && this.proceso==null) {
//                    Proceso p = Main.scheduler.asignarProceso(this.id);
//                    if (p != null) {
//                        this.proceso = p;
//                        proceso.setStatus("Running");
// 
//                        proceso.setCpu(this.id);
//                        //Main.gui.updateQueueDisplays();
//                    }
//                }
//                                Main.semaforo.release();
//                if (this.proceso != null) {
//                    ejecutarInstruccion();
//                    checkForInterrupt();
//                }
//                
//
//                Thread.sleep(Main.cicloDuration);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        

public void run() {
    int quantumCount = 0; // Contador para Round Robin
    Proceso procesoAnterior = null;
    
    while (true) {
        try {
            Main.semaforo.acquire();
            
            // 1. Verificar expulsión (solo para políticas expulsivas)
            if (this.proceso != null) {
                boolean isPreemptive = (Main.politicaActual == 2 || Main.politicaActual == 3); // RR o SRT
                boolean shouldPreempt = false;
                
                // Lógica de expulsión
                if (Main.politicaActual == 2) { // Round Robin
                    quantumCount++;
                    if (quantumCount >= Main.scheduler.getQuantum()) {
                        shouldPreempt = true;
                        quantumCount = 0;
                    }
                } 
                else if (Main.politicaActual == 3) { // SRT
                    Proceso mejorProceso = Main.scheduler.ejecutarPlanificacion(Main.politicaActual);
                    if (mejorProceso != null && mejorProceso != this.proceso) {
                        shouldPreempt = true;
                    }
                }
                
                // Ejecutar expulsión
                if (shouldPreempt && isPreemptive) {
                    this.proceso.setStatus("Ready");
                    Main.colaListos.agregar(this.proceso);
                    this.proceso = null;
                    //Main.gui.updateQueueDisplays();
                }
            }
            
            // 2. Asignar nuevo proceso usando ejecutarPlanificacion()
            if (this.proceso == null && !Main.colaListos.isEmpty()) {
                this.proceso = Main.scheduler.ejecutarPlanificacion(Main.politicaActual);
                
                if (this.proceso != null) {
                    this.proceso.setStatus("Running");
                    this.proceso.setCpu(this.id);
                    quantumCount = 0; // Reset contador RR
                    Main.colaListos.eliminar(this.proceso); // Eliminar de la cola
                    //Main.gui.updateQueueDisplays();
                }
            }
            
            // 3. Ejecutar instrucción
            if (this.proceso != null) {
                ejecutarInstruccion();
                checkForInterrupt();
                
                // Verificar finalización
                if (this.proceso.getRemainingTime() <= 0) {
                    this.proceso.setStatus("Exit");
                    Main.colaTerminados.agregar(this.proceso);
                    this.proceso = null;
                    //Main.gui.updateQueueDisplays();
                }
            }
            
            Main.semaforo.release();
            Thread.sleep(Main.cicloDuration);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    
//    private boolean BuscarInterrupcion(){
//        if (!listaInterrupts.isEmpty()){
//            Nodo noSeHacerElProyecto = this.listaInterrupts.getpFirst();
//            int noMeRaspesSofia = 0;
//            while(noSeHacerElProyecto != null){
//               if (noMeRaspesSofia%2==1) {
//                   //funcion global
//               }
//               noSeHacerElProyecto = noSeHacerElProyecto.getpNext();
//               noMeRaspesSofia++;
//            }
//        }
//        return false;
//    }
    
    


    private void ejecutarInstruccion() {
        proceso.setPC(proceso.getPC() + 1);
        proceso.setRemainingTime(proceso.getRemainingTime() - 1);
        
        if (proceso.getRemainingTime() == 0) {
            proceso.setStatus("Exit");
            Main.colaTerminados.agregar(proceso);
            this.proceso = null;
        }
    }
    

//    private void checkForInterrupt() {
//        if (proceso.isIobound() && (proceso.getPC() % proceso.getCiclosParaExcepcion() == 0)) { 
//            proceso.setStatus("Blocked");
//            Main.colaBloqueados.agregar(proceso);
//            new Thread(() -> {
//                try {
//                    Thread.sleep(proceso.getExceptionDuration() * Main.cicloDuration);
//                    proceso.setStatus("Ready");
//                    Main.colaListos.agregar(proceso);
//                    //Main.gui.updateQueueDisplays();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//            this.proceso = null;
//        }
//    }

    private void checkForInterrupt() {
        if (proceso.isIobound() && (proceso.getPC() % proceso.getCiclosParaExcepcion() == 0)) { 
            proceso.setStatus("Blocked");
            Main.colaBloqueados.agregar(proceso);
            new Thread(() -> {
                try {
                    for (int i = 0; i <= proceso.getExceptionDuration();i++){
                      Thread.sleep(Main.cicloDuration);
                    }
                    
                    proceso.setStatus("Ready");
                    Main.colaListos.agregar(proceso);
                    //Main.gui.updateQueueDisplays();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            this.proceso = null;
        }
    }


}
