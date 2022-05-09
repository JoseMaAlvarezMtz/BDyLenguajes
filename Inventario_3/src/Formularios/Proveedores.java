package Formularios;

import Clases.Clase_Proveedores;
import Conexion.Conectar;
import static Formularios.Principal.contenedor;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class Proveedores extends javax.swing.JInternalFrame {
    private final Clase_Proveedores CP;
    TableColumnModel columnModel;
    int num = 0;
    public static int enviar = 0;
    
    public Proveedores() {
        initComponents();
        CP = new Clase_Proveedores();
        columnModel = jtb_proveedores.getColumnModel();
        listar();
        iniciar();
        bt_editar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    private void listar(){
        jtb_proveedores.setModel(CP.getDatosProveedores());
        columnModel.getColumn(1).setPreferredWidth(600);
    }
    
    private void iniciar(){
        txt_codigo.setEnabled(false);
        txt_nom_prove.setEnabled(false);
        txt_telefono.setEnabled(false);
        txt_telefono2.setEnabled(false);
        txt_direccion.setEnabled(false);
        txt_email.setEnabled(false);
       // jdc_fecharegistrado.setEnabled(false);
        txt_descripcion.setEnabled(false);
       // txt_nombreproveedor.setEnabled(false);
        
    }
    
    private void activar(){
        txt_codigo.setEnabled(true);
        txt_nom_prove.setEnabled(true);
        txt_telefono.setEnabled(true);
        txt_telefono2.setEnabled(true);
        txt_direccion.setEnabled(true);
        txt_email.setEnabled(true);
        txt_descripcion.setEnabled(true);
       // jdc_fecharegistrado.setEnabled(true);
      //  txt_codigoproveedor.setEnabled(true);
      //  txt_nombreproveedor.setEnabled(true);
        txt_codigo.requestFocus();
        
    }
    
    private void limpiar(){
        txt_codigo.setText("");
        txt_nom_prove.setText("");
        txt_telefono.setText("");
        txt_telefono2.setText("");
        txt_direccion.setText("");
        txt_email.setText("");
        txt_descripcion.setText(""); 
       // jdc_fecharegistrado.setDate(null);
       // txt_codigoproveedor.setText("");
       // txt_nombreproveedor.setText("");
        txt_codigo.requestFocus();
        jtb_proveedores.clearSelection();
    }
    
    private void guardar(){
        String codigo = txt_codigo.getText();
        String nombre_prove = txt_nom_prove.getText();
        String telefono = txt_telefono.getText();
        String telefono2 = txt_telefono2.getText();
        String direccion = txt_direccion.getText();
        String email = txt_email.getText();
        String descripcion = txt_codigo.getText();
    //    Date fecharegistro = jdc_fecharegistrado.getDate();
     //   long d = fecharegistro.getTime();
     //   java.sql.Date fecha_sql = new java.sql.Date(d);
    //    String codigoproveedor = txt_codigoproveedor.getText();
      //  String nombreproveedor = txt_nombreproveedor.getText();
        

        if(num == 0){
            int respuesta = CP.registrarProveedor(codigo,nombre_prove,telefono,telefono2,direccion,email,descripcion);
            if(respuesta > 0){
                if(CP.verificarCodigoProveedor(codigo) == 0){
                    CP.insertarProveedor(codigo);
                }
             
                listar();
                limpiar();
                iniciar();
                bt_editar.setEnabled(false);
            }
        }
        
        else{
            int row = jtb_proveedores.getSelectedRow();
            String codigo_old = jtb_proveedores.getValueAt(row, 0).toString();
            
            int respuesta = CP.actualizarProveedor(codigo,nombre_prove,telefono,telefono2,direccion,email,descripcion,codigo_old);
            if(respuesta >0){
                listar();
                limpiar();
                iniciar();
                num=0;
            }
        }
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_agregar = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        Panel_AP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_telefono2 = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bt_guardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_nom_prove = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_proveedores = new javax.swing.JTable();
        bt_Reporte = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setTitle("Registro de Proveedores");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(940, 560));
        setMinimumSize(new java.awt.Dimension(940, 560));
        setPreferredSize(new java.awt.Dimension(940, 560));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(940, 530));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 530));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 530));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setText("Registro de Proveedores");

        bt_agregar.setBackground(new java.awt.Color(204, 204, 204));
        bt_agregar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bt_agregar.setText("Agregar");
        bt_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregarActionPerformed(evt);
            }
        });

        bt_editar.setBackground(new java.awt.Color(204, 204, 204));
        bt_editar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bt_editar.setText("Editar");
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        bt_eliminar.setBackground(new java.awt.Color(153, 153, 153));
        bt_eliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Seleccione una de las siguientes opciones: ");

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setOneTouchExpandable(true);

        Panel_AP.setBackground(new java.awt.Color(255, 255, 255));
        Panel_AP.setMaximumSize(new java.awt.Dimension(340, 375));
        Panel_AP.setMinimumSize(new java.awt.Dimension(340, 375));
        Panel_AP.setPreferredSize(new java.awt.Dimension(340, 375));

        jLabel4.setText("Teléfono:");

        jLabel5.setText("Email: ");

        jLabel6.setText("Dirección: ");

        jLabel10.setText("Teléfono no. 2:");

        txt_codigo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        txt_telefono2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_telefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono2ActionPerformed(evt);
            }
        });

        txt_direccion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel11.setText("Nombre:");

        txt_telefono.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        jLabel9.setText("Descripción:");

        bt_guardar.setBackground(new java.awt.Color(204, 204, 204));
        bt_guardar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel7.setText("Llene los siguientes campos.");

        txt_descripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });

        jLabel12.setText("Codigo:");

        txt_nom_prove.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_nom_prove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nom_proveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_APLayout = new javax.swing.GroupLayout(Panel_AP);
        Panel_AP.setLayout(Panel_APLayout);
        Panel_APLayout.setHorizontalGroup(
            Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_APLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nom_prove, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_telefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_APLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_descripcion))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_APLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(307, 307, 307))
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        Panel_APLayout.setVerticalGroup(
            Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_APLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_APLayout.createSequentialGroup()
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_nom_prove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_telefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_APLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(bt_guardar)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(Panel_AP);

        jtb_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_proveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_proveedores);

        jSplitPane1.setRightComponent(jScrollPane1);

        bt_Reporte.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        bt_Reporte.setText("Generar Reporte");
        bt_Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_Reporte))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_agregar)
                                .addGap(18, 18, 18)
                                .addComponent(bt_editar)
                                .addGap(18, 18, 18)
                                .addComponent(bt_eliminar)))
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(bt_Reporte))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_eliminar)
                    .addComponent(bt_editar)
                    .addComponent(bt_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_proveedoresMouseClicked
        bt_editar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        int row = jtb_proveedores.getSelectedRow(); ;
        txt_codigo.setText(jtb_proveedores.getValueAt(row, 0).toString());
        txt_nom_prove.setText(jtb_proveedores.getValueAt(row, 1).toString());
        txt_telefono.setText(jtb_proveedores.getValueAt(row, 2).toString());
        txt_telefono2.setText(jtb_proveedores.getValueAt(row, 3).toString());
        txt_direccion.setText(jtb_proveedores.getValueAt(row, 4).toString());
        txt_email.setText(jtb_proveedores.getValueAt(row, 5).toString());
       // jdc_fecharegistro.setDate(jtb_productos.getValueAt(row, 5).toString();
       // txt_codigoproveedor.setText(jtb_proveedores.getValueAt(row, 6).toString());
       // txt_nombreproveedor.setText(jtb_productos.getValueAt(row, 6).toString());
      
    }//GEN-LAST:event_jtb_proveedoresMouseClicked

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        activar();
        limpiar();
        bt_guardar.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        num = 1;
        activar();
        bt_editar.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_eliminar.setEnabled(false);    // TODO add your handling code here:
    }//GEN-LAST:event_bt_editarActionPerformed

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        int fila = jtb_proveedores.getSelectedRowCount();
        if (fila < 1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
        else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?","Eliminar Proveedor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp==0){
                if (CP.eliminarProveedor(jtb_proveedores.getValueAt(jtb_proveedores.getSelectedRow(), 0).toString()) > 0){
                    listar();
                    limpiar();
                    bt_eliminar.setEnabled(false);
                    bt_editar.setEnabled(false);
                    bt_guardar.setEnabled(false);
                }
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void txt_telefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono2ActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        guardar();// TODO add your handling code here:
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void txt_nom_proveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nom_proveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nom_proveActionPerformed

    private Connection connection = new Conectar().getConnection();
    
    private void bt_ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ReporteActionPerformed
        // TODO add your handling code here:
             Map p=new HashMap();
        JasperReport report;
        JasperPrint print;
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/Proveedor.jrxml");
            print=JasperFillManager.fillReport(report, p, connection);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Proveedores");
            view.setVisible(true);            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_ReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel Panel_AP;
    private javax.swing.JButton bt_Reporte;
    private javax.swing.JButton bt_agregar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JSplitPane jSplitPane1;
    private static javax.swing.JTable jtb_proveedores;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nom_prove;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_telefono2;
    // End of variables declaration//GEN-END:variables
}
