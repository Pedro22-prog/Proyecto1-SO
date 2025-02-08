/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author pedro
 */
public class Proceso {
    private PCB pcb; // Control Block del proceso
    private boolean cpubound;
    public Proceso(PCB pcb, boolean cpubound) {
        this.pcb = pcb;
        this.cpubound = cpubound;
    }
    // Método para obtener el PCB del proceso
    public PCB getPcb() {
        return pcb;
    }
}