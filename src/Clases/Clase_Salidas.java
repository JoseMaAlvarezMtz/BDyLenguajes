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
    private final String SQL_INSERT_ENTRADAS = "INSERT INTO Entradas (idProducto, nom_Producto,"
            + "descripcion_Producto, precio_Producto, precio_sugerido, fecha_registro) values (?,?,?,?,?,?)";
    private final String SQL_SELECT_ENTRADAS = "SELECT *FROM Entradas";
    
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
        DT.addColumn("Codigo del producto");
        DT.addColumn("Fecha de entrada");
        DT.addColumn("Cantidad");
        DT.addColumn("Proveedor");
        return DT;
    }
    
    public DefaultTableModel getDatosEntradas(){
        try {
            setTitulosEntradas();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_ENTRADAS);
            RS = PS.executeQuery();
            Object[] fila = new Object[4];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getDate(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
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
    
    public int registrarEntrada(String codigo, Date fecharegistro, String cantidad, Integer proveedor){
        int res=0;
        
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_ENTRADAS);
            PS.setString(1, codigo);
            PS.setDate(2, fecharegistro);
            PS.setString(3, cantidad);
            PS.setInt(4, proveedor);
            
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Entrada registrada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
            System.err.println("Error al registrar la entrada." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    
    /*public void insertarProductoInventario(String codigoProducto){
        int res;
        try {
            PS = CN.getConnection().prepareStatement("CALL NUEVO_PRODUCTO('"+codigoProducto+"')");
            PS.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al insertar registro en la tabla inventario." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
    } */
    
    /*public int verificarCodigoInventario(String codigo){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT count(codigo_Inventario) from Inventario where codigo_Inventario='"+codigo+"'");
            RS = PS.executeQuery();
           
            while(RS.next()){
                res = RS.getInt(1);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }*/
    
    
    /*public int actualizarEntrada(String codigo, Date fecharegistro,  String categoria, Integer idProveedor){
        String SQL = "UPDATE Entradas SET codigo_Entrada='"+codigo+"',fecha_registro='"+fecharegistro+"' WHERE idProducto='"+codigo_old+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del cliente." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }*/
    
    public int eliminarEntrada(String codigo){
        String SQL = "DELETE from Entrada WHERE idEntradas ='"+codigo+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el producto.");
            System.err.println("Error al eliminar producto." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
