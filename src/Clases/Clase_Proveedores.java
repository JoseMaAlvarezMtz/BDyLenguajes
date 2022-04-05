package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clase_Proveedores {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_PROVEEDOR = "INSERT INTO Proveedor (idProveedor, nombre_Proveedor,"
            + "telefono_Proveedor, telefono2_Proveedor, direccion_Proveedor, email_Proveedor, descripcion_Proveedor) values (?,?,?,?,?,?,?)";
    private final String SQL_SELECT_PROVEEDOR = "SELECT *FROM Proveedor";
    
    public Clase_Proveedores(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosProveedor(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DT.addColumn("Codigo");
        DT.addColumn("Nombre");
        DT.addColumn("Telefono");
        DT.addColumn("Telfono no. 2");
        DT.addColumn("Direccion");
        DT.addColumn("Email");
        DT.addColumn("Descripcion");
        
        return DT;
    }
    
    public DefaultTableModel getDatosProveedores(){
        try {
            setTitulosProveedor();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PROVEEDOR);
            RS = PS.executeQuery();
            Object[] fila = new Object[7];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
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
    
    public int registrarProveedor(String codigo, String nombre_prove, String telefono, String telefono2, String direccion, String email, String descripcion){
        int res=0;
        
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_PROVEEDOR);
            PS.setString(1, codigo);
            PS.setString(2, nombre_prove);
            PS.setString(3, telefono);
            PS.setString(4, telefono2);
            PS.setString(5, direccion);
            PS.setString(6, email);
            PS.setString(7, descripcion);
          //  PS.setString(8, nombreproveedor);
            
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Proveedor registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el proveedor.");
            System.err.println("Error al registrar el proveedor." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    
    public void insertarProveedor(String codigoProveedor){
        int res;
        try {
            PS = CN.getConnection().prepareStatement("CALL NUEVO_PROVEEDOR('"+codigoProveedor+"')");
            PS.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al insertar registro en la tabla inventario." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
    } 
    
       public int verificarCodigoProveedor(String codigo){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT count(idProveedor) from Proveedor where idProveedor='"+codigo+"'");
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
    } 
    
    
    public int actualizarProveedor(String codigo, String nombre_prove, String telefono, String telefono2, String direccion, String email, String descripcion,  String codigo_old){
        String SQL = "UPDATE Proveedor SET idProveedor='"+codigo+"',nombre_Proveedor='"+nombre_prove+"',telefono_Proveedor='"+telefono+"',telefono2_Proveedor='"+telefono2+"',direccion_Proveedor='"+direccion+"',email_Proveedor='"+email+"',descripcion_Proveedor='"+descripcion+"' WHERE idProveedor='"+codigo_old+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Proveedor actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del cliente." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public int eliminarProveedor(String codigo){
        String SQL = "DELETE from Proveedor WHERE idProveedor ='"+codigo+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el proveedor.");
            System.err.println("Error al eliminar el proveedor." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
