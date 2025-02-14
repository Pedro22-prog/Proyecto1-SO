/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;
import MainPackage.Main;

import EDD.Lista;
import MainPackage.Main;

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
        this.quantum = 5;
        this.p = p;
        this.cpu = cpu;

    }

    public Lista<Proceso> getColaListo() {
        return ColaListo;
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
                procesoActual.setStatus("Exit");
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
    
    public void HRRN() {
        Proceso selected = null;
        double maxRatio = -1;
        for (Proceso p : ColaListo) {
            double waitTime = Main.cicloGlobal - p.getLlegada();
            double ratio = (waitTime + p.getTime()) / p.getTime();
            if (ratio > maxRatio) {
                maxRatio = ratio;
                selected = p;
            }
        }
        if (selected != null) {
            ejecutarProceso(selected);
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
    
    public Proceso asignarProceso(int cpuId) {
        switch (Main.politicaActual) {
            case 1: // FCFS
                return ColaListo.eliminar();
            case 2: // Round Robin
                Proceso p = ColaListo.getpFirst().gettInfo();
                ColaListo.eliminar();
                return p;
            case 5: // HRRN
                HRRN();
                return ColaListo.eliminar();
            default:
                return null;
        }
    }
    
    
    
}
