/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author david
 */
public class CPU extends Thread {
    private int id;
    private Proceso proceso;
    private boolean estado;
    private Semaphore s;

    public CPU(int id, Proceso proceso, boolean estado) {
        this.s = s;
        this.id = id;
        this.proceso = proceso;
        this.estado = estado;
    }

    /**
     * @return the id
     */
    public int getCPUid() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
