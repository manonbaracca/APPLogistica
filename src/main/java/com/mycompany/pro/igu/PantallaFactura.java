
package com.mycompany.pro.igu;

import com.mycompany.pro.logica.Controladora;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.LineaFactura;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Producto;
import com.mycompany.pro.logica.Ruta;
import com.mycompany.pro.logica.RutaAerea;
import com.mycompany.pro.logica.RutaMaritima;
import com.mycompany.pro.logica.RutaTerrestre;
import com.mycompany.pro.logica.Usuario;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PantallaFactura extends javax.swing.JFrame {
Controladora control;
Usuario usr;
Factura factura;

    public PantallaFactura(Controladora control,Usuario usr, Factura factura) {
        initComponents();
        this.control = control;
        this.usr= usr;
        this.factura=factura;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtShipper2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        txtNumeroPedido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetallesFactura = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        txtTotalIva = new javax.swing.JTextField();
        txtShipper = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTipoRuta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        txtShipper2.setEditable(false);
        txtShipper2.setBackground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Factura");

        jLabel2.setText("Pedido nro:");

        btnInicio.setText("Volver al Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnPedidos.setText("Ver todos mis pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        txtNumeroPedido.setEditable(false);
        txtNumeroPedido.setBackground(new java.awt.Color(255, 255, 255));

        tablaDetallesFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDetallesFactura);

        jLabel3.setText("Shipper:");

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(255, 255, 255));

        txtTotalIva.setEditable(false);
        txtTotalIva.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalIva.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtShipper.setEditable(false);
        txtShipper.setBackground(new java.awt.Color(255, 255, 255));

        txtDestino.setEditable(false);
        txtDestino.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Ruta:");

        jLabel5.setText("Origen:");

        jLabel6.setText("Destino:");

        txtOrigen.setEditable(false);
        txtOrigen.setBackground(new java.awt.Color(255, 255, 255));

        txtSubtotal.setEditable(false);
        txtSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setText("Total Iva:");

        jLabel8.setText("Subtotal:");

        jLabel9.setText("Total:");

        txtTipoRuta.setEditable(false);
        txtTipoRuta.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Tipo de Ruta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPedidos)
                .addGap(189, 189, 189))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34)
                        .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(60, 60, 60)
                                .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(68, 68, 68)
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTipoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(txtShipper, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60)
                        .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtShipper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicio)
                    .addComponent(btnPedidos))
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

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        PrincipalUser pUser = new PrincipalUser (control,usr);
        pUser.setVisible(true);
        pUser.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        int id_usuario = usr.getIdUsuario();

        MisPedidos miP = new MisPedidos(control, usr);
        miP.setVisible(true);
        miP.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
        llenarDatos(factura);
    }//GEN-LAST:event_formWindowOpened
    private DefaultTableModel modeloTablaDetallesFactura;

    private void cargarTabla() {
        //definir el modelo que queremos que tenga la tabla
            modeloTablaDetallesFactura = new DefaultTableModel() {

       
        //que fila y columnas no sean editables
        @Override
        public boolean isCellEditable (int row, int column) {
            return false;
        }
           
       };
       //establecemos los nombres de las columnas
       String titulosPedidos[] = {"ID Producto","Descripcion","Cantidad","Precio", "IVA", "Precio Total"};
       modeloTablaDetallesFactura.setColumnIdentifiers(titulosPedidos);
       tablaDetallesFactura.setModel(modeloTablaDetallesFactura);
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

            // Resto de tu código para llenar datos...
            }
            txtNumeroPedido.setText(String.valueOf(pedido.getIdPedido()));
            if (pedido.getRuta() != null) {
                txtRuta.setText(String.valueOf(pedido.getRuta().getIdRuta()));
                txtShipper.setText(pedido.getRuta().getShipper());
                txtDestino.setText(pedido.getRuta().getDestino());
                txtOrigen.setText(pedido.getRuta().getOrigen());
            }

            modeloTablaDetallesFactura.setRowCount(0);
            double subtotal = 0.0;
            double totalIva = 0.0;
            double total = 0.0;

            for (LineaFactura linea : factura.getLineasFactura()) {
                modeloTablaDetallesFactura.addRow(new Object[]{
                linea.getProducto().getIdProducto(),
                linea.getProducto().getDescripcion(),
                linea.getCantidadLinea(),
                linea.getPrecio(),
                linea.getIva(),
                linea.getCostoTotal()
            });
            double costoLinea = linea.getPrecio() * linea.getCantidadLinea();
            double ivaLinea = costoLinea * linea.getIva() / 100;

            // Acumula los valores
            subtotal += costoLinea;
            totalIva += ivaLinea;
            total += costoLinea + ivaLinea;    
        }
            txtTotal.setText(String.valueOf(total));
            txtTotalIva.setText(String.valueOf(totalIva));
            txtSubtotal.setText(String.valueOf(subtotal));
        } else {
            mostrarMensaje("No se encontró el pedido asociado con esta factura: " , "Error", "Error al Finalizar");
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
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDetallesFactura;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtNumeroPedido;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtShipper;
    private javax.swing.JTextField txtShipper2;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTipoRuta;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalIva;
    // End of variables declaration//GEN-END:variables
}
