/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author pedro
 */
public class PCB {
    private int id; // Identificador único del proceso
    private String name; // Nombre del proceso
    private String status; // Estado del proceso (Ready, Running, Blocked, Completed)
    private int cpu; // CPU asignado
    private int time; // Tiempo total de ejecución
    private int remainingTime; // Tiempo restante para completar el proceso

    public PCB(int id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.remainingTime = time; // Inicialmente, el tiempo restante es igual al tiempo total
        this.status = "Ready"; // Estado inicial
        this.cpu = -1; // Sin CPU asignado inicialmente
    }

    // Getters y Setters
    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public int getCpu() { 
        return cpu; 
    }
    public void setCpu(int cpu) { 
        this.cpu = cpu; 
    }
    public int getTime() { 
        return time; 
    }
    public int getRemainingTime() { 
        return remainingTime; 
    }
    public void decrementRemainingTime(int quantum) { 
        this.remainingTime -= quantum; 
    }
}