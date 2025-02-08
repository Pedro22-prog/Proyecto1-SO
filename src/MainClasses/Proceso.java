/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author pedro
 */
public class Proceso {
    private PCB pcb; // Control Block del proceso

    public Proceso(PCB pcb) {
        this.pcb = pcb;
    }
    // Método para obtener el PCB del proceso
    public PCB getPcb() {
        return pcb;
    }
}