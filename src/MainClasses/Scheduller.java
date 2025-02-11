/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import EDD.Queue;
import EDD.Lista;

/**
 *
 * @author pedro
 */

public class Scheduller {
    private Lista<Proceso> ColaListo;
    private Lista<Proceso> ColaBloqueados;
    private Lista<Proceso> ColaTerminados;
    private int quantum;
    private Proceso p;
    private CPU cpu;
<<<<<<< HEAD
    private Proceso proceso;
    
    public Scheduller(int quantum, Proceso p, CPU Cpu){
        this.ColaListo = new Queue();
        this.ColaBloqueados = new Queue();
        this.ColaTerminados = new Queue();
        this.quantum = 5;
=======

    public Scheduller(int quantum, Proceso p, CPU cpu) {
        this.ColaListo = new Lista<>("ColaListo", 1);
        this.ColaBloqueados = new Lista<>("ColaBloqueados", 2);
        this.ColaTerminados = new Lista<>("ColaTerminados", 3);
        this.quantum = quantum;
>>>>>>> 959c14b14380413a0751171723daaeeb691c1944
        this.p = p;
        this.cpu = cpu;
    }
<<<<<<< HEAD
    
   
    private Scheduller(){
    //Algoritmo de planificacion FCFS
    
    //Allgoritmo de planificacion Round Robin
    
    //Algoritmo de planificaacion SRT
    
    //Algoritmo de planificacion HRRN
    
    //Algoritmo de planificacion SPN
    }

    //Logica para el manejo de los procesos 
    
    /*
    Sse va a aingresar los algoritmos de planificacion dependiendo del proceso
    Round Robin y FCFS
    */

}
=======

    public void SRT() {
        while (!ColaListo.isEmpty()) {
            Proceso procesoActual = MenorTiempoRestante();
            if (procesoActual != null) {
                ejecutarProceso(procesoActual);
            }
        }
    }

    public void SJF() {
        while (!ColaListo.isEmpty()) {
            Proceso procesoActual = MenorTiempoTotal();
            if (procesoActual != null) {
                ejecutarProceso(procesoActual);
            }
        }
    }

    private Proceso MenorTiempoRestante() {
        Proceso menor = null;
        for (Proceso proceso : ColaListo) {
            if (menor == null || proceso.getRemainingTime() < menor.getRemainingTime()) {
                menor = proceso;
            }
        }
        return menor;
    }

    private Proceso MenorTiempoTotal() {
        Proceso menor = null;
        for (Proceso proceso : ColaListo) {
            if (menor == null || proceso.getTime() < menor.getTime()) {
                menor = proceso;
            }
        }
        return menor;
    }

    private void ejecutarProceso(Proceso proceso) {
        proceso.setStatus("Running");
        if (proceso.getRemainingTime() <= quantum) {
            proceso.setRemainingTime(0);
            ColaListo.eliminar();
            proceso.setStatus("Completed");
            ColaTerminados.agregar(proceso);
        } else {
            proceso.setRemainingTime(proceso.getRemainingTime() - quantum);
            proceso.setStatus("Ready");
        }
    }
}
>>>>>>> 959c14b14380413a0751171723daaeeb691c1944
