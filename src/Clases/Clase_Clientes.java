package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clase_Clientes {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_CLIENTE = "INSERT INTO Cliente (idCliente, nombre_Cliente, apellido_Cliente, apellido2_Cliente,"
            + "telefono_Cliente, direccion_Cliente, email_Cliente) values (?,?,?,?,?,?,?)";
    private final String SQL_SELECT_CLIENTE = "SELECT *FROM Cliente";
    
    public Clase_Clientes(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosCliente(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DT.addColumn("Codigo");
        DT.addColumn("Nombre");
        DT.addColumn("Apellido Paterno");
        DT.addColumn("Apellido Materno");
        DT.addColumn("Telefono");
       // DT.addColumn("Telfono no. 2");
        DT.addColumn("Email");
        DT.addColumn("Direccion");
        
        return DT;
    }
    
    public DefaultTableModel getDatosClientes(){
        try {
            setTitulosCliente();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_CLIENTE);
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
             //   fila[7] = RS.getString(8);
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
    
    public int registrarCliente(String codigo, String nombre_cliente, String apellido1, String apellido2, String telefono, String email, String direccion){
        int res=0;
        
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_CLIENTE);
            PS.setString(1, codigo);
            PS.setString(2, nombre_cliente);
            PS.setString(3, apellido1);
            PS.setString(4, apellido2);
            PS.setString(5, telefono);
         //   PS.setString(6, telefono2);
            PS.setString(6, email);
            PS.setString(7, direccion);
            
            
          //  PS.setString(8, nombreCliente);
            
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente.");
            System.err.println("Error al registrar el cliente." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    
    public void insertarCliente(String codigoCliente){
        int res;
        try {
            PS = CN.getConnection().prepareStatement("CALL NUEVO_CLIENTE('"+codigoCliente+"')");
            PS.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al insertar registro en la tabla inventario." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
    } 
    
       public int verificarCodigoCliente(String codigo){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT count(idCliente) from Cliente where idCliente='"+codigo+"'");
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
    
    
    public int actualizarCliente(String codigo, String nombre_cliente, String apellido1, String apellido2, String telefono, String email, String direccion, String codigo_old){
        String SQL = "UPDATE Cliente SET idCliente='"+codigo+"',nombre_Cliente='"+nombre_cliente+"',apellido_Cliente='"+apellido1+"',apellido2_Cliente='"+apellido2+"',telefono_Cliente='"+telefono+"',email_Cliente='"+email+"',direccion_Cliente='"+direccion+"' WHERE idCliente='"+codigo_old+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos del cliente." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public int eliminarCliente(String codigo){
        String SQL = "DELETE from Cliente WHERE idCliente ='"+codigo+"'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar el cliente.");
            System.err.println("Error al eliminar el cliente." +e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
