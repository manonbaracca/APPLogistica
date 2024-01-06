

package com.mycompany.pro.igu;

import com.mycompany.pro.logica.Controladora;
import com.mycompany.pro.logica.Empaquetado;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.LineaFactura;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Pedido.EstadoPedido;
import com.mycompany.pro.logica.Producto;
import com.mycompany.pro.logica.Ruta;
import com.mycompany.pro.logica.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class NuevoPedido extends javax.swing.JFrame {
Controladora control;
private DefaultTableModel modeloTablaPedidos;
private int id_rut; 
String origen;
Usuario usr;


public NuevoPedido(Controladora control,int id_rut, Usuario usr, String origen) {
        initComponents();
        this.control = control;
        this.modeloTablaPedidos = new DefaultTableModel(); 
        this.id_rut=id_rut;
        this.usr=usr;
        this.origen=origen;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Seleccione sus Productos");

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

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
        jScrollPane2.setViewportView(tablaPedidos);

        btnBorrar.setText("Borrar Producto");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar Producto");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Total");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnFinalizar)
                                                .addGap(14, 14, 14))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar)
                        .addGap(51, 51, 51))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
        cargarTablaPedido();
    }//GEN-LAST:event_formWindowOpened
double tot=0;
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DefaultTableModel modeloTablaPedidos = (DefaultTableModel) tablaPedidos.getModel();
      
        //validar que la tabla tenga elementos
        if (tablaProductos.getRowCount() > 0) {
            int filaSeleccionada = tablaProductos.getSelectedRow();
            
            //Controlar que se haya seleccionado un elemento
            
            if (filaSeleccionada != -1) {
                int cantidadDeseada=0;
                try {
                    cantidadDeseada = Integer.parseInt(txtCantidad.getText());                   
                    if (cantidadDeseada<=0){
                    mostrarMensaje("La cantidad a añadir debe ser mayor a 0", "Error", "Error al añadir");
                    return; 
                    }
                } catch (NumberFormatException e) {
                mostrarMensaje("Ingrese un número válido para la cantidad", "Error de Formato", "Error al añadir");
                return;
                }    
                
                DefaultTableModel modeloTablaProductos = (DefaultTableModel) tablaProductos.getModel();
                int cantidadDisponible = (Integer) modeloTablaProductos.getValueAt(filaSeleccionada, 5); // Asumiendo que la columna 6 tiene la cantidad disponible
                int idProducto = (int) modeloTablaProductos.getValueAt(filaSeleccionada, 0);
                
                //verifico si el producto ya esta en la tabla Pedidos
                boolean productoEncontrado = false;
                for (int i = 0; i < modeloTablaPedidos.getRowCount(); i++) {
                    int idEnTabla = (int) modeloTablaPedidos.getValueAt(i, 0);
                    if (idProducto == idEnTabla) {
                        int cantidadActualEnPedido = (int) modeloTablaPedidos.getValueAt(i, 5);
                        if (cantidadDeseada + cantidadActualEnPedido > cantidadDisponible) {
                            mostrarMensaje("La cantidad total excede el stock disponible.", "Error", "Error al añadir");
                            return;
                        } else {
                            // Actualizar cantidad y costo total en el pedido
                            int nuevaCantidad = cantidadActualEnPedido + cantidadDeseada;
                            double precio = (double) modeloTablaProductos.getValueAt(filaSeleccionada, 2);
                            double iva = (double) modeloTablaProductos.getValueAt(filaSeleccionada, 4);
                            double nuevoCostoTotal = precio * nuevaCantidad * (1 + iva / 100);
                            
                            modeloTablaPedidos.setValueAt(nuevaCantidad, i, 5);
                            modeloTablaPedidos.setValueAt(nuevoCostoTotal, i, 6);
                            tot= tot + (cantidadDeseada*precio*(1 + iva / 100));
                            txtTotal.setText(String.valueOf(tot));
                            productoEncontrado = true;
                            break;
                        }
                    }
                }
                if (!productoEncontrado) {
                    // Si el producto no está en el pedido, verificar el stock antes de agregar
                    if (cantidadDeseada > cantidadDisponible) {
                        mostrarMensaje("La cantidad deseada excede el stock disponible.", "Error", "Error al añadir");
                    } else {
                        
                        // Obtener los datos del producto seleccionado
                        String descripcion = (String) modeloTablaProductos.getValueAt(filaSeleccionada, 1);
                        double precio = (double) modeloTablaProductos.getValueAt(filaSeleccionada, 2);
                        double peso = (double) modeloTablaProductos.getValueAt(filaSeleccionada, 3);
                        double iva = (double) modeloTablaProductos.getValueAt(filaSeleccionada, 4);

                        // Calcular el costo total con el IVA
                        double costoTotal = precio * cantidadDeseada * (1 + iva / 100);
                        tot= tot + costoTotal;

                            // Añadir una nueva fila a la tabla de pedidos con el costo total
                            Object[] filaPedido = new Object[] {idProducto, descripcion, precio, peso, iva, cantidadDeseada, costoTotal};
                            modeloTablaPedidos.addRow(filaPedido);
                            txtTotal.setText(String.valueOf(tot));
                            }
                }
                txtCantidad.setText("");     
             
        }else {
                mostrarMensaje ("No selecciono ningún registro", "Error", "Error al añadir");               
        }
        }else {
            mostrarMensaje ("No hay productos agregados en el sistema", "Error", "Error al añadir");
        }
                                         

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        DefaultTableModel modeloTablaPedidos = (DefaultTableModel) tablaPedidos.getModel();
        int cantidadBorrar; 
        try {
            cantidadBorrar = Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Ingrese una cantidad válida", "Error", "Error al borrar");
            return;
        }

        if (tablaPedidos.getRowCount() > 0) {
            int filaSeleccionada = tablaPedidos.getSelectedRow();
            if (filaSeleccionada >= 0) {
                int cantidadEnPedido = (int) modeloTablaPedidos.getValueAt(filaSeleccionada, 5);
                if (cantidadEnPedido > cantidadBorrar) {
                    double precio = (double) modeloTablaPedidos.getValueAt(filaSeleccionada, 2);
                    double iva = (double) modeloTablaPedidos.getValueAt(filaSeleccionada, 4);
                    double costo=precio * cantidadBorrar * (1 + iva / 100);
                    int nuevaCantidad = cantidadEnPedido- cantidadBorrar;
                    double nuevoCostoTotal=((double)modeloTablaPedidos.getValueAt(filaSeleccionada, 6))- costo;
                    tot= tot - costo;
                    modeloTablaPedidos.setValueAt(nuevaCantidad, filaSeleccionada, 5);
                    modeloTablaPedidos.setValueAt(nuevoCostoTotal, filaSeleccionada, 6);
                    txtTotal.setText(String.valueOf(tot));
                } else if (cantidadEnPedido == cantidadBorrar) {
                    double precio = (double) modeloTablaPedidos.getValueAt(filaSeleccionada, 2);
                    double iva = (double) modeloTablaPedidos.getValueAt(filaSeleccionada, 4);
                    modeloTablaPedidos.removeRow(filaSeleccionada);
                    double costo=precio * cantidadBorrar * (1 + iva / 100);
                    tot= tot - costo;
                    txtTotal.setText(String.valueOf(tot));
                } else {
                    mostrarMensaje("La cantidad a borrar es mayor que la cantidad en el pedido", "Error", "Error al borrar");
                }
            } else {
                mostrarMensaje("Seleccione un producto del pedido para borrar", "Error", "Error al borrar");
            }
        } else {
            mostrarMensaje("No hay productos en el pedido para borrar", "Error", "Error al borrar");
        }
    
    

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // Verificar si hay filas en la tabla de pedidos
        if (tablaPedidos.getRowCount() > 0){ 
 
            try {
                // Crear una nueva factura
                List<LineaFactura> lineasFactura = new ArrayList<>(); 
                
                // Recorrer cada fila de la tabla de pedidos para crear las líneas de factura
                for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
                    int idProducto = (int) tablaPedidos.getValueAt(i, 0);
                    String descripcion = (String) tablaPedidos.getValueAt(i, 1);
                    double precio = (double) tablaPedidos.getValueAt(i, 2);
                    double iva = (double) tablaPedidos.getValueAt(i, 4);
                    int cantidad = (int) tablaPedidos.getValueAt(i, 5);
                    // Crear y configurar la línea de factura
                    Producto producto = control.traerProducto(idProducto);
                    int cantidadActual = producto.getCantidadProducto();
                    int nuevaCantidad = cantidadActual - cantidad;
                    //cambiar stock producto
                    control.editarCantidad(producto, nuevaCantidad);
                    LineaFactura linea = control.crearLineaFactura(producto, cantidad, precio, iva, descripcion);
                    
                    // Añadir la línea de factura a la lista
                    lineasFactura.add(linea);
                }
                // Asignar la lista de líneas a la factura
    
                Factura nuevaFactura = control.crearFactura(lineasFactura);
                Ruta rut = control.traerRuta(id_rut);
                control.crearPedido(nuevaFactura, rut, usr);
                // Persistir el nuevo pedido y la factura
                
                 
                // Mensaje de confirmación y cierre de la ventana
                mostrarMensaje("Pedido finalizado correctamente.", "Info", "Finalización exitosa");
                this.dispose();
                //mostrar factura
                PantallaFactura panF = new PantallaFactura(control, usr,nuevaFactura);
                panF.setVisible(true);
                panF.setLocationRelativeTo(null);
                 
                
            } catch (Exception ex) {
                mostrarMensaje("Error al finalizar el pedido: " + ex.getMessage(), "Error", "Error al Finalizar");

                Logger.getLogger(NuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            mostrarMensaje("Debe agregar productos al pedido antes de finalizar.", "Error", "Error al Finalizar");
        }

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        SeleccionRuta selR = new SeleccionRuta(control,origen, usr);
        selR.setVisible(true);
        selR.setLocationRelativeTo(null);
        this.dispose();    
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cargarTabla() {
        //definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel () {
       
        //que fila y columnas no sean editables
        @Override
        public boolean isCellEditable (int row, int column) {
            return false;
        }
           
       };
       //establecemos los nombres de las columnas
       String titulos[] = {"SKU/Id","Descripcion","Precio", "Peso","Iva", "Cantidad"};
       modeloTabla.setColumnIdentifiers(titulos);
       
       //traer de la bd la lista de Usuarios
       List<Producto> listaProductos = control.traerProductos();
       //preguntamos si la lista está vacía
       if (listaProductos!=null) {
           
           //recorrer la lista
           for (Producto pro : listaProductos) {
               Object[] objeto = {pro.getIdProducto(), pro.getDescripcion(), pro.getPrecio(),pro.getPeso(),pro.getIva(), pro.getCantidadProducto()};
               
               modeloTabla.addRow(objeto);
            }
             
        }
            tablaProductos.setModel(modeloTabla);
    }

    private void cargarTablaPedido() {
        //definir el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTablaPedidos = new DefaultTableModel () {
       
        //que fila y columnas no sean editables
        @Override
        public boolean isCellEditable (int row, int column) {
            return false;
        }
           
       };
       //establecemos los nombres de las columnas
       String titulosPedidos[] = {"ID Producto","Descripcion","Precio", "Peso","Iva", "Cantidad", "Costo Total"};
       modeloTablaPedidos.setColumnIdentifiers(titulosPedidos);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
