/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author pedro
 */
public class Proceso extends Thread {
    private PCB pcb; // Control Block del proceso

    public Proceso(PCB pcb) {
        this.pcb = pcb;
    }

    @Override
    public void run() {
        // Simulación de la ejecución del proceso
        while (pcb.getRemainingTime() > 0 && !Thread.currentThread().isInterrupted()) {
            // Simular un ciclo de ejecución
            try {
                // Simula un segundo de tiempo de CPU
                Thread.sleep(1000); // Representa 1 unidad de tiempo
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido, salimos del bucle
                System.out.println("Proceso " + pcb.getId() + " interrumpido.");
                return; // Salimos del método run
            }

            // Decrementar el tiempo restante
            pcb.decrementRemainingTime(1); // Decrementa 1 unidad de tiempo
            System.out.println("Proceso " + pcb.getId() + " ejecutándose. Tiempo restante: " + pcb.getRemainingTime());
        }

        // Al finalizar, se puede actualizar el estado del proceso
        if (pcb.getRemainingTime() <= 0) {
            pcb.setStatus("Completed");
            System.out.println("Proceso " + pcb.getId() + " completado.");
        }
    }

    // Método para obtener el PCB del proceso
    public PCB getPcb() {
        return pcb;
    }
}