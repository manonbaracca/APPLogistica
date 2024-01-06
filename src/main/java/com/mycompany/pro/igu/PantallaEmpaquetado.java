
package com.mycompany.pro.igu;

import com.mycompany.pro.logica.Controladora;
import com.mycompany.pro.logica.Empaquetado;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.LineaFactura;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Ruta;
import com.mycompany.pro.logica.RutaAerea;
import com.mycompany.pro.logica.RutaMaritima;
import com.mycompany.pro.logica.RutaTerrestre;
import com.mycompany.pro.logica.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PantallaEmpaquetado extends javax.swing.JFrame {
 Controladora control;
 Usuario usr;
 Factura fac;
 Pedido ped;

    public PantallaEmpaquetado(Controladora control, Usuario usr,Factura fac, Pedido ped) {
        initComponents();
        this.control = control;
        this.usr=usr;
        this.fac=fac;
        this.ped=ped;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtTipoRuta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JToggleButton();
        txtContenedores = new javax.swing.JTextField();
        txtPesoTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDetalles);

        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Detalles");

        jLabel2.setText("Ruta:");

        jLabel3.setText("Origen:");

        jLabel4.setText("Destino:");

        txtOrigen.setEditable(false);
        txtOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrigenActionPerformed(evt);
            }
        });

        txtDestino.setEditable(false);
        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        txtTipoRuta.setEditable(false);
        txtTipoRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoRutaActionPerformed(evt);
            }
        });

        jLabel5.setText("Ingrese detalles del empaquetado:");

        btnEnviar.setText("Enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtPesoTotal.setEditable(false);

        jLabel6.setText("Peso Total:");

        jLabel7.setText("Numero de contenedores:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(357, 357, 357)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(371, 371, 371)
                                .addComponent(jLabel6)
                                .addGap(38, 38, 38)
                                .addComponent(txtPesoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContenedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(46, 46, 46)
                .addComponent(btnEnviar)
                .addGap(15, 15, 15))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       cargarTabla();
       llenarDatos(fac);
    }//GEN-LAST:event_formWindowOpened

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Empaquetar emp = new Empaquetar(control, usr);
        emp.setVisible(true);
        emp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrigenActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtTipoRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoRutaActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        if (txtContenedores.getText().trim().isEmpty()) {
        mostrarMensaje("Todos los campos deben estar llenos.", "Error", "Error de Entrada");
        return;
        }    
        int numeroContenedores ;
        double pesoTotalPedido;
        try {
            numeroContenedores = Integer.parseInt(txtContenedores.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Número de contenedores no válido. Por favor, ingrese un número entero.", "Error", "Error de Entrada");
        return; 
        }
        
        pesoTotalPedido = Double.parseDouble(txtPesoTotal.getText());

        Pedido pedido = fac.getPedido();
        Empaquetado emp=control.createEmpaquetado(numeroContenedores,pesoTotalPedido, pedido);
     try {
         control.editarPedido(pedido, emp);
     } catch (Exception ex) {
         Logger.getLogger(PantallaEmpaquetado.class.getName()).log(Level.SEVERE, null, ex);
     }

     mostrarMensaje("Pedido enviado correctamente.", "Info", "Envio exitoso");
        Empaquetar empa = new Empaquetar(control, usr);
        empa.setVisible(true);
        empa.setLocationRelativeTo(null);
        this.dispose();
        
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private DefaultTableModel modeloTablaDetalles;

    private void cargarTabla() {
        //definir el modelo que queremos que tenga la tabla
        modeloTablaDetalles = new DefaultTableModel() {
        //que fila y columnas no sean editables
            @Override
            public boolean isCellEditable (int row, int column) {
                return false;
            }   
        };
        String titulosPedidos[] = {"ID Producto", "Descripcion", "Cantidad", "Peso Unidad","Peso Total"};
        modeloTablaDetalles.setColumnIdentifiers(titulosPedidos);
        tablaDetalles.setModel(modeloTablaDetalles);
    }
    private void llenarDatos(Factura factura) {
             Pedido pedido = factura.getPedido();
        if (pedido != null) {
            Ruta ruta = pedido.getRuta();
            if (ruta != null) {
            String tipoRuta;
            if (ruta instanceof RutaMaritima) {
                tipoRuta = "Marítima";
            } else if (ruta instanceof RutaAerea) {
                tipoRuta = "Aérea";
            } else if (ruta instanceof RutaTerrestre) {
                tipoRuta = "Terrestre";
            } else {
                tipoRuta = "Desconocido"; 
            }
            txtTipoRuta.setText(tipoRuta);
                        }
            if (pedido.getRuta() != null) {
                txtDestino.setText(pedido.getRuta().getDestino());
                txtOrigen.setText(pedido.getRuta().getOrigen());
            
            modeloTablaDetalles.setRowCount(0);
            double pesoTotalPedido = 0.0;
            for (LineaFactura linea : factura.getLineasFactura()) {
                double pesoTotalLinea = linea.getProducto().getPeso() * linea.getCantidadLinea();
                pesoTotalPedido += pesoTotalLinea;
                modeloTablaDetalles.addRow(new Object[]{
                linea.getProducto().getIdProducto(),
                linea.getProducto().getDescripcion(),
                linea.getCantidadLinea(),
                linea.getProducto().getPeso(),
                pesoTotalLinea,
                
            });
                txtPesoTotal.setText(String.valueOf(pesoTotalPedido));
                }
            }
            
                     else {
            mostrarMensaje("No se encontró el pedido asociado " , "Error", "Error al Finalizar");
        }
}
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
    private javax.swing.JToggleButton btnEnviar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTextField txtContenedores;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtPesoTotal;
    private javax.swing.JTextField txtTipoRuta;
    // End of variables declaration//GEN-END:variables
}
