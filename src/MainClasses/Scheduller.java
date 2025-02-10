/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import EDD.Queue;

/**
 *
 * @author pedro
 */




//Algoritmos de planificación



public class Scheduller {
    private Queue ColaListo;
    private Queue ColaBloqueados;
    private Queue ColaTerminados;
    private int quantum;
    private Proceso p;
    private CPU cpu;

    
    public Scheduller(int quantum, Proceso p, CPU Cpu){
        this.ColaListo = new Queue();
        this.ColaBloqueados = new Queue();
        this.ColaTerminados = new Queue();
        this.quantum = 5;
        this.p = p;
    }
}