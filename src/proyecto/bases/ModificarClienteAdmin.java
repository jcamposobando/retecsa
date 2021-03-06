/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.*;
import javax.swing.*;
import java.util.Collections;

/**
 *
 * @author b22539
 */
public class ModificarClienteAdmin extends javax.swing.JFrame {
    private String conexion;
    private boolean type;
    final Runnable function;
    private String llaveId;
    private String llaveCorreo;

    /**
     * Creates new form ModificarCliente
     */
    public ModificarClienteAdmin(String conexion, boolean type, Runnable function, Object[][] nuevos) {
        this.function = function;
        this.conexion = conexion;
        this.type = type;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        if(!type){
            llaveId = nuevos[0][0].toString();
            id.setText(nuevos[0][0].toString());
            nombre.setText(nuevos[0][2].toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        correo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        empleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        funcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel4.setText("Teléfono:");

        jLabel7.setText("Tipo:");

        jLabel5.setText("Empleado:");

        jLabel6.setText("Función:");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Identficación:");

        jLabel3.setText("Correo:");

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombre)
                                .addComponent(id)
                                .addComponent(correo)
                                .addComponent(telefono)
                                .addComponent(empleado)
                                .addComponent(funcion, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tipo))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(funcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(regresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(type){
            Object[] atributos = new Object[3];
            atributos[0] = id.getText();
            atributos[1] = "3";
            atributos[2] = nombre.getText();
            String query = "INSERT INTO DBO.CLIENTE VALUES(?,?,?)";
            TablaDatos.executeUpdate(conexion, query, atributos);
            if(tipo.getText().toUpperCase().equals("PARTICULAR")){
                atributos = new Object[3];
                atributos[0] = id.getText();
                atributos[1] = correo.getText();
                atributos[2] = telefono.getText();
                query = "INSERT INTO DBO.PARTICULAR VALUES(?,?,?)";
                TablaDatos.executeUpdate(conexion, query, atributos);
            }else if(tipo.getText().toUpperCase().equals("EMPRESA")){
                atributos = new Object[5];
                atributos[0] = id.getText();
                atributos[1] = correo.getText();
                atributos[2] = empleado.getText();
                atributos[3] = funcion.getText();
                atributos[4] = telefono.getText();
                query = "INSERT INTO DBO.EMPLEADO VALUES(?,?,?,?,?)";
                TablaDatos.executeUpdate(conexion, query, atributos);
            }
        }else{
            Object[] atributos = new Object[3];
            atributos[0] = id.getText();
            atributos[1] = nombre.getText();
            atributos[2] = llaveId;
            String query = "UPDATE DBO.CLIENTE SET IDCLIENTE = ?, NOMBRECLIENTE = ? WHERE IDCLIENTE = ?";
            TablaDatos.executeUpdate(conexion, query, atributos);
            if(tipo.getText().equals("particular")){
                atributos = new Object[4];
                atributos[0] = id.getText();
                atributos[1] = correo.getText();
                atributos[2] = telefono.getText();
                atributos[3] = llaveId;
                query = "UPDATE DBO.PARTICULAR SET IDCLIENTE = ?, CORREOPARTICULAR = ?, TELEFONOPARTICULAR = ? WHERE IDCLIENTE = ?";
                TablaDatos.executeUpdate(conexion, query, atributos);
            }else if(tipo.getText().equals("empresa")){
                llaveCorreo = correo.getText();
                atributos = new Object[7];
                atributos[0] = id.getText();
                atributos[1] = correo.getText();
                atributos[2] = empleado.getText();
                atributos[3] = funcion.getText();
                atributos[4] = telefono.getText();
                atributos[5] = llaveId;
                atributos[6] = llaveCorreo;
                query = "UPDATE DBO.EMPLEADO SET IDCLIENTE = ?, CORREOEMPLEADO = ?, NOMBREEMPLEADO = ?,"
                        + "FUNCION = ?, TELEFONOEMPLEADO = ? WHERE IDCLIENTE = ? AND CORREOEMPLEADO = ?";
                TablaDatos.executeUpdate(conexion, query, atributos);
            }
        }
        actualizar();
    }//GEN-LAST:event_aceptarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void actualizar() {
        try {
            function.run();
        } catch (Exception ex) {
            System.err.print("Error al retornar al padre");
        }
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField empleado;
    private javax.swing.JTextField funcion;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField tipo;
    // End of variables declaration//GEN-END:variables
}
