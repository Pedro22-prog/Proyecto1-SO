/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainPackage;

import EDD.Queue;
import MainClasses.CPU;
import MainClasses.Proceso;
import java.util.concurrent.Semaphore;

/**
 *
 * @author pedro
 */
public class Main {
    public static Semaphore semaforo = new Semaphore(1); // Semáforo binario
    public static Queue<Proceso> colaListos = new Queue();
    public static Queue colaBloqueados = new Queue();
    public static Queue colaTerminados = new Queue();
    public static CPU cpu1 = new CPU(1,true); // CPU 1 siempre activo
    public static CPU cpu2 = new CPU(2,true); // CPU 2 siempre activo
    public static CPU cpu3 = new CPU(3,true); // depende
    public static int cicloGlobal;
    public static int politicaActual = 1;
     public static void main(String[] args) {
        
    }
}
