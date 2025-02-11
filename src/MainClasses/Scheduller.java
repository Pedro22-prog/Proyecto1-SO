/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;


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

    public Scheduller(int quantum, Proceso p, CPU cpu) {
        this.ColaListo = new Lista<>("ColaListo", 1);
        this.ColaBloqueados = new Lista<>("ColaBloqueados", 2);
        this.ColaTerminados = new Lista<>("ColaTerminados", 3);
        this.quantum = quantum;
        this.p = p;
        this.cpu = cpu;
    }
    
    public void ejecutarPlanificacion(int politica) {
        switch (politica) {
            case 1:
                fcfs();
                break;
            case 2:
                RoundRobin();
                break;
            case 3:
                SRT();
                break;
            case 4:
                SJF();
                break;
            case 5:
                HRRN();
                break;
            default:
                System.out.println("Política de planificación no válida.");
        }
    }
    
    public void RoundRobin() {
        while (!ColaListo.isEmpty()) {
            Proceso procesoActual = ColaListo.getpFirst().gettInfo();
            ColaListo.eliminar();
            
            procesoActual.setStatus("Running");
            int tiempoEjecutado = Math.min(procesoActual.getRemainingTime(), quantum);
            procesoActual.setRemainingTime(procesoActual.getRemainingTime() - tiempoEjecutado);
            
            if (procesoActual.getRemainingTime() > 0) {
                procesoActual.setStatus("Ready");
                ColaListo.agregar(procesoActual);
            } else {
                procesoActual.setStatus("Completed");
                ColaTerminados.agregar(procesoActual);
            }
        }
    }
    
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
    
    public void HRRN(){
        if(!ColaListo.isEmpty()){
            Proceso pActual = null;
            double mr = -1; //Para almacenar el mayor ratio del proceso
        }
    }

    public void fcfs() {
        while (!ColaListo.isEmpty()) {
            Proceso procesoActual = ColaListo.getpFirst().gettInfo();
            ColaListo.eliminar();
            
            procesoActual.setStatus("Running");
            procesoActual.setRemainingTime(0);
            
            procesoActual.setStatus("Completed");
            ColaTerminados.agregar(procesoActual);
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
