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

public class Scheduller {
    private Queue ColaListo;
    private Queue ColaBloqueados;
    private Queue ColaTerminados;
    private int quantum;
    private Proceso p;
    private CPU cpu;
    private Proceso proceso;
    
    public Scheduller(int quantum, Proceso p, CPU Cpu){
        this.ColaListo = new Queue();
        this.ColaBloqueados = new Queue();
        this.ColaTerminados = new Queue();
        this.quantum = 5;
        this.p = p;
    }
    
   
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