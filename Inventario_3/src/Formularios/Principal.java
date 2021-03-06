package Formularios;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class Principal extends javax.swing.JFrame {

    
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
       // txt_menu.requestFocus();
    }

    @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
             getImage(ClassLoader.getSystemResource("Imagenes/cheque.png"));
       
       return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Productos = new javax.swing.JButton();
        R_Salidas = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Proveedores = new javax.swing.JButton();
        R_Entradas = new javax.swing.JButton();
        Inventario = new javax.swing.JButton();
        contenedor = new javax.swing.JDesktopPane();
        Clientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 700));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setText("Mini Súper Ruiz");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 5, -1, -1));

        Productos.setBackground(new java.awt.Color(255, 255, 255));
        Productos.setForeground(new java.awt.Color(255, 255, 255));
        Productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        Productos.setToolTipText("");
        Productos.setBorder(null);
        Productos.setBorderPainted(false);
        Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductosActionPerformed(evt);
            }
        });
        jPanel1.add(Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        R_Salidas.setBackground(new java.awt.Color(255, 255, 255));
        R_Salidas.setForeground(new java.awt.Color(255, 255, 255));
        R_Salidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida-producto.png"))); // NOI18N
        R_Salidas.setBorder(null);
        R_Salidas.setBorderPainted(false);
        R_Salidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_SalidasActionPerformed(evt);
            }
        });
        jPanel1.add(R_Salidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));
        jSeparator1.setRequestFocusEnabled(false);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 140, 940, 10));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 20));
        jSeparator2.setRequestFocusEnabled(false);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 60, 940, 10));

        Proveedores.setBackground(new java.awt.Color(255, 255, 255));
        Proveedores.setForeground(new java.awt.Color(255, 255, 255));
        Proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"))); // NOI18N
        Proveedores.setBorder(null);
        Proveedores.setBorderPainted(false);
        Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresActionPerformed(evt);
            }
        });
        jPanel1.add(Proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        R_Entradas.setBackground(new java.awt.Color(255, 255, 255));
        R_Entradas.setForeground(new java.awt.Color(255, 255, 255));
        R_Entradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrada-producto.png"))); // NOI18N
        R_Entradas.setBorder(null);
        R_Entradas.setBorderPainted(false);
        R_Entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_EntradasActionPerformed(evt);
            }
        });
        jPanel1.add(R_Entradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        Inventario.setBackground(new java.awt.Color(255, 255, 255));
        Inventario.setForeground(new java.awt.Color(255, 255, 255));
        Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.png"))); // NOI18N
        Inventario.setToolTipText("");
        Inventario.setBorder(null);
        Inventario.setBorderPainted(false);
        Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioActionPerformed(evt);
            }
        });
        jPanel1.add(Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jPanel1.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 940, 540));

        Clientes.setBackground(new java.awt.Color(255, 255, 255));
        Clientes.setForeground(new java.awt.Color(255, 255, 255));
        Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/customer.png"))); // NOI18N
        Clientes.setToolTipText("");
        Clientes.setBorder(null);
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        jPanel1.add(Clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductosActionPerformed
        Productos f = new Productos();
        contenedor.add(f);
        f.show();
              // TODO add your handling code here:
    }//GEN-LAST:event_ProductosActionPerformed

    private void R_EntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_EntradasActionPerformed
        Entradas f = new Entradas();
        contenedor.add(f);
        f.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_R_EntradasActionPerformed

    private void ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresActionPerformed
        // TODO add your handling code here:
        Proveedores f = new Proveedores();
        contenedor.add(f);
        f.show();
    }//GEN-LAST:event_ProveedoresActionPerformed

    private void R_SalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_SalidasActionPerformed
        Salidas f = new Salidas();
        contenedor.add(f);
        f.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_R_SalidasActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Clientes f = new Clientes();
        contenedor.add(f);
        f.show();
// TODO add your handling code here:
    }//GEN-LAST:event_ClientesActionPerformed

    private void InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioActionPerformed
        Inventario f = new Inventario();
        contenedor.add(f);
        f.show();
    }//GEN-LAST:event_InventarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Inventario;
    private javax.swing.JButton Productos;
    private javax.swing.JButton Proveedores;
    private javax.swing.JButton R_Entradas;
    private javax.swing.JButton R_Salidas;
    public static javax.swing.JDesktopPane contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
