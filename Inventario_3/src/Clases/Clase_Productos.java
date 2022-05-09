package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clase_Productos {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_PRODUCTOS = "INSERT INTO Producto (idProducto, nom_Producto,"
            + "descripcion_Producto, precio_Producto, precio_sugerido, fecha_registro, idProveedor) values (?,?,?,?,?,?,?)";
    private final String SQL_SELECT_PRODUCTOS = "SELECT *FROM Producto";
    
    public Clase_Productos(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosProductos(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DT.addColumn("Codigo");
        DT.addColumn("Nombre");
        DT.addColumn("Descripción");
        DT.addColumn("Precio");
        DT.addColumn("Precio sugerido");
        DT.addColumn("Fecha de registro");
        DT.addColumn("Codigo del Proveedor");
      //  DT.addColumn("Nombre del Proveedor");
        
        return DT;
    }
    
    public DefaultTableModel getDatosProductos(){
        try {
            setTitulosProductos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PRODUCTOS);
            RS = PS.executeQuery();
            Object[] fila = new Object[7];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getDate(6);
                fila[6] = RS.getString(7);
           //     fila[7] = RS.getString(8);
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
    
    public int registrarProducto(String codigo, String nombre, String descripcion, String precio, String preciosugerido, Date fecharegistro, String codigoproveedor){
        int res=0;
        
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_PRODUCTOS);
            PS.setString(1, codigo);
            PS.setString(2, nombre);
            PS.setString(3, descripcion);
            PS.setString(4, precio);
            PS.setString(5, preciosugerido);
            PS.setDate(6, fecharegistro);
            PS.setString(7, codigoproveedor);
          //  PS.setString(8, nombreproveedor);
            
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Producto registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el producto.");
            System.err.println("Error al registrar el producto." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    
    public void insertarProductoInventario(String codigoProducto){
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
    } 
    
    public int verificarCodigoInventario(String codigo){
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
    }
    
    
    public int actualizarProducto(String codigo, String nombre, String descripcion, String precio, String preciosugerido, Date fecharegistro, String codigoproveedor,  String codigo_old){
        String SQL = "UPDATE Producto SET idProducto='"+codigo+"',nom_Producto='"+nombre+"',descripcion_Producto='"+descripcion+"',precio_Producto='"+precio+"',precio_sugerido='"+preciosugerido+"',fecha_registro='"+fecharegistro+"',idProveedor='"+codigoproveedor+"' WHERE idProducto='"+codigo_old+"'";
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
    }
    
    public int eliminarProducto(String codigo){
        String SQL = "DELETE from Producto WHERE idProducto ='"+codigo+"'";
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
