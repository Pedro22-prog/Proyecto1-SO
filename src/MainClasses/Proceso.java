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
<<<<<<< HEAD
    private String tipo;
    private int cant_instrucciones;

    public int getCant_instrucciones() {
        return cant_instrucciones;
    }

    public void setCant_instrucciones(int cant_instrucciones) {
        this.cant_instrucciones = cant_instrucciones;
    }

    public String getTipo() {
        return tipo;
    }

    public Proceso(PCB pcb) {
=======
    private boolean cpub; //Se le asigna un valor de true si es CPUBound
    //o false si es I/O Bound
    
    public Proceso(PCB pcb, boolean cpub) {
>>>>>>> 18004443117d5d73da18eb24e184308c98692daa
        this.pcb = pcb;
        this.cpub = cpub;
    }
    // Método para obtener el PCB del proceso
    public PCB getPcb() {
        return pcb;
    }

    /**
     * @param pcb the pcb to set
     */
    public void setPcb(PCB pcb) {
        this.pcb = pcb;
    }

    /**
     * @return the cpub
     */
    public boolean isCpub() {
        return cpub;
    }

    /**
     * @param cpub the cpub to set
     */
    public void setCpub(boolean cpub) {
        this.cpub = cpub;
    }
}