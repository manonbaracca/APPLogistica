
package com.mycompany.pro.igu;

import com.mycompany.pro.logica.Controladora;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Usuario;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Envios extends javax.swing.JFrame {
Controladora control;
Usuario usr;
   
  
    public Envios(Controladora control,Usuario usr) {
        initComponents();
         this.control = control;
        this.usr= usr;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEnvios = new javax.swing.JTable();
        btnCambiarEstado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Envios");

        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tablaEnvios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEnvios);

        btnCambiarEstado.setText("Cambiar estado");
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnCambiarEstado)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnCambiarEstado)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        PrincipalOperario pOper = new PrincipalOperario (control,usr);
        pOper.setVisible(true);
        pOper.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla(usr);
    }//GEN-LAST:event_formWindowOpened

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        //validar que la tabla tenga elementos
        if (tablaEnvios.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tablaEnvios.getSelectedRow()!=-1) {
                int idPedido = Integer.parseInt(String.valueOf(tablaEnvios.getValueAt(tablaEnvios.getSelectedRow(),0)));
                Pedido ped=control.traerPedido(idPedido);
                //llamo a la ventana de edición
                EdicionPed pantallaPed = new EdicionPed(control,usr,ped);
                pantallaPed.setVisible(true);
                pantallaPed.setLocationRelativeTo(null);
                cargarTabla(usr);
                
            }
            else {
                mostrarMensaje ("No selecciono ningún registro", "Error", "Error al editar");
            }
        
        }
        else {
            mostrarMensaje ("La tabla está vacía", "Error", "Error al editar");
        
        
            }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed
private DefaultTableModel modeloTablaEnvios;

    private void cargarTabla(Usuario usr) {
        //definir el modelo que queremos que tenga la tabla
        modeloTablaEnvios = new DefaultTableModel() {
        //que fila y columnas no sean editables
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }   
        };
        String titulosPedidos[] = {"ID Pedido","Total", "Fecha Pedido", "Estado", "ID Factura","ID Empaquetado"};
        modeloTablaEnvios.setColumnIdentifiers(titulosPedidos);
        Integer idUsuarioActual = usr.getIdUsuario();
        List<Pedido> listaPedido = control.traerPedidos();
                if (listaPedido != null) {
                    for (Pedido ped : listaPedido) {
                        int idUsuarioPedido = ped.getRuta().getIdUsu();
                        if (idUsuarioActual.equals(idUsuarioPedido)&& ped.getEstado()== Pedido.EstadoPedido.ENVIADO) {
                            Factura fac = ped.getFactura();

                            Object[] objeto = {
                                ped.getIdPedido(),
                                fac.getTotal(),
                                ped.getFechaPedido(),
                                ped.getEstado(),
                                fac.getIdFactura(),
                                (ped.getEmpaquetado() != null) ? ped.getEmpaquetado().getIdEmpaquetado() : "NO EMPAQUETADO"
                            };
                            modeloTablaEnvios.addRow(objeto);
                        } else {
                        }
                    }
                }

                tablaEnvios.setModel(modeloTablaEnvios);
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
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEnvios;
    // End of variables declaration//GEN-END:variables
}
