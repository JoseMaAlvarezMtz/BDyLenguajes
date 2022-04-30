package Formularios;

import Clases.Clase_Clientes;
import static Formularios.Principal.contenedor;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import java.awt.Dimension;
import javax.swing.JPanel;


public class Clientes extends javax.swing.JInternalFrame {
    private final Clase_Clientes CP;
    TableColumnModel columnModel;
    int num = 0;
    public static int enviar = 0;
    
    public Clientes() {
        initComponents();
        CP = new Clase_Clientes();
        columnModel = jtb_clientes.getColumnModel();
        listar();
        iniciar();
        bt_editar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    private void listar(){
        jtb_clientes.setModel(CP.getDatosClientes());
        columnModel.getColumn(1).setPreferredWidth(600);
    }
    
    private void iniciar(){
        txt_codigo.setEnabled(false);
        txt_nom_cliente.setEnabled(false);
        txt_apellido1.setEnabled(false);
        txt_apellido2.setEnabled(false);
        txt_telefono.setEnabled(false);
     //   txt_telefono2.setEnabled(false);
        txt_email.setEnabled(false);
        txt_direccion.setEnabled(false);
      
       // jdc_fecharegistrado.setEnabled(false);
       
       // txt_nombreproveedor.setEnabled(false);
        
    }
    
    private void activar(){
        txt_codigo.setEnabled(true);
        txt_nom_cliente.setEnabled(true);
        txt_apellido1.setEnabled(true);
        txt_apellido2.setEnabled(true);
        txt_telefono.setEnabled(true);
      //  txt_telefono2.setEnabled(true);
        txt_email.setEnabled(true);
        txt_direccion.setEnabled(true);
       
       
       // jdc_fecharegistrado.setEnabled(true);
      //  txt_codigoproveedor.setEnabled(true);
      //  txt_nombreproveedor.setEnabled(true);
        txt_codigo.requestFocus();
        
    }
    
    private void limpiar(){
        txt_codigo.setText("");
        txt_nom_cliente.setText("");
        txt_apellido1.setText("");
        txt_apellido2.setText("");
        txt_telefono.setText("");
     //   txt_telefono2.setText("");
        txt_email.setText("");
        txt_direccion.setText("");
        
       
       // jdc_fecharegistrado.setDate(null);
       // txt_codigoproveedor.setText("");
       // txt_nombreproveedor.setText("");
        txt_codigo.requestFocus();
        jtb_clientes.clearSelection();
    }
    
    private void guardar(){
        String codigo = txt_codigo.getText();
        String nombre_cliente = txt_nom_cliente.getText();
        String apellido1 = txt_apellido1.getText();
        String apellido2 = txt_apellido2.getText();
        String telefono = txt_telefono.getText();
     //   String telefono2 = txt_telefono2.getText();
        String email = txt_email.getText();
        String direccion = txt_direccion.getText();

    //    Date fecharegistro = jdc_fecharegistrado.getDate();
     //   long d = fecharegistro.getTime();
     //   java.sql.Date fecha_sql = new java.sql.Date(d);
    //    String codigoproveedor = txt_codigoproveedor.getText();
      //  String nombreproveedor = txt_nombreproveedor.getText();
        

        if(num == 0){
            int respuesta = CP.registrarCliente(codigo,nombre_cliente,apellido1,apellido2,telefono,email,direccion);
            if(respuesta > 0){
                if(CP.verificarCodigoCliente(codigo) == 0){
                    CP.insertarCliente(codigo);
                }
             
                listar();
                limpiar();
                iniciar();
                bt_editar.setEnabled(false);
            }
        }
        
        else{
            int row = jtb_clientes.getSelectedRow();
            String codigo_old = jtb_clientes.getValueAt(row, 0).toString();
            
            int respuesta = CP.actualizarCliente(codigo,nombre_cliente,apellido1,apellido2,telefono,email,direccion,codigo_old);
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
        txt_codigo = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        bt_guardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nom_cliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_apellido1 = new javax.swing.JTextField();
        txt_apellido2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_clientes = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setTitle("Registro de Clientes");
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
        jLabel2.setText("Registro de Clientes");

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

        txt_codigo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
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

        jLabel12.setText("Codigo:");

        txt_nom_cliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_nom_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nom_clienteActionPerformed(evt);
            }
        });

        jLabel13.setText("Apellido Paterno:");

        jLabel14.setText("Apellido Materno:");

        txt_apellido1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_apellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellido1ActionPerformed(evt);
            }
        });

        txt_apellido2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

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
                                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_nom_cliente)))
                                .addGap(90, 90, 90))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(307, 307, 307))
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        Panel_APLayout.setVerticalGroup(
            Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_APLayout.createSequentialGroup()
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3))
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_nom_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txt_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_guardar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(Panel_AP);

        jtb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_clientes);

        jSplitPane1.setRightComponent(jScrollPane1);

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_agregar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_editar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_eliminar)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_eliminar)
                    .addComponent(bt_editar)
                    .addComponent(bt_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_clientesMouseClicked
        bt_editar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        int row = jtb_clientes.getSelectedRow(); ;
        txt_codigo.setText(jtb_clientes.getValueAt(row, 0).toString());
        txt_nom_cliente.setText(jtb_clientes.getValueAt(row, 1).toString());
        txt_apellido1.setText(jtb_clientes.getValueAt(row, 2).toString());
        txt_apellido2.setText(jtb_clientes.getValueAt(row, 3).toString());
        txt_telefono.setText(jtb_clientes.getValueAt(row, 4).toString());
    //    txt_telefono2.setText(jtb_clientes.getValueAt(row, 5).toString());
        txt_email.setText(jtb_clientes.getValueAt(row, 5).toString());
        txt_direccion.setText(jtb_clientes.getValueAt(row, 6).toString());
       // jdc_fecharegistro.setDate(jtb_productos.getValueAt(row, 5).toString();
       // txt_codigoproveedor.setText(jtb_clientes.getValueAt(row, 6).toString());
       // txt_nombreproveedor.setText(jtb_productos.getValueAt(row, 6).toString());
      
    }//GEN-LAST:event_jtb_clientesMouseClicked

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
        int fila = jtb_clientes.getSelectedRowCount();
        if (fila < 1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
        else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?","Eliminar Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp==0){
                if (CP.eliminarCliente(jtb_clientes.getValueAt(jtb_clientes.getSelectedRow(), 0).toString()) > 0){
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

    private void txt_nom_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nom_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nom_clienteActionPerformed

    private void txt_apellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellido1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel Panel_AP;
    private javax.swing.JButton bt_agregar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JSplitPane jSplitPane1;
    private static javax.swing.JTable jtb_clientes;
    private javax.swing.JTextField txt_apellido1;
    private javax.swing.JTextField txt_apellido2;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nom_cliente;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
