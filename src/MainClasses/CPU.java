/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author david
 */
public class CPU {
    
    private int id;
    private Proceso proceso;
    private String estado;

    public CPU(int id, Proceso proceso, String estado) {
        this.id = id;
        this.proceso = proceso;
        this.estado = estado;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the id
     */
    
}
