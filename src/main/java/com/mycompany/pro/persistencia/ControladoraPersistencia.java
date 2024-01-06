
package com.mycompany.pro.persistencia;

import com.mycompany.pro.logica.Rol;
import com.mycompany.pro.logica.Usuario;
import com.mycompany.pro.logica.Producto;
import com.mycompany.pro.logica.Ruta;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.Empaquetado;
import com.mycompany.pro.logica.LineaFactura;
import com.mycompany.pro.logica.RutaAerea;
import com.mycompany.pro.logica.RutaMaritima;
import com.mycompany.pro.logica.RutaTerrestre;
import com.mycompany.pro.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
    
public class ControladoraPersistencia {
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    ProductoJpaController prodJpa = new ProductoJpaController();
    RutaJpaController rutJpa= new RutaJpaController();
    RutaMaritimaJpaController rutmJpa= new RutaMaritimaJpaController();
    RutaTerrestreJpaController ruttJpa= new RutaTerrestreJpaController();
    RutaAereaJpaController rutaJpa= new RutaAereaJpaController();
    PedidoJpaController pedJpa = new PedidoJpaController();
    FacturaJpaController facJpa = new FacturaJpaController();
    LineaFacturaJpaController linJpa = new LineaFacturaJpaController();
    
    EmpaquetadoJpaController empJpa = new EmpaquetadoJpaController();
    

    public List<Usuario> traerUsuarios() {
       
        List<Usuario> listaUsuario = usuJpa.findUsuarioEntities();
        return listaUsuario;
        
       
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
        
    }

    public void crearUsuario(Usuario usu) throws Exception {
        usuJpa.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuJpa.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearProducto(Producto pro) throws Exception {
        prodJpa.create(pro);
    }

    public List<Producto> traerProductos() {
        List<Producto> listaProducto = prodJpa.findProductoEntities();
        return listaProducto;
    }

    public void borrarProducto(int id_prod) {
        try {
            prodJpa.destroy(id_prod);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public Producto traerProducto(int idProducto) {
        return prodJpa.findProducto(idProducto);
    }

    public List<Ruta> traerRutas() {
        return rutJpa.findRutaEntities();
    }

    public void borrarRuta(int id_rut) {
        try {
            rutJpa.destroy(id_rut);
        } catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void crearRuta(Ruta ruta) throws Exception {
        rutJpa.create(ruta);
    }

    public void crearRutaAerea(RutaAerea rutaAerea) throws Exception {
        rutaJpa.create(rutaAerea);
    }

    public void crearRutaMaritima(RutaMaritima rutaMaritima) throws Exception{
        rutmJpa.create(rutaMaritima);
    }

    public void crearRutaTerrestre(RutaTerrestre rutaTerrestre) throws Exception{
        ruttJpa.create(rutaTerrestre);
    }

    public Ruta traerRuta(int id_rut) {
        return rutJpa.findRuta(id_rut);
    }

    public void editarRutaAerea(Ruta rutaAerea) {
        try {
            rutaJpa.edit((RutaAerea) rutaAerea);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarRutaMaritima(Ruta rutaMaritima) {
        try {
            rutmJpa.edit((RutaMaritima) rutaMaritima);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public void editarRutaTerrestre(Ruta rutaTerrestre) {
        try {
            ruttJpa.edit((RutaTerrestre) rutaTerrestre);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void editarProducto(Producto pro) {
        try {
            prodJpa.edit(pro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void crearLineaFactura(LineaFactura linea) throws Exception {
        linJpa.create(linea);
    }

    public Factura crearFactura(Factura factura) throws Exception {
        facJpa.create(factura);
        return factura;
    }
    public void crearPedido(Pedido nuevoPedido) throws Exception {
        pedJpa.create(nuevoPedido);
        }
    public Factura traerFactura(int idFactura) {
        return facJpa.findFactura(idFactura);
    }


    public void editarCantidad(Producto producto) throws Exception{
        prodJpa.edit(producto);
    }

    public Pedido traerPedido(int idPedido) {
        return pedJpa.findPedido(idPedido);
    }

    public List<Pedido> traerPedidos() {
        List<Pedido> listaPedido = pedJpa.findPedidoEntities();
        return listaPedido;
    }

    public void crearEmpaquetado(Empaquetado nuevoEmpaquetado) {
        empJpa.create(nuevoEmpaquetado);
    }

    public void editarPedido(Pedido ped) throws Exception {
        pedJpa.edit(ped);
    }

    public void editarEstado(Pedido ped) throws Exception {
        pedJpa.edit(ped);
    }




}
