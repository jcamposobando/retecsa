/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author b22539
 */
public class Vendedor extends javax.swing.JFrame {

    final String con;

    private String idCliente;
    private String idVend;
    private ArrayList<String> listaProductos;
    private int pTotal;
    private int cTotal;

    /**
     * Creates new form VendedorVenta
     *
     * @param conexion
     */

    public Vendedor(String con, String idVendedor, String idCliente) {
        this.con = con;
        this.idCliente = idCliente;
        listaProductos = new ArrayList<String>();
        initComponents();
        getProductList();
        idVend = idVendedor;
        cTotal = 0;
        pTotal = 0;
        String query = "SELECT * FROM PRODUCTO;";
        ResultSet rs = null;

        rs = TablaDatos.executeQuery(con, query, new Object[0]);
        try {
            tablaProductos.setModel(TablaDatos.buildTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vendedor(String con, String idVendedor) {
        this(con, idVendedor, "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        fProducto = new javax.swing.JTextField();
        fMarca = new javax.swing.JTextField();
        bCancelarVenta = new javax.swing.JButton();
        fCantidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        bCotizacion = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        fTelefono = new javax.swing.JTextField();
        fEmpleado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fIdentificacion = new javax.swing.JTextField();
        fFuncion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        fCorreo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fNombre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        fTipo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        bAgregarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fFormaDePago = new javax.swing.JTextField();
        fFecha = new javax.swing.JTextField();
        fMonto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AProductos = new javax.swing.JTextArea();
        totalPagar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bRegresar = new javax.swing.JToggleButton();
        bVender = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Cantidad:");

        bCancelarVenta.setText("Cancelar Venta");
        bCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarVentaActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaProductos);

        bCotizacion.setText("Cotización");
        bCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCotizacionActionPerformed(evt);
            }
        });

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel1.setText("Consulta:");

        jLabel6.setText("Producto:");

        jLabel7.setText("Marca:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bCotizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarVenta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(fProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bCotizacion)
                        .addGap(99, 99, 99)
                        .addComponent(bCancelarVenta))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel3);

        fEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fEmpleadoActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre:");

        jLabel14.setText("Identficación:");

        jLabel15.setText("Correo:");

        jLabel16.setText("Teléfono:");

        jLabel17.setText("Tipo:");

        jLabel18.setText("Empleado:");

        fTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fTipoActionPerformed(evt);
            }
        });

        jLabel19.setText("Función:");

        bAgregarCliente.setText("Agregar Cliente");
        bAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAgregarCliente)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fNombre)
                            .addComponent(fIdentificacion)
                            .addComponent(fCorreo)
                            .addComponent(fTelefono)
                            .addComponent(fEmpleado)
                            .addComponent(fFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(fTipo))))
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(fIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(fFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bAgregarCliente)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel4);

        jLabel3.setText("Froma de pago:");

        jLabel4.setText("Monto:");

        fFormaDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFormaDePagoActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha:");

        AProductos.setEditable(false);
        AProductos.setColumns(20);
        AProductos.setRows(5);
        jScrollPane1.setViewportView(AProductos);

        totalPagar.setEditable(false);

        jLabel8.setText("Total a pagar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fMonto)
                            .addComponent(fFormaDePago)
                            .addComponent(fFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(totalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fFormaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Venta", jPanel2);

        bRegresar.setText("Regresar");
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });

        bVender.setText("Vender");
        bVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVenderActionPerformed(evt);
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
                        .addComponent(bRegresar)
                        .addGap(219, 219, 219)
                        .addComponent(bVender, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bVender)
                    .addComponent(bRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fEmpleadoActionPerformed

    private void fTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fTipoActionPerformed

    private void bCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCotizacionActionPerformed
        // TODO add your handling code here:
        cotizacion(fProducto.getText(), fMarca.getText(), fCantidad.getText());
        fProducto.setText("");
        fMarca.setText("");
        fCantidad.setText("");
    }//GEN-LAST:event_bCotizacionActionPerformed

    private void bCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarVentaActionPerformed
        cancelarVenta();
    }//GEN-LAST:event_bCancelarVentaActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_bRegresarActionPerformed

    private void bAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarClienteActionPerformed
        ingresarCliente(fTipo.getText(), fNombre.getText(), fIdentificacion.getText(), fCorreo.getText(), fTelefono.getText(), fEmpleado.getText(), fFuncion.getText());
        fTipo.setText("");
        fNombre.setText("");
        fIdentificacion.setText("");
        fCorreo.setText("");
        fTelefono.setText("");
        fEmpleado.setText("");
        fFuncion.setText("");
    }//GEN-LAST:event_bAgregarClienteActionPerformed

    private void fFormaDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFormaDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFormaDePagoActionPerformed

    private void bVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVenderActionPerformed
        venta(fMonto.getText(), fFormaDePago.getText());
        fFecha.setText("");
        fMonto.setText("");
        fFormaDePago.setText("");
    }//GEN-LAST:event_bVenderActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        String text = jTextField7.getText(); 
        filtrar(text.equals("") ? ".*" : "(?i)" + text);
    }//GEN-LAST:event_jTextField7KeyTyped

    public void buscar(String busqueda) {

    }

    public void cotizacion(String producto, String marca, String cantidad) {
        //boolean exito = true;
        //Integer cant = Integer.valueOf(cantidad);
        //PreparedStatement stmt = null;
        ResultSet rs = null;
        int iCantidad = Integer.parseInt(cantidad);
        Object[] precioCosto = {producto, marca};
        rs = TablaDatos.executeQuery(con, "SELECT PRECIODEVENTA, COSTOUNIDAD, NOMBREPROVEEDOR FROM DBO.PRODUCTO WHERE NOMBREPRODUCTO = ? AND MARCAPRODUCTO = ? AND EXISTENCIA > 0", precioCosto);
        int pProducto = 0;
        String prov = "";
        try {
            while (rs.next()) {
                pProducto = rs.getInt(1);
                cTotal += rs.getInt(2);
                
            }
            int totalProducto = pProducto * iCantidad;
            pTotal += totalProducto;
            listaProductos.add(producto + "," + marca +","+ prov + "," + cantidad);  
            AProductos.append("Producto: " + producto + "   Marca: " + marca + "   Cantidad: " + cantidad + "   Precio: " + totalProducto + "\n");
            totalPagar.setText(String.valueOf(pTotal));
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cancelarVenta() {
        listaProductos.clear();
        AProductos.setText("");
        totalPagar.setText("");
        idCliente = "";
        pTotal = 0;
        cTotal = 0;
    }

    public void ingresarCliente(String tipo, String nombre, String identificacion, String correo, String telefono, String empleado, String funcion) {
        //boolean exito = true;
        idCliente = identificacion;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(this.con);
            stmt = con.prepareStatement("SELECT IDCLIENTE FROM DBO.CLIENTE WHERE IDCLIENTE = ?;");
            stmt.setString(1, identificacion);
            rs = stmt.executeQuery();
            stmt.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el driver jdbc");
            e.printStackTrace();
        } catch (SQLException e) {
            stmt = null;
            rs = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection(this.con);
                stmt = con.prepareStatement("INSERT INTO DBO.CLIENTE VALUES(?,?,?);");
                stmt.setString(1, tipo);
                stmt.setInt(2, 3);
                stmt.setString(3, nombre);
                rs = stmt.executeQuery();
                stmt.close();
                rs.close();
                con.close();
            } catch (ClassNotFoundException er) {
                System.err.println("No se encontro el driver jdbc");
                er.printStackTrace();
            } catch (SQLException er) {
                System.err.println("Error al insertar");
                er.printStackTrace();
            }
            if (tipo.toUpperCase().equals("empleado".toUpperCase())) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection con = DriverManager.getConnection(this.con);
                    stmt = con.prepareStatement("INSERT INTO DBO.EMPLEADO VALUES(?,?,?,?,?);");
                    stmt.setString(1, identificacion);
                    stmt.setString(2, correo);
                    stmt.setString(3, empleado);
                    stmt.setString(4, funcion);
                    stmt.setString(5, telefono);
                    rs = stmt.executeQuery();
                    stmt.close();
                    rs.close();
                    con.close();
                } catch (ClassNotFoundException er) {
                    System.err.println("No se encontro el driver jdbc");
                    er.printStackTrace();
                } catch (SQLException error) {
                    System.err.println("Error al insertar");
                    error.printStackTrace();
                }
            } else if (tipo.toUpperCase().equals("particular".toUpperCase())) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection con = DriverManager.getConnection(this.con);
                    stmt = con.prepareStatement("INSERT INTO DBO.PARTICULR VALUES(?,?,?,?,?,?,?);");
                    stmt.setString(1, identificacion);
                    stmt.setString(2, correo);
                    stmt.setString(3, telefono);
                    rs = stmt.executeQuery();
                    stmt.close();
                    rs.close();
                    con.close();
                } catch (ClassNotFoundException er) {
                    System.err.println("No se encontro el driver jdbc");
                    er.printStackTrace();
                } catch (SQLException error) {
                    System.err.println("Error al insertar");
                    error.printStackTrace();
                }
            }
        }
        //return exito;
    }

    public void venta(String monto, String formaPago) {
        
        int m = Integer.parseInt(monto);   
        CallableStatement cs = null;

        String proceso = "{call CREARVENTA (?,?,?,?,?,?)}";

	try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(this.con);
            cs = con.prepareCall(proceso);
            cs.setString(1, "33445566");
            cs.setString(2, idCliente);
            cs.setString(3, formaPago);
            cs.setFloat(4, pTotal);
            cs.setFloat(5, cTotal);
            cs.setFloat(6, m);

            cs.execute();
            cs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String datos;
        Integer cant = 0;
        String producto = "";
        String marca = "";
        String proveedor = "";
        for (int i = 0; i < listaProductos.size(); i++) {

        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(this.con);
            String query = "INSERT INTO DBO.SEVENDE VALUES "
                    + String.join(",", Collections.nCopies(listaProductos.size(), "(?,?,?,?,?,?)"));
            stmt = con.prepareStatement(query);
            System.err.println(query);
            for (int i = 0; i < listaProductos.size(); i++) {
                datos = listaProductos.get(i);
                String[] dat = datos.split("\\s*,\\s*");
                producto = dat[0];
                marca = dat[1];
                proveedor = dat[2];
                cant = Integer.valueOf(dat[3]);
                stmt.setString(i + 1, proveedor);
                stmt.setString(i + 2, producto);
                stmt.setString(i + 3, marca);
                stmt.setInt(i + 4, 444);                       //Cambiar por numero de venta
                stmt.setString(i + 5, idVend);
                stmt.setInt(i + 6, cant);
            }
            rs = stmt.executeQuery();
            stmt.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el driver jdbc");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
        //return exito;
    }

    public void filtrar(String texto) {
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaProductos.getModel());
        tablaProductos.setRowSorter(sorter);
        if (texto.length() != 0) {
            sorter.setRowFilter(RowFilter.regexFilter(texto));

        } else {
            sorter.setRowFilter(null);

        }
    }

    private ArrayList<String> getProductList() {
        return listaProductos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AProductos;
    private javax.swing.JButton bAgregarCliente;
    private javax.swing.JButton bCancelarVenta;
    private javax.swing.JButton bCotizacion;
    private javax.swing.JToggleButton bRegresar;
    private javax.swing.JButton bVender;
    private javax.swing.JTextField fCantidad;
    private javax.swing.JTextField fCorreo;
    private javax.swing.JTextField fEmpleado;
    private javax.swing.JTextField fFecha;
    private javax.swing.JTextField fFormaDePago;
    private javax.swing.JTextField fFuncion;
    private javax.swing.JTextField fIdentificacion;
    private javax.swing.JTextField fMarca;
    private javax.swing.JTextField fMonto;
    private javax.swing.JTextField fNombre;
    private javax.swing.JTextField fProducto;
    private javax.swing.JTextField fTelefono;
    private javax.swing.JTextField fTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField totalPagar;
    // End of variables declaration//GEN-END:variables
}
