/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Fernando
 */
public class BorrarEmpleados extends javax.swing.JFrame {
    private String conexion;
    private String cliente;
    private Object[][] tuplaEmpleado = new Object[0][0];
    private int filasEmpleado;
    /**
     * Creates new form BorrarEmpleados
     */
    public BorrarEmpleados(String conexion,Object[][] cliente) {
        this.conexion = conexion;
        this.cliente = cliente[0][0].toString();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        Object[] atributos = new Object[1];
        atributos[0] = this.cliente;
        String consulta = "SELECT * FROM DBO.EMPLEADO WHERE IDCLIENTE = ?"; 
        ResultSet rs = TablaDatos.executeQuery(conexion, consulta, atributos);
        try{
        empleados.setModel(TablaDatos.buildTableModel(rs));
        }catch(Exception e){
            System.err.println("No se encontro tabla");
        }
        empleados.setEnabled(empleados.getSelectedRowCount() == 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        empleados = new javax.swing.JTable();
        regresar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        empleados.setModel(new javax.swing.table.DefaultTableModel(
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
        empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                empleadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(empleados);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresar)
                    .addComponent(eliminar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empleadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleadosMouseReleased
        int[] row = empleados.getSelectedRows();
        filasEmpleado = row.length;
        tuplaEmpleado = new String[filasEmpleado][5];
        for(int i = 0; i < filasEmpleado; i++){
            for(int j = 0; j < 5; j++){
                tuplaEmpleado[i][j] = empleados.getValueAt(row[i], j);
            } 
        }
    }//GEN-LAST:event_empleadosMouseReleased

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar a estos empleados?") == 0) {
            for(int i = 0; i < tuplaEmpleado.length; i++){
                String query = "DELETE FROM EMPLEADO WHERE IDCLIENTE = ? AND CORREOEMPLEADO = ? AND NOMBREEMPLEADO = ?"
                        + "AND FUNCION = ? AND TELEFONOEMPLEADO = ?";
                TablaDatos.executeUpdate(conexion, query, tuplaEmpleado[i]);
            }
            cargar(empleados, "EMPLEADO");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void cargar(JTable tipo, String tabla) {
        String consulta = "SELECT * FROM DBO." + tabla; 
        ResultSet rs = TablaDatos.executeQuery(conexion, consulta, new Object[0]);
        try{
        tipo.setModel(TablaDatos.buildTableModel(rs));
        }catch(Exception e){
            System.err.println("No se encontro tabla");
        }
        tipo.setEnabled(tipo.getSelectedRowCount() == 0);
        //boton.setEnabled(tipo.getSelectedRowCount() != 0);
    }
    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JTable empleados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}