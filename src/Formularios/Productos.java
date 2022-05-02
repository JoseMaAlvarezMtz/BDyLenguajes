package Formularios;

import Clases.Clase_Productos;
import static Formularios.Principal.contenedor;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import java.awt.Dimension;
import javax.swing.JPanel;


public class Productos extends javax.swing.JInternalFrame {
    private final Clase_Productos CP;
    TableColumnModel columnModel;
    int num = 0;
    public static int enviar = 0;
    
    public Productos() {
        initComponents();
        CP = new Clase_Productos();
        columnModel = jtb_productos.getColumnModel();
        listar();
        iniciar();
        bt_editar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    private void listar(){
        jtb_productos.setModel(CP.getDatosProductos());
        columnModel.getColumn(1).setPreferredWidth(600);
    }
    
    private void iniciar(){
        txt_codigo.setEnabled(false);
        txt_nombre.setEnabled(false);
        txt_descripcion.setEnabled(false);
        txt_precio.setEnabled(false);
        txt_preciosugerido.setEnabled(false);
        jdc_fecharegistrado.setEnabled(false);
        txt_codigoproveedor.setEnabled(false);
       // txt_nombreproveedor.setEnabled(false);
        
    }
    
    private void activar(){
        txt_codigo.setEnabled(true);
        txt_nombre.setEnabled(true);
        txt_descripcion.setEnabled(true);
        txt_precio.setEnabled(true);
        txt_preciosugerido.setEnabled(true);
        jdc_fecharegistrado.setEnabled(true);
        txt_codigoproveedor.setEnabled(true);
      //  txt_nombreproveedor.setEnabled(true);
        txt_codigo.requestFocus();
        
    }
    
    private void limpiar(){
        txt_codigo.setText("");
        txt_nombre.setText("");
        txt_descripcion.setText("");
        txt_precio.setText("");
        txt_preciosugerido.setText("");
        jdc_fecharegistrado.setDate(null);
        txt_codigoproveedor.setText("");
       // txt_nombreproveedor.setText("");
        txt_codigo.requestFocus();
        jtb_productos.clearSelection();
    }
    
    private void guardar(){
        String codigo = txt_codigo.getText();
        String nombre = txt_nombre.getText();
        String descripcion = txt_descripcion.getText();
        String precio = txt_precio.getText();
        String preciosugerido = txt_preciosugerido.getText();
        Date fecharegistro = jdc_fecharegistrado.getDate();
        long d = fecharegistro.getTime();
        java.sql.Date fecha_sql = new java.sql.Date(d);
        String codigoproveedor = txt_codigoproveedor.getText();
      //  String nombreproveedor = txt_nombreproveedor.getText();
        

        if(num == 0){
            int respuesta = CP.registrarProducto(codigo,nombre,descripcion,precio,preciosugerido,fecha_sql,codigoproveedor);
            if(respuesta > 0){
                if(CP.verificarCodigoInventario(codigo) == 0){
                    CP.insertarProductoInventario(codigo);
                }
             
                listar();
                limpiar();
                iniciar();
                bt_editar.setEnabled(false);
            }
        }
        
        else{
            int row = jtb_productos.getSelectedRow();
            String codigo_old = jtb_productos.getValueAt(row, 0).toString();
            
            int respuesta = CP.actualizarProducto(codigo,nombre,descripcion,precio,preciosugerido,fecha_sql,codigoproveedor,codigo_old);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_preciosugerido = new javax.swing.JTextField();
        jdc_fecharegistrado = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_codigoproveedor = new javax.swing.JTextField();
        jbt_buscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bt_guardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_productos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setTitle("Registro de Productos");
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
        jLabel2.setText("Registro de Productos");

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

        jLabel4.setText("Nombre:");

        jLabel5.setText("Precio sugerido:");

        jLabel6.setText("Precio:");

        jLabel8.setText("Código de proveedor");

        jLabel10.setText("Descripción");

        txt_codigo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        txt_descripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });

        txt_precio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });

        txt_preciosugerido.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_preciosugerido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_preciosugeridoActionPerformed(evt);
            }
        });

        jdc_fecharegistrado.setDateFormatString("yyyy/MM/dd");

        jLabel11.setText("Código del producto:");

        txt_nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        jbt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa (1).png"))); // NOI18N
        jbt_buscar.setBorderPainted(false);
        jbt_buscar.setContentAreaFilled(false);
        jbt_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_buscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha de registro:");

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
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_preciosugerido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdc_fecharegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_APLayout.createSequentialGroup()
                                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_codigoproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_APLayout.createSequentialGroup()
                                        .addGap(143, 143, 143)
                                        .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
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
                        .addGap(1, 1, 1)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_preciosugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jdc_fecharegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txt_codigoproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbt_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(bt_guardar)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(Panel_AP);

        jtb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_productos);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_productosMouseClicked
        bt_editar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        int row = jtb_productos.getSelectedRow(); ;
        txt_codigo.setText(jtb_productos.getValueAt(row, 0).toString());
        txt_nombre.setText(jtb_productos.getValueAt(row, 1).toString());
        txt_descripcion.setText(jtb_productos.getValueAt(row, 2).toString());
        txt_precio.setText(jtb_productos.getValueAt(row, 3).toString());
        txt_preciosugerido.setText(jtb_productos.getValueAt(row, 4).toString());
       // jdc_fecharegistro.setDate(jtb_productos.getValueAt(row, 5).toString();
        txt_codigoproveedor.setText(jtb_productos.getValueAt(row, 6).toString());
       // txt_nombreproveedor.setText(jtb_productos.getValueAt(row, 6).toString());
      
    }//GEN-LAST:event_jtb_productosMouseClicked

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
        int fila = jtb_productos.getSelectedRowCount();
        if (fila < 1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
        else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?","Eliminar Producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp==0){
                if (CP.eliminarProducto(jtb_productos.getValueAt(jtb_productos.getSelectedRow(), 0).toString()) > 0){
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

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void txt_preciosugeridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_preciosugeridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_preciosugeridoActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        guardar();// TODO add your handling code here:
    }//GEN-LAST:event_bt_guardarActionPerformed

    private void jbt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_buscarActionPerformed
        enviar = 1;
        Buscar_Proveedores C = new Buscar_Proveedores();
        Principal.contenedor.add(C);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = C.getSize();
        C.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        C.toFront();
        C.setVisible(true);
    }//GEN-LAST:event_jbt_buscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel Panel_AP;
    private javax.swing.JButton bt_agregar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JSplitPane jSplitPane1;
    private static javax.swing.JButton jbt_buscar;
    private com.toedter.calendar.JDateChooser jdc_fecharegistrado;
    private static javax.swing.JTable jtb_productos;
    private javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_codigoproveedor;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_preciosugerido;
    // End of variables declaration//GEN-END:variables
}
