/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexion.Conectar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pelon
 */
public class Clase_Salidas {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_SALIDAS = "INSERT INTO Salidas (codigo_Salida, fecha_Salida,"
            + "cantidad_Salida, idCliente) values (?,?,?,?)";
    private final String SQL_SELECT_SALIDAS = "SELECT *FROM Salidas";
    
    public Clase_Salidas(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosEntradas(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DT.addColumn("Codigo Salida");
        DT.addColumn("Codigo del producto");
        DT.addColumn("Fecha de salida");
        DT.addColumn("Cantidad");
        DT.addColumn("Cliente");
        return DT;
    }
    
    public DefaultTableModel getDatosEntradas(){
        try {
            setTitulosEntradas();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDAS);
            RS = PS.executeQuery();
            Object[] fila = new Object[5];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getDate(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }
    
    public int registrarEntrada(String codigo, Date fecharegistro, String cantidad, Integer cliente){
        int res=0;
        
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_SALIDAS);
            PS.setString(1, codigo);
            PS.setDate(2, fecharegistro);
            PS.setString(3, cantidad);
            PS.setInt(4, cliente);
            
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Salida registrada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la salida.");
            System.err.println("Error al registrar la salida." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public int actualizarEntrada(Integer idEntrada, String codigo, Date fecharegistro,  String cantidad, Integer idProveedor){
        String SQL = "UPDATE Salidas SET codigo_Salida='"+codigo+"',fecha_Salida='"+fecharegistro+"',cantidad_Salida='"+cantidad+"',idCliente='"+idProveedor+"' WHERE idSalidas='"+idEntrada+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Salida actualizada con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public int eliminarEntrada(String codigo){
        String SQL = "DELETE from Salidas WHERE idSalidas ='"+codigo+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Salida eliminada con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar la salida.");
            System.err.println("Error al eliminar la salida." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
