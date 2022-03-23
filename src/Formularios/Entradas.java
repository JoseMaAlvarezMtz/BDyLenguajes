package Formularios;

import Clases.Clase_Entradas;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class Entradas extends javax.swing.JInternalFrame {
    private final Clase_Entradas CE;
    TableColumnModel columnModel;
    int num = 0;
    
    public Entradas() {
        initComponents();
        CE = new Clase_Entradas();
        columnModel = jtb_entradas.getColumnModel();
        listar();
        iniciar();
        bt_editar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    private void listar(){
        jtb_entradas.setModel(CE.getDatosEntradas());
        columnModel.getColumn(1).setPreferredWidth(600);
    }
    
    private void iniciar(){
        txt_codigo.setEnabled(false);
        jdc_fecharegistro.setEnabled(false);
        txt_cantidad.setEnabled(false);
        jcb_proveedores.setEnabled(false);
        
    }
    
    private void activar(){
        txt_codigo.setEnabled(true);
        jdc_fecharegistro.setEnabled(true);
        txt_cantidad.setEnabled(true);
        jcb_proveedores.setEnabled(true);
        txt_codigo.requestFocus();
    }
    
    private void limpiar(){
        txt_codigo.setText("");
        jdc_fecharegistro.setDate(null);
        txt_cantidad.setText("");
        jcb_proveedores.setSelectedIndex(-1);
        txt_codigo.requestFocus();
        jtb_entradas.clearSelection();
    }
    
    private void guardar(){
        String codigo = txt_codigo.getText();
        String cantidad = txt_cantidad.getText();
        Date fecharegistro = jdc_fecharegistro.getDate();
        Integer proveedor = jcb_proveedores.getSelectedIndex();
        long d = fecharegistro.getTime();
        java.sql.Date fecha_sql = new java.sql.Date(d);
        

        if(num == 0){
            int respuesta = CE.registrarEntrada(codigo,fecha_sql,cantidad,proveedor);
            if(respuesta > 0){
                /*if(CE.verificarCodigoInventario(codigo) == 0){
                    CE.insertarProductoInventario(codigo);
                }*/
             
                listar();
                limpiar();
                iniciar();
                bt_editar.setEnabled(false);
            }
        }
        
        else{
            int row = jtb_entradas.getSelectedRow();
            String codigo_old = jtb_entradas.getValueAt(row, 0).toString();
            
            /*int respuesta = CE.actualizarEntrada(codigo,fecha_sql,cantidad,proveedor);
            if(respuesta >0){
                listar();
                limpiar();
                iniciar();
                num=0;
            }*/
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
        bt_guardar = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        Panel_AP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jdc_fecharegistro = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jcb_proveedores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_entradas = new javax.swing.JTable();

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
        jLabel2.setText("Entrada de Productos");

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

        bt_guardar.setBackground(new java.awt.Color(204, 204, 204));
        bt_guardar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setOneTouchExpandable(true);

        Panel_AP.setBackground(new java.awt.Color(255, 255, 255));
        Panel_AP.setMaximumSize(new java.awt.Dimension(340, 375));
        Panel_AP.setMinimumSize(new java.awt.Dimension(340, 375));
        Panel_AP.setPreferredSize(new java.awt.Dimension(340, 375));

        jLabel4.setText("Fecha de entrada:");

        jLabel6.setText("Proveedor:");

        jLabel10.setText("Cantidad:");

        txt_codigo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        txt_cantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });

        jdc_fecharegistro.setDateFormatString("yyyy/MM/dd");

        jLabel11.setText("Código del producto:");

        jcb_proveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout Panel_APLayout = new javax.swing.GroupLayout(Panel_AP);
        Panel_AP.setLayout(Panel_APLayout);
        Panel_APLayout.setHorizontalGroup(
            Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_APLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(307, 307, 307))
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txt_cantidad))
                            .addGroup(Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_proveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_APLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdc_fecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        Panel_APLayout.setVerticalGroup(
            Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_APLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_APLayout.createSequentialGroup()
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jdc_fecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_APLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcb_proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(Panel_AP);

        jtb_entradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_entradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_entradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_entradas);

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
                        .addComponent(bt_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(bt_guardar)
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

    private void jtb_entradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_entradasMouseClicked
        bt_editar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        int row = jtb_entradas.getSelectedRow(); 
        txt_codigo.setText(jtb_entradas.getValueAt(row, 0).toString());
        jdc_fecharegistro.setDateFormatString(jtb_entradas.getValueAt(row, 1).toString());
        txt_cantidad.setText(jtb_entradas.getValueAt(row, 2).toString());
        jcb_proveedores.setSelectedIndex(Integer.parseInt(jtb_entradas.getValueAt(row, 3).toString()));
      
    }//GEN-LAST:event_jtb_entradasMouseClicked

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
        int fila = jtb_entradas.getSelectedRowCount();
        if (fila < 1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
        else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?","Eliminar Entrada", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp==0){
                if (CE.eliminarEntrada(jtb_entradas.getValueAt(jtb_entradas.getSelectedRow(), 0).toString()) > 0){
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

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        guardar();// TODO add your handling code here:
    }//GEN-LAST:event_bt_guardarActionPerformed


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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox<String> jcb_proveedores;
    private com.toedter.calendar.JDateChooser jdc_fecharegistro;
    private javax.swing.JTable jtb_entradas;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    // End of variables declaration//GEN-END:variables
}
