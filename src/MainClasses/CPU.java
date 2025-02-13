/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.util.concurrent.Semaphore;
import EDD.Lista; 
import EDD.Nodo;
import MainPackage.Main;

/**
 *
 * @author david
 */
public class CPU extends Thread {
    private int id;
    private Proceso proceso;
    private boolean estado;
    private Semaphore s;
    private Scheduller scheduler;
    private Lista listaInterrupts;

    public CPU(int id, boolean estado) {
        this.s = s;
        this.id = id;
        this.proceso = null;
        this.estado = estado;
        this.listaInterrupts= new Lista(); 
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

    /**
     * @return the proceso
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void run() {
        while (true) {
            try {
                Main.semaforo.acquire();
                if (Main.politicaActual == 0) break; // Si la simulación está detenida
                
                if (!Main.colaListos.isEmpty() && this.proceso == null) {
                    Proceso p = Main.scheduler.asignarProceso(this.id);
                    if (p != null) {
                        this.proceso = p;
                        proceso.setStatus("Running");
                        proceso.setCpu(this.id);
                        //Main.gui.updateQueueDisplays();
                    }
                }
                
                if (this.proceso != null) {
                    ejecutarInstruccion();
                    //checkForInterrupt();
                }
                
                Main.semaforo.release();
                Thread.sleep(Main.cicloDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        


    
//    private boolean BuscarInterrupcion(){
//        if (!listaInterrupts.isEmpty()){
//            Nodo noSeHacerElProyecto = this.listaInterrupts.getpFirst();
//            int noMeRaspesSofia = 0;
//            while(noSeHacerElProyecto != null){
//               if (noMeRaspesSofia%2==1) {
//                   //funcion global
//               }
//               noSeHacerElProyecto = noSeHacerElProyecto.getpNext();
//               noMeRaspesSofia++;
//            }
//        }
//        return false;
//    }
    
    
}
    private void ejecutarInstruccion() {
        proceso.setPC(proceso.getPC() + 1);
        proceso.setRemainingTime(proceso.getRemainingTime() - 1);
        
        if (proceso.getRemainingTime() <= 0) {
            proceso.setStatus("Completed");
            Main.colaTerminados.agregar(proceso);
            this.proceso = null;
        }
    }
    


}
