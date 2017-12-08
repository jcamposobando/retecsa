/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

/**
 *
 * @author b32973
 */
public class Conexion {
    
    private final String conexion;
    
    public Conexion(String user, char[] password){
        String contrasena = String.valueOf(password);
        conexion = "jdbc:sqlserver://172.16.202.39:1433;"
                + "databaseName=Inventario;user="+user+";password="+contrasena;
    }
    
    public String getConexion(){
        return conexion;
    }
    
}
