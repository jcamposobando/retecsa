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
    private final Connection con;
    
    public AdminVendedor(Connection con){
        this.con = con;
    }
    
    public boolean insertarVendedor(String identificacion, String nombre){
        boolean exito = true;
        Integer id = Integer.valueOf(identificacion);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement("INSERT INTO VENDEDOR VALUES(?,?)");
            stmt.setInt(1, id);
            stmt.setString(2,nombre);
            rs = stmt.executeQuery();

        }catch(SQLException e){
            System.out.println("Error al insertar");
            e.printStackTrace();
        }
        return exito;
    }
}
