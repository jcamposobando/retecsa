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
    
    public AdminVendedor(String conexion){
        this.conexion = conexion;
    }
    
    public void insertarVendedor(String identificacion, String nombre){
        Integer id = Integer.valueOf(identificacion);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conexion);
            stmt = con.prepareStatement("INSERT INTO VENDEDOR VALUES(?,?)");
            stmt.setInt(1, id);
            stmt.setString(2,nombre);
            rs = stmt.executeQuery();

        }catch(ClassNotFoundException  e){
            System.out.println("No se encontro el driver jdbc");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
    }
    
    public void actualizarVendedor(String identificacion, String nombre){
        Integer id = Integer.valueOf(identificacion);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conexion);
            stmt = con.prepareStatement("UPDATE VENDEDOR SET NOMBREVENDEDOR = ? WHERE IDVENDEDOR = ?");
            stmt.setString(1, nombre);
            stmt.setInt(2,id);
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
