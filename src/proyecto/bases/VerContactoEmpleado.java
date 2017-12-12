/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Juan
 */
public class VerContactoEmpleado extends javax.swing.JFrame {

    final String con;
    final String idCliente;

    /**
     * Creates new form verContacto
     */
    public VerContactoEmpleado(String con, String idCliente) {
        this.idCliente = idCliente;
        this.con = con;
        initComponents();
        loadTablaContactos();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void loadTablaContactos() {
        Object[] parameters = {idCliente};
        ResultSet rs = TablaDatos.executeQuery(con, "SELECT nombreempleado,funcion,correoempleado,telefonoempleado FROM DBO.empleado "
                + "where empleado.idcliente = ?",
                parameters);
        try {
            DefaultTableModel tb = TablaDatos.buildTableModel(rs);
            tablaContacto.setModel(tb);
            tablaContacto.setRowSorter(new TableRowSorter<DefaultTableModel>(tb));
        } catch (SQLException e) {
            System.err.println("Error al leer el resultado de un query");
            e.printStackTrace();
        }
        updateFilter();
    }

    private void updateFilter() {
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tablaContacto.getRowSorter();
        String text = fieldBuscar.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text.equals("") ? ".*" : "(?i)" + text));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificar = new javax.swing.JButton();
        labelBuscar = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContacto = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        labelBuscar.setText("Buscar:");

        fieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscarActionPerformed(evt);
            }
        });
        fieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBuscarKeyTyped(evt);
            }
        });

        tablaContacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaContacto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaContacto);

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(agregar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        String[] parameters = {
            tablaContacto.getValueAt(tablaContacto.getSelectedRow(), 0).toString(),
            tablaContacto.getValueAt(tablaContacto.getSelectedRow(), 3).toString(),
            tablaContacto.getValueAt(tablaContacto.getSelectedRow(), 2).toString(),
            tablaContacto.getValueAt(tablaContacto.getSelectedRow(), 1).toString()};
        ModificarContactoEmpleadoCliente mcce = new ModificarContactoEmpleadoCliente(
                con,
                idCliente,
                parameters,
                false
        );
        mcce.setVisible(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void fieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscarActionPerformed
        updateFilter();
    }//GEN-LAST:event_fieldBuscarActionPerformed

    private void fieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscarKeyTyped
        updateFilter();
    }//GEN-LAST:event_fieldBuscarKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Object[] parameters = {idCliente, tablaContacto.getValueAt(tablaContacto.getSelectedRow(), 2)};
        int n = TablaDatos.executeUpdate(con, "delete from empleado where idcliente= ? and correoempleado = ?", parameters);
        if (n == 1) {
            JOptionPane.showMessageDialog(this, "Se eliminó el contacto correctamente");
            loadTablaContactos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el contacto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        String[] parameters = {"","","",""};
        ModificarContactoEmpleadoCliente mcce = new ModificarContactoEmpleadoCliente(
                con,
                idCliente,
                parameters,
                true
        );
        mcce.setVisible(true);
    }//GEN-LAST:event_agregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tablaContacto;
    // End of variables declaration//GEN-END:variables
}
