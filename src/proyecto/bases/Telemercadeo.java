/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author b22539
 */
public class Telemercadeo extends javax.swing.JFrame {

    final String con;

    /**
     * Creates new form Telemercadeo
     */
    public Telemercadeo(String con) {
        this.con = con;
        initComponents();
        loadClientList();
    }

    private void deleteClientsFromDatabase() {
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar a estos usuarios?") == 0) {
            Integer[] selectedClients = Arrays.stream(tablaClientes.getSelectedRows()).boxed().toArray(Integer[]::new);
            String query = "DELETE FROM DBO.CLIENTE WHERE "
                    + String.join(" OR ", Collections.nCopies(selectedClients.length, " CLIENTE.IDCLIENTE = ?"));
            Object[] parameters = (Arrays.asList(selectedClients)).stream().map(e -> tablaClientes.getValueAt(e, 0)).toArray();
            int n = TablaDatos.executeUpdate(con, query, parameters);
            JOptionPane.showMessageDialog(null, "Se eliminaron exitosamente " + n + " clientes.");
            loadClientList();
        }
    }

    private void loadClientList() {
        ResultSet rs = TablaDatos.executeQuery(con, "SELECT cliente.idcliente, prioridadcliente, nombrecliente, MontoCompras, CantidaddeCompras "
                + "FROM DBO.CLIENTE, "
                + "(select idcliente, sum(pagatotal) as MontoCompras, count(pagatotal) as CantidaddeCompras from dbo.venta group by idcliente) as cantidadventas "
                + "where cliente.idCliente = cantidadventas.idcliente",
                new Object[0]);
        try {
            DefaultTableModel tb = TablaDatos.buildTableModel(rs);
            tablaClientes.setModel(tb);
            tablaClientes.setRowSorter(new TableRowSorter<>(tb));
        } catch (SQLException e) {
            System.err.println("Error al leer el resultado de un query");
            e.printStackTrace();
        }
        updateFilter();
        actualizar.setEnabled(tablaClientes.getSelectedRowCount() == 1);
        eliminar.setEnabled(tablaClientes.getSelectedRowCount() != 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        verVentas = new javax.swing.JButton();
        verContacto = new javax.swing.JButton();
        fieldBuscar = new javax.swing.JTextField();
        labelBuscar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        agregar.setText("Agregar");
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
        });

        actualizar.setText("Modificar");
        actualizar.setEnabled(false);
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        verVentas.setText("Ver Ventas");
        verVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verVentasActionPerformed(evt);
            }
        });

        verContacto.setText("Ver Contacto");
        verContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verContactoActionPerformed(evt);
            }
        });

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

        labelBuscar.setText("Buscar:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(verVentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldBuscar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBuscar))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(actualizar)
                    .addComponent(eliminar)
                    .addComponent(verVentas)
                    .addComponent(verContacto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        deleteClientsFromDatabase();
        loadClientList();
    }//GEN-LAST:event_eliminarActionPerformed

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
        ModificarCliente nuevoCliente = new ModificarCliente(() -> {
            loadClientList();
        }, true, con);
        nuevoCliente.setVisible(true);
    }//GEN-LAST:event_agregarMouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        String[] clientData = {tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString(),
            tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString(),
            tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 2).toString()};
        ModificarCliente nuevoCliente = new ModificarCliente(clientData, () -> {
            loadClientList();
        }, false, con);
        nuevoCliente.setVisible(true);
    }//GEN-LAST:event_actualizarActionPerformed


    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        actualizar.setEnabled(tablaClientes.getSelectedRowCount() == 1);
        eliminar.setEnabled(tablaClientes.getSelectedRowCount() != 0);
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void verVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verVentasActionPerformed
        VerVentas verVentas = new VerVentas(con, tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
        verVentas.setVisible(true);
    }//GEN-LAST:event_verVentasActionPerformed

    private void fieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscarActionPerformed
        updateFilter();
    }//GEN-LAST:event_fieldBuscarActionPerformed

    private void fieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscarKeyTyped
        updateFilter();
    }//GEN-LAST:event_fieldBuscarKeyTyped

    private void verContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verContactoActionPerformed
        VerContacto verContacto = new VerContacto(con,tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString());
        verContacto.setVisible(true);
    }//GEN-LAST:event_verContactoActionPerformed

    private void updateFilter() {
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tablaClientes.getRowSorter();
        String text = fieldBuscar.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text.equals("") ? ".*" : "(?i)" + text));
    }

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
            java.util.logging.Logger.getLogger(Telemercadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telemercadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telemercadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telemercadeo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telemercadeo("jdbc:sqlserver://172.16.202.39:1433;"
                        + "databaseName=Inventario;user=admin;password=123456").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JButton verContacto;
    private javax.swing.JButton verVentas;
    // End of variables declaration//GEN-END:variables
}
