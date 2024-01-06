
package com.mycompany.pro.igu;

import com.mycompany.pro.logica.Controladora;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Ruta;
import com.mycompany.pro.logica.Usuario;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MisPedidos extends javax.swing.JFrame {
 Controladora control;
 Usuario usr;
 
    public MisPedidos(Controladora control, Usuario usr) {
        initComponents();
        this.control = control;
        this.usr=usr;
 
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Mis pedidos");

        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        btnVer.setText("Ver Factura");
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnVolver))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnVer)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla(usr);
    }//GEN-LAST:event_formWindowOpened

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        PrincipalUser pUser = new PrincipalUser (control,usr);
        pUser.setVisible(true);
        pUser.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        if (tablaPedidos.getRowCount() > 0){ 
            if (tablaPedidos.getSelectedRow()!=-1) {
                int idFactura = Integer.parseInt(String.valueOf(tablaPedidos.getValueAt(tablaPedidos.getSelectedRow(),5)));

                Factura factura= control.traerFactura(idFactura);

                PantallaFactura panF = new PantallaFactura(control, usr,factura);
                panF.setVisible(true);
                panF.setLocationRelativeTo(null);
                this.dispose(); 
             }
            else {
                mostrarMensaje ("No selecciono ningún registro", "Error", "Error al mostrar factura");
            }
        
        }
        else {
            mostrarMensaje ("La tabla está vacía", "Error", "Error al mostrar factura");
        }
    }//GEN-LAST:event_btnVerActionPerformed
    private DefaultTableModel modeloTablaPedidos;

    private void cargarTabla(Usuario usr) {
        //definir el modelo que queremos que tenga la tabla
        modeloTablaPedidos = new DefaultTableModel() {
        //que fila y columnas no sean editables
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }   
       };
       //establecemos los nombres de las columnas
       String titulosPedidos[] = {"ID Pedido","Shipper","Total", "Fecha Pedido", "Estado", "ID Factura"};
       modeloTablaPedidos.setColumnIdentifiers(titulosPedidos);
       Integer idUsuarioActual = usr.getIdUsuario();

        List<Pedido> listaPedido = control.traerPedidos();
        if (listaPedido != null) {
            for (Pedido ped : listaPedido) {
                Integer idUsuarioPedido = (ped.getUsr() != null) ? ped.getUsr().getIdUsuario() : null;

                    if (idUsuarioActual.equals(idUsuarioPedido)) {

                    Ruta rut = ped.getRuta();
                    Factura fac = ped.getFactura();
                    Object[] objeto = {ped.getIdPedido(), rut.getShipper(), fac.getTotal(), ped.getFechaPedido(), ped.getEstado(), fac.getIdFactura()};
                    modeloTablaPedidos.addRow(objeto);
                } else {
                }
            }
        }

        tablaPedidos.setModel(modeloTablaPedidos);
    }

 public void mostrarMensaje (String mensaje, String tipo, String titulo) {
       JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
   
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
