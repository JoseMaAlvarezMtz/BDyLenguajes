package Clases;

import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Clase_BuscarClientes {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_SELECT_PRODUCTO = "SELECT * FROM Cliente";
    
    
    public Clase_BuscarClientes(){
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
        DT.addColumn("Codigo de Cliente");
        DT.addColumn("Nombre del Cliente");
        
        return DT;
    }
    
    public DefaultTableModel getDatosClientes(){
        try {
            setTitulosCliente();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PRODUCTO);
            RS = PS.executeQuery();
            Object[] fila = new Object[3];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
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
    
    public DefaultTableModel getDatoProducto(int crt, String inf){
        String SQL;
        if (crt==2){
            SQL = "SSELECT *FROM Producto where idProovedor like '"+inf+"'";
        }
        else {
            SQL = "SELECT *FROM Producto where nombre_Proveedor '" +inf + "%'";
        }
        try {
            setTitulosCliente();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[3];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
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
    
}
