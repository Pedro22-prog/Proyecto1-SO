/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import EDD.Lista;
import EDD.Nodo;
import MainClasses.CPU;
import MainClasses.Proceso;
import MainClasses.Scheduller;
import MainPackage.Main;
import static MainPackage.Main.colaBloqueados;
import static MainPackage.Main.colaListos;
import static MainPackage.Main.colaTerminados;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.concurrent.Semaphore;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author pedro
 */
public class Home extends javax.swing.JFrame {
    CPU cpu1 = new CPU(1, true);
    CPU cpu2 = new CPU(1, true);
    CPU cpu3 = new CPU(1, true);
    public static Semaphore semaforo = new Semaphore(1); // Semáforo binario
    public static int cicloGlobal;
    public static int politicaActual = 1;
    public static int cicloDuration;
    public static Scheduller scheduler = new Scheduller(5, colaListos, colaBloqueados, colaTerminados);
    private DefaultCategoryDataset cpuUsageDataset = new DefaultCategoryDataset();
    private DefaultPieDataset processTypeDataset = new DefaultPieDataset();
    private DefaultCategoryDataset policyDataset = new DefaultCategoryDataset();
    private JFreeChart cpuUsageChart, processTypeChart, policyChart;
    private ChartPanel cpuUsagePanel, processTypePanel, policyPanel;
    private boolean simulacionActiva = false;
    private Thread hiloSimulacion;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        QtyCPU.setSelectedItem("2");
        crearGraficosEstadisticos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        finish = new javax.swing.JButton();
        ShowResults = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        ViewResults = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        CPUsage = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Processtadistics = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Planificaction = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        exit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnAgregarProceso = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SelectAlgorithm = new javax.swing.JComboBox<>();
        Close = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ShowQueueReady = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ShowCPU1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        ShowCPU2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        ShowCPU3 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        ShowQueueBlock = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ShowFinishQueue = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        QtyCPU = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        finish.setText("Exit");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });
        jPanel4.add(finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        ShowResults.setText("Mostrar");
        ShowResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowResultsActionPerformed(evt);
            }
        });
        jPanel4.add(ShowResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        ViewResults.setColumns(20);
        ViewResults.setRows(5);
        jScrollPane8.setViewportView(ViewResults);

        jPanel4.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 360, 240));

        jLabel15.setText("SOmulation");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jLabel16.setText("Resultados Obtenidos de la simulación.");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel17.setText("Resumen de la simulación");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel21.setText("Estadisticas de CPU");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        CPUsage.setColumns(20);
        CPUsage.setRows(5);
        jScrollPane9.setViewportView(CPUsage);

        jPanel4.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 310, 240));

        jLabel22.setText("Cantidad de Procesos");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        Processtadistics.setColumns(20);
        Processtadistics.setRows(5);
        jScrollPane10.setViewportView(Processtadistics);

        jPanel4.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 350, 240));

        jLabel23.setText("Estadisticas por politica de planificación");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, -1));

        Planificaction.setColumns(20);
        Planificaction.setRows(5);
        jScrollPane11.setViewportView(Planificaction);

        jPanel4.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 330, 240));

        jTabbedPane1.addTab("Resultados", jPanel4);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Bienvenido a SOmulation");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 5, -1, -1));

        jLabel8.setText("Creación de Procesos");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel1.setText("Nombre:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 80, 20));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 136, 150, 30));

        jLabel2.setText("Tipo de Proceso: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, 30));

        jLabel3.setText("El patio de Juego de los Grandes");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I/OBound", "CPUBound" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, 30));

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        jLabel6.setText("Tiempo de ejecución: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 140, -1));

        btnAgregarProceso.setText("Agregar");
        btnAgregarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProcesoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        jLabel18.setText("Ciclo para excepcion: ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 190, -1));

        jLabel19.setText("Duracion de la excepcion:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 190, -1));

        jTabbedPane1.addTab("Inicio", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("SOmulation");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel5.setText("Tipo de Politiva de Planificación:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, -1));

        SelectAlgorithm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "Round Robin", "SRT", "SPN", "HRRN" }));
        SelectAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAlgorithmActionPerformed(evt);
            }
        });
        jPanel3.add(SelectAlgorithm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        Close.setText("Exit");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jPanel3.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, -1, -1));

        jLabel9.setText("CPU 1");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 106, -1, 20));

        jLabel10.setText("CPU 2");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 40, -1));

        jLabel11.setText("CPU 3");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, 30));

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel3.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel3.add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        jLabel13.setText("Cola de bloqueados");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));

        jLabel12.setText("Cola de Listos");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        ShowQueueReady.setColumns(20);
        ShowQueueReady.setRows(5);
        jScrollPane2.setViewportView(ShowQueueReady);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 220, 150));

        ShowCPU1.setColumns(20);
        ShowCPU1.setRows(5);
        jScrollPane3.setViewportView(ShowCPU1);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 230, 140));

        ShowCPU2.setColumns(20);
        ShowCPU2.setRows(5);
        jScrollPane4.setViewportView(ShowCPU2);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 230, 160));

        ShowCPU3.setColumns(20);
        ShowCPU3.setRows(5);
        jScrollPane5.setViewportView(ShowCPU3);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 230, 200));

        ShowQueueBlock.setColumns(20);
        ShowQueueBlock.setRows(5);
        jScrollPane6.setViewportView(ShowQueueBlock);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, 140));

        jLabel14.setText("Cola de terminados:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, -1, -1));

        ShowFinishQueue.setColumns(20);
        ShowFinishQueue.setRows(5);
        jScrollPane7.setViewportView(ShowFinishQueue);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, 230, 190));

        jLabel20.setText("Cantidad de CPUS: ");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        QtyCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3" }));
        jPanel3.add(QtyCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 50, -1));

        jTabbedPane1.addTab("Simulacion", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        simulacionActiva = false;
        detenerCPUs(); // Método para detener CPUs
        if (hiloSimulacion != null) {
            hiloSimulacion.interrupt();
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (!simulacionActiva) {
            simulacionActiva = true;
//           Main.cantidadCpus = Integer.parseInt(QtyCPU.getSelectedItem().toString());

            // Iniciar hilos de las CPUs
            cpu1.start();
            cpu2.start();
            if (  Integer.parseInt(QtyCPU.getSelectedItem().toString())   == 3) {
                cpu3.start();
            }
            iniciarSimulacion();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_finishActionPerformed

    private void SelectAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAlgorithmActionPerformed
        // TODO add your handling code here:
        String politica = (String) SelectAlgorithm.getSelectedItem();
        switch (politica) {
            case "FCFS":
                Main.politicaActual = 1;
                break;
            case "Round Robin":
                Main.politicaActual = 2;
                break;
            case "SRT":
                Main.politicaActual = 3;
                break;
            case "SJT":
                Main.politicaActual = 4;
                break;
            case "HRRN":
                Main.politicaActual = 5;
                break;
        }
        actualizarPlanificador();
    }//GEN-LAST:event_SelectAlgorithmActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        boolean esIO = jComboBox1.getSelectedItem().equals("I/OBound");
        jTextField3.setEnabled(esIO);
        jTextField4.setEnabled(esIO);
        jLabel18.setEnabled(esIO);
        jLabel19.setEnabled(esIO);
        if (!esIO) {
            jTextField3.setText("");
            jTextField4.setText("");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAgregarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProcesoActionPerformed
        try {
            String nombre = jTextField1.getText();
            String tiempoStr = jTextField2.getText();
            boolean esIO = jComboBox1.getSelectedItem().equals("I/OBound");
            String ciclosExcepcionStr = jTextField3.getText();
            String duracionExcepcionStr = jTextField4.getText();

            // Validar campos obligatorios
            if (nombre.isEmpty() || tiempoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y Tiempo son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar campos de I/O Bound
            if (esIO) {
                if (ciclosExcepcionStr.isEmpty() || duracionExcepcionStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ciclos y Duración son obligatorios para I/O Bound", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            int ciclosExcepcion = Integer.parseInt(ciclosExcepcionStr);
            int duracionExcepcion = Integer.parseInt(duracionExcepcionStr);
            if (ciclosExcepcion <= 0 || duracionExcepcion <= 0) {
                JOptionPane.showMessageDialog(this, "Ciclos y Duración deben ser positivos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

            int tiempo = Integer.parseInt(tiempoStr);
            if (tiempo <= 0) {
                JOptionPane.showMessageDialog(this, "El tiempo debe ser un número positivo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Proceso p = new Proceso(
                Main.colaListos.getSize() + 1,
                nombre,
                "Ready",
                0,
                tiempo,
                tiempo,
                !esIO,
                esIO,
                0,
                0,
                Main.cicloGlobal
            );
        
            if (esIO) {
                p.setCiclosParaExcepcion(Integer.parseInt(ciclosExcepcionStr));
                p.setExceptionDuration(Integer.parseInt(duracionExcepcionStr));
            }
            Main.colaListos.agregar(p);
            JOptionPane.showMessageDialog(this, "Proceso agregado!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarProcesoActionPerformed

    private void ShowResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowResultsActionPerformed
        StringBuilder resultados = new StringBuilder();
        resultados.append("Procesos Terminados: ").append(Main.colaTerminados.getSize()).append("\n");
        resultados.append("Ciclos Totales: ").append(Main.cicloGlobal).append("\n");
        resultados.append("Utilización de CPUs: ").append(calcularUtilizacionCPUs()).append("%\n");
        ViewResults.setText(resultados.toString());
        // Actualizar gráficos
        cpuUsageChart.fireChartChanged();
        processTypeChart.fireChartChanged();
        policyChart.fireChartChanged();        
    }//GEN-LAST:event_ShowResultsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CPUsage;
    private javax.swing.JButton Close;
    private javax.swing.JTextArea Planificaction;
    private javax.swing.JTextArea Processtadistics;
    private javax.swing.JComboBox<String> QtyCPU;
    private javax.swing.JComboBox<String> SelectAlgorithm;
    private javax.swing.JTextArea ShowCPU1;
    private javax.swing.JTextArea ShowCPU2;
    private javax.swing.JTextArea ShowCPU3;
    private javax.swing.JTextArea ShowFinishQueue;
    private javax.swing.JTextArea ShowQueueBlock;
    private javax.swing.JTextArea ShowQueueReady;
    private javax.swing.JButton ShowResults;
    private javax.swing.JTextArea ViewResults;
    private javax.swing.JButton btnAgregarProceso;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton exit;
    private javax.swing.JButton finish;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void actualizarPlanificador() {
        Main.scheduler = new Scheduller(
        (Main.politicaActual == 2) ? 5 : 0, 
        Main.colaListos, 
        Main.colaBloqueados, 
        Main.colaTerminados
    );
    }

    private void iniciarSimulacion() {
        hiloSimulacion = new Thread(() -> {
            while (simulacionActiva) {
                try {
                    Main.semaforo.acquire();
                    SwingUtilities.invokeLater(() -> {
                        actualizarInterfaz();
                        Main.cicloGlobal++;
                    });
                    Main.semaforo.release();
                    Thread.sleep(Main.cicloDuration);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        hiloSimulacion.start();
    }

    private void actualizarInterfaz() {
        actualizarCPU(ShowCPU1, cpu1.getProceso());
        actualizarCPU(ShowCPU2, cpu2.getProceso());
        
        // Solo actualizar CPU3 si está activa
        if (Integer.parseInt(QtyCPU.getSelectedItem().toString())   == 3) {
            actualizarCPU(ShowCPU3, cpu3.getProceso());
        } else {
            ShowCPU3.setText("CPU Inactiva");
        }
        // Actualizar colas
        actualizarCola(ShowQueueReady, Main.colaListos);
        actualizarCola(ShowQueueBlock, Main.colaBloqueados);
        actualizarCola(ShowFinishQueue, Main.colaTerminados);
        
        // Actualizar datasets
        double utilizacion = calcularUtilizacionCPUs();
        cpuUsageDataset.addValue(utilizacion, "Uso", String.valueOf(Main.cicloGlobal));

        // Actualizar tipos de procesos
        int cpuBound = contarProcesosPorTipo(true);
        int ioBound = contarProcesosPorTipo(false);
        processTypeDataset.setValue("CPU Bound", cpuBound);
        processTypeDataset.setValue("I/O Bound", ioBound);

        // Actualizar políticas
        actualizarEstadisticasPoliticas();
    }
    
    private void detenerCPUs() {
        cpu1.interrupt();
        cpu2.interrupt();
        if (Integer.parseInt(QtyCPU.getSelectedItem().toString()) == 3) {
            cpu3.interrupt();
        }
        SwingUtilities.invokeLater(() -> actualizarInterfaz());
    }

    private void actualizarCPU(JTextArea area, Proceso proceso) {
        if (proceso != null) {
            area.setText(
                "ID: " + proceso.getId() + "\n" +
                "Nombre: " + proceso.getName() + "\n" +
                "PC: " + proceso.getPC() + "\n" + 
                "MAR: " + proceso.getMAR() + "\n"+
                "T. Restante: " + proceso.getRemainingTime()
            );
        } else {
            area.setText("CPU Inactiva");
        }
    }
    
    private double calcularUtilizacionCPUs() {
        int activas = 0;
        if (cpu1.getProceso() != null) activas++;
        if (cpu2.getProceso() != null) activas++;
        if (Integer.parseInt(QtyCPU.getSelectedItem().toString()) == 3 && cpu3.getProceso() != null) activas++;
        int totalCPUs = Integer.parseInt(QtyCPU.getSelectedItem().toString());
        return (activas * 100.0) / totalCPUs;
    }

    private void actualizarCola(JTextArea area, Lista<Proceso> cola) {
        StringBuilder sb = new StringBuilder();
        for (Proceso p : cola) {
            sb.append(p.toString()).append("\n");
        }
        area.setText(sb.toString());
    }
    
    private void crearGraficosEstadisticos() {
    // Gráfico de uso de CPU
    cpuUsageChart = ChartFactory.createLineChart(
        "Uso de CPU por Ciclo", 
        "Ciclos", 
        "Uso (%)", 
        cpuUsageDataset,
        PlotOrientation.VERTICAL, 
        true, true, false
    );
    cpuUsagePanel = new ChartPanel(cpuUsageChart);
    
    // Gráfico de tipos de procesos
    processTypeChart = ChartFactory.createPieChart(
        "Distribución de Procesos", 
        processTypeDataset, 
        true, true, false
    );
    processTypePanel = new ChartPanel(processTypeChart);
    
    // Gráfico de políticas
    policyChart = ChartFactory.createBarChart(
        "Estadísticas por Política", 
        "Política", 
        "Cantidad", 
        policyDataset,
        PlotOrientation.VERTICAL, 
        true, true, false
    );
    policyPanel = new ChartPanel(policyChart);
    
    // Añadir gráficos al panel de resultados
    jPanel4.add(cpuUsagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 360, 240));
    jPanel4.add(processTypePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 350, 240));
    jPanel4.add(policyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 330, 240));
    }
    
    private int contarProcesosPorTipo(boolean esCpuBound) {
    int count = 0;
    for (Proceso p : Main.colaTerminados) {
        if (esCpuBound && p.isCpubound()) count++;
        else if (!esCpuBound && p.isIobound()) count++;
    }
    return count;
    }

    private void actualizarEstadisticasPoliticas() {
        policyDataset.addValue(Main.scheduler.getColaTerminados().getSize(), "Procesos", "Terminados");
        policyDataset.addValue(Main.colaListos.getSize(), "Procesos", "En espera");
    }
    
    
    
//    private void configurarGrafico() {
//    chart = ChartFactory.createLineChart(
//        "Rendimiento del Sistema", 
//        "Ciclos", 
//        "Cantidad", 
//        dataset
//    );
//    chartPanel = new ChartPanel(chart);
//    chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
//    jPanel4.add(chartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 600, 400));
//    }
}
