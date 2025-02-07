/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainPackage;

import MainClasses.PCB;
import MainClasses.Proceso;

/**
 *
 * @author pedro
 */
public class Main {
     public static void main(String[] args) {
    PCB pcbito = new PCB(1, "hola", 7);
    Proceso p1 = new Proceso(pcbito);
    PCB pcbita = new PCB(1, "hola", 4);
    Proceso p2 = new Proceso(pcbita);
    
    p1.start();
    p2.start();
    }
}
