/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexion.Conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pelon
 */
public class Clase_Inventario {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    public String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    private final String SQL_SELECT_INVENTARIO = "CALL Inventario_Total_Fecha(?)";
    
    public Clase_Inventario(){
        PS = null;
        CN = new Conectar();
    }
    
    private DefaultTableModel setTitulosInventario(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DT.addColumn("Codigo del producto");
        DT.addColumn("Nombre del producto");
        DT.addColumn("Cantidad Existente");
        return DT;
    }
    
    public DefaultTableModel getDatosInventario(){
        try {
            setTitulosInventario();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_INVENTARIO);
            PS.setString(1,fechaActual);
            RS = PS.executeQuery();
            Object[] fila = new Object[4];
            while(RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
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
