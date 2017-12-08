/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.*;

/**
 *
 * @author b32973
 */
public class AdminVendedor {
    private final String conexion;
    
    public AdminVendedor(String conectado){
        conexion = conectado;
    }
    
    public boolean incertarVendedor(String identificacion, String nombre){
        boolean exito = true;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(conexion); 
            String SQL = "SELECT NOMBREPRODUCTO,MARCAPRODUCTO,CODIGODEFABRICA,EXISTENCIA,PRECIODEVENTA FROM dbo.PRODUCTO";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

        }catch(Exception e){
        }
        return exito;
    }
}
