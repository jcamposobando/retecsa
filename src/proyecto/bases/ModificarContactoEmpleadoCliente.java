/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class ModificarContactoEmpleadoCliente extends javax.swing.JFrame {

    private final String con;
    private final boolean tipo;
    private final String idCliente;
    private final String correoEmpleado;
    /**
     * Creates new form modificarContactoEmpleado
     */
    public ModificarContactoEmpleadoCliente(String con, String idCliente, String[] fieldValues, boolean tipo) {
        this.con = con;
        this.tipo = tipo;
        this.idCliente = idCliente;
        this.correoEmpleado = fieldValues[0];
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        if (tipo) {
            modificar.setText("Agregar");
        } else {
            modificar.setText("Modificar");
            fieldNombre.setText(fieldValues[0]);
            fieldTelefono.setText(fieldValues[0]);
            fieldEmail.setText(fieldValues[0]);
            fieldFuncion.setText(fieldValues[0]);
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

        regresar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        labelFuncion = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldTelefono = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldFuncion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        labelFuncion.setText("Función:");

        labelEmail.setText("E-mail:");

        labelTelefono.setText("Teléfono:");

        labelNombre.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNombre)
                    .addComponent(labelTelefono)
                    .addComponent(labelEmail)
                    .addComponent(labelFuncion)
                    .addComponent(regresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 199, Short.MAX_VALUE)
                        .addComponent(modificar))
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldEmail)
                    .addComponent(fieldFuncion)
                    .addComponent(fieldNombre))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFuncion)
                    .addComponent(fieldFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresar)
                    .addComponent(modificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if (tipo) {
            Object[] parameters = {idCliente, fieldEmail.getText(), fieldNombre.getText(), fieldTelefono.getText(), fieldFuncion.getText()};
            int n = TablaDatos.executeUpdate(con, "Insert into empleado values (?,?,?,?,?)", parameters);
            if (n == 1) {
                JOptionPane.showMessageDialog(this, "Se modificó el contacto correctamente");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el contacto");
            }
        } else {
            Object[] parameters = {fieldEmail.getText(), fieldTelefono.getText(), fieldNombre.getText(), fieldFuncion.getText(), idCliente, correoEmpleado};
            int n = TablaDatos.executeUpdate(con, "update empleado "
                    + "set correoempleado = ?, telefonoempleado = ?, nombreempleado = ?, funcion= ? where idcliente = ? and correoempleado = ? ", parameters);
            if (n == 1) {
                JOptionPane.showMessageDialog(this, "Se modificó el contacto correctamente");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el contacto");
            }
        }
    }//GEN-LAST:event_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldFuncion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFuncion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JButton modificar;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
