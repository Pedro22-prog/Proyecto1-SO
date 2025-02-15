/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;
import MainPackage.Main;
import java.util.Comparator;

import EDD.Lista;

import MainPackage.Main;

import EDD.Nodo;


/**
 *
 * @author pedro
 */

public class Scheduller {
    private Lista<Proceso> ColaListo;
    private Lista<Proceso> ColaBloqueados;
    private Lista<Proceso> ColaTerminados;
    private int quantum;
    private CPU cpu;
    private Proceso procesoActual;

    public Scheduller(int quantum,  Lista ColaListo, Lista ColaBloqueados, Lista ColaTerminados) {
        this.ColaListo = ColaListo;
        this.ColaBloqueados = ColaBloqueados;
        this.ColaTerminados = ColaTerminados;
        this.quantum = 5;
        this.procesoActual = null;


    }

    public Lista<Proceso> getColaListo() {
        return ColaListo;
    }

    public Lista<Proceso> getColaBloqueados() {
        return ColaBloqueados;
    }

    public void setColaBloqueados(Lista<Proceso> ColaBloqueados) {
        this.ColaBloqueados = ColaBloqueados;
    }

    public Lista<Proceso> getColaTerminados() {
        return ColaTerminados;
    }

    public void setColaTerminados(Lista<Proceso> ColaTerminados) {
        this.ColaTerminados = ColaTerminados;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Proceso getProcesoActual() {
        return procesoActual;
    }

    public void setProcesoActual(Proceso procesoActual) {
        this.procesoActual = procesoActual;
    }
    
    
    

    
    public Proceso ejecutarPlanificacion(int politica) {
        switch (politica) {
            case 1 -> fcfs();
            case 2 -> RoundRobin();
            case 3 -> SRT();
            case 4 -> SJF();
            case 5 -> HRRN();
            default -> System.out.println("Política inválida");
        }
        return procesoActual; // Retorna el proceso seleccionado
    }
    
    public void RoundRobin() {
        while (!ColaListo.isEmpty()) {
            procesoActual = ColaListo.getpFirst().gettInfo();
            
            ColaListo.eliminar();
            procesoActual.setStatus("Running");
            
//            int tiempoEjecutado = Math.min(procesoActual.getRemainingTime(), quantum);
//            procesoActual.setRemainingTime(procesoActual.getRemainingTime() - tiempoEjecutado);
//            
//            if (procesoActual.getRemainingTime() > 0) {
//                procesoActual.setStatus("Ready");
//                ColaListo.agregar(procesoActual);
//            } else {
//                procesoActual.setStatus("Exit");
//                ColaTerminados.agregar(procesoActual);
//            }
        }
    }
    
    public void SRT() {
        while (!ColaListo.isEmpty()) {
            procesoActual = MenorTiempoRestante();
            if (procesoActual != null) {
                //ejecutarProceso(procesoActual);
            }
        }
    }

    public void SJF() {
        while (!ColaListo.isEmpty()) {
            procesoActual = MenorTiempoTotal();
            if (procesoActual != null) {
                //ejecutarProceso(procesoActual);
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
            //ejecutarProceso(selected);
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
    
    public Proceso MenorTiempoRestante() {
        Proceso menor = null;
        for (Proceso proceso : ColaListo) {
            if (menor == null || proceso.getRemainingTime() < menor.getRemainingTime()) {
                menor = proceso;
            }
        }
        return menor;
    }

    public Proceso MenorTiempoTotal() {
        Proceso menor = null;
        for (Proceso proceso : ColaListo) {
            if (menor == null || proceso.getTime() < menor.getTime()) {
                menor = proceso;
            }
        }
        return menor;
    }

//    private void ejecutarProceso(Proceso proceso) {
//        proceso.setStatus("Running");
//        if (proceso.getRemainingTime() <= quantum) {
//            proceso.setRemainingTime(0);
//            ColaListo.eliminar();
//            proceso.setStatus("Completed");
//            ColaTerminados.agregar(proceso);
//        } else {
//            proceso.setRemainingTime(proceso.getRemainingTime() - quantum);
//            proceso.setStatus("Ready");
//        }
//    }
    
    private Lista bubbleSort(Lista list, Comparator comparator) {
        if (list.getSize() <= 1) return list;

        boolean swapped;
        do {
            swapped = false;
            Nodo current = list.getpFirst();
            while (current != null && current.getpNext() != null) {
                if (comparator.compare(current.gettInfo(), current.getpNext().gettInfo()) > 0) {
                    Object temp = current.gettInfo();
                    current.settInfo(current.getpNext().gettInfo());
                    current.getpNext().settInfo(temp);
                    swapped = true;
                }
                current = current.getpNext();
            }
        } while (swapped);

        return list;
    }
    
    
    
    
    
}
