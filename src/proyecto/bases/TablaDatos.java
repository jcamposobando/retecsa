/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author b45818
 */
public class TablaDatos {

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            } //cierra isCellEditable
        };//cierra return DefaultTableModel
    }//cierra buildTableModel

    public static int executeUpdate(String conection, String query, Object[] parameters) {
        int numberOfModifiedRows = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conection);
            PreparedStatement stmt = con.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            };
            numberOfModifiedRows = stmt.executeUpdate();
            con.close();
            stmt.close();
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el driver jdbc");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error ");
            e.printStackTrace();
        }
        return numberOfModifiedRows;
    }

    public static ResultSet executeQuery(String conection, String query, Object[] parameters) {
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conection);
            PreparedStatement stmt = con.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            };
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el driver jdbc");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error ");
            e.printStackTrace();
        }
        return rs;
    }
}
