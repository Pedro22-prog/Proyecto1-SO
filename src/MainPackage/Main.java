/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainPackage;

import EDD.Lista;
import MainClasses.CPU;
import MainClasses.Proceso;
import MainClasses.Scheduller;
import java.util.concurrent.Semaphore;
import GUI.Home;

/**
 *
 * @author pedro
 */
public class Main {
    public static Semaphore semaforo = new Semaphore(1); // Semáforo binario
    public static Lista<Proceso> colaListos = new Lista();
    public static Lista colaBloqueados = new Lista();
    public static Lista colaTerminados = new Lista();
    public static CPU cpu1 = new CPU(1,true); 
    public static CPU cpu2 = new CPU(2,true); 
    public static CPU cpu3 = new CPU(3,true); // depende
    public static int cicloGlobal;
    public static int politicaActual = 1;
    public static int cicloDuration;
    
    public static Scheduller scheduler= new Scheduller(5, colaListos,colaBloqueados, colaTerminados);    

     public static void main(String[] args) {
         Home start = new Home();
         
         
         
    }
    public static Scheduller getScheduler() {
        return scheduler;
    }
    
}