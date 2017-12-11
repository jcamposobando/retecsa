/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.ResultSet;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author b45818
 */
public class VerVentas extends javax.swing.JFrame {

    String con;
    String idCliente;

    /**
     * Creates new form VerVentas
     */
    public VerVentas(String con, String idCliente) {
        this.con = con;
        this.idCliente = idCliente;
        initComponents();
        loadTablaVentas();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void loadTablaVentas() {
        ResultSet rs = TablaDatos.executeQuery(con, "SELECT nombreVendedor,idvendedor,numerodeventa,fechadeventa,pagatotal FROM DBO.Venta, DBO.Cliente, DBO.Vendedor where venta.idcliente=cliente.idcliente and venta.idvendedor = vendedor.idvendedor", new Object[0]);
        try {
            DefaultTableModel tb = TablaDatos.buildTableModel(rs);
            tablaVentas.setModel(tb);
            tablaVentas.setRowSorter(new TableRowSorter<DefaultTableModel>(tb));
        } catch (Exception e) {
        };
        updateFilter();
        verDetalle.setEnabled(tablaVentas.getSelectedRowCount() == 1);
    }

    private void updateFilter() {
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tablaVentas.getRowSorter();
        sorter.setRowFilter(RowFilter.regexFilter(fieldBuscar.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        verDetalle = new javax.swing.JButton();
        fieldBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPane.setViewportView(tablaVentas);

        verDetalle.setText("Ver Detalle");
        verDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDetalleActionPerformed(evt);
            }
        });

        fieldBuscar.setText("jTextField1");

        jLabel1.setText("Buscar: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verDetalle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verDetalle)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDetalleActionPerformed
        VerDetalleVenta verDetalleVenta = new VerDetalleVenta(con,
                tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0).toString(),
                (Integer) tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 2));
        verDetalleVenta.setVisible(true);
        verDetalleVenta.setTitle("Venta "
                + tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 2).toString()
                + "de "
                + tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_verDetalleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JButton verDetalle;
    // End of variables declaration//GEN-END:variables
}
