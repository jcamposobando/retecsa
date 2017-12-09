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
public class AdminProveedor {
     private final String conexion;
    
    public AdminProveedor(String conexion){
        this.conexion = conexion;
    }
    
    public void insertarProveedor(String nombre, String telefono, String correo){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conexion);
            stmt = con.prepareStatement("INSERT INTO PROVEEDOR VALUES(?,?,?)");
            stmt.setString(1, nombre);
            stmt.setString(2,telefono);
            stmt.setString(3,correo);
            rs = stmt.executeQuery();

        }catch(ClassNotFoundException  e){
            System.out.println("No se encontro el driver jdbc");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
    }
    
    public void borrarProveedor(String nombre,String telefono,String correo){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conexion);
            if(!nombre.equals("") && !telefono.equals("") && !correo.equals("")){
                stmt = con.prepareStatement("DELETE FROM PROVEEDOR WHERE NOMBREPROVEEDOR = ? AND TELEFONOPROVEEDOR = ? AND CORREOPROVEEDOR = ?");
                stmt.setString(1, nombre);
                stmt.setString(2, telefono);
                stmt.setString(3, correo);
                rs = stmt.executeQuery();
            }else if(nombre.equals("") && !telefono.equals("") && !correo.equals("")){
                stmt = con.prepareStatement("DELETE FROM PROVEEDOR WHERE NOMBREPROVEEDOR = ?");
                stmt.setString(1, nombre);
                rs = stmt.executeQuery();
            }else if(!nombre.equals("") && telefono.equals("") && !correo.equals("")){
                stmt = con.prepareStatement("DELETE FROM PROVEEDOR WHERE TELEFONOPROVEEDOR = ?");
                stmt.setString(1, telefono);
                rs = stmt.executeQuery();
            }
        }catch(ClassNotFoundException  e){
            System.out.println("No se encontro el driver jdbc");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Error al borrar");
            e.printStackTrace();
        }
    }
    
    
    public void actualizarProveedor(String nombre, String telefono, String correo){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conexion);
            stmt = con.prepareStatement("UPDATE VENDEDOR SET NOMBREVENDEDOR = ? WHERE IDVENDEDOR = ?");
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();

        }catch(ClassNotFoundException  e){
            System.out.println("No se encontro el driver jdbc");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
    }
}
