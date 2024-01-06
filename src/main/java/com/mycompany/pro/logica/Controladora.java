
package com.mycompany.pro.logica;

import com.mycompany.pro.logica.Pedido.EstadoPedido;
import com.mycompany.pro.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controladora {
    ControladoraPersistencia controlPersis;
    
    public Controladora(){
        controlPersis= new ControladoraPersistencia();
    }
    public Usuario validarUsuario(String usuario, String contrasenia) {
        Usuario usr =null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for(Usuario usu: listaUsuarios){
            if (usu.getNombreUsuario().equals(usuario)){
                if (usu.getClave().equals(contrasenia)){
                    usr = usu;
                    return usr;
                }
                else{
                    usr = null;
                    return usr;
                }
            
            }
            else{
               usr = null;
               
                
            }
        }
        return usr;
    }

    public List<Usuario> traerUsuarios() {
           return controlPersis.traerUsuarios();

    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String email, String tel, String rolRecibido) throws Exception {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setClave(contra);
        usu.setEmail(email);
        usu.setTel(tel);
        
        Rol rolEncontrado= new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado!=null){
        usu.setUnRol(rolEncontrado);
        }
        
        int id=this.buscarUltimaIdUsuarios();
        usu.setIdUsuario(id+1);
        
        controlPersis.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido){
        List<Rol> listaRoles = controlPersis.traerRoles();
        for(Rol rol:listaRoles){
            if(rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        List <Usuario> listaUsuarios = this.traerUsuarios();
        Usuario usu=listaUsuarios.get(listaUsuarios.size()-1);
        return usu.getIdUsuario();
    }

    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);
        
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String tel, String email, String rolRecibido) {
        
        usu.setNombreUsuario(usuario);
        usu.setClave(contra);
        usu.setTel(tel);
        usu.setEmail(email);

        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado!=null) {
            usu.setUnRol(rolEncontrado);
        }
        
        controlPersis.editarUsuario(usu);
        
    }
    public void crearProducto (int idProducto, String descripcion, double precio, double peso, double iva, int cantidadProducto) throws Exception{
        Producto pro = new Producto();
        pro.setIdProducto(idProducto);
        pro.setDescripcion(descripcion);
        pro.setPrecio(precio);
        pro.setPeso(peso);
        pro.setIva(iva);   
        pro.setCantidadProducto(cantidadProducto);

        controlPersis.crearProducto(pro);
    }

    public List<Producto> traerProductos() {
           return controlPersis.traerProductos();
    }

    public void borrarProducto(int id_prod) {
        controlPersis.borrarProducto(id_prod);
    }

    public Producto traerProducto(int idProducto) {
        return controlPersis.traerProducto(idProducto);
    }
    public Usuario valUsuario(String usuario) {
        Usuario usr =null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for(Usuario usu: listaUsuarios){
            if (usu.getNombreUsuario().equals(usuario)){
                    usr = usu;
                    return usr;
                }
            return usr;
        }
    return usr;
    }    

    public List<Ruta> traerRutas() {
        return controlPersis.traerRutas();
    }

    public void borrarRuta(int id_rut) {
        controlPersis.borrarRuta(id_rut);
    }


    
    public void crearRutaAerea(String origen, String destino, String shipper, int tiempo, int idUsuario) throws Exception {

        RutaAerea rutaAerea = new RutaAerea();
        
        rutaAerea.setOrigen(origen);
        rutaAerea.setDestino(destino);
        rutaAerea.setTiempoEnvio(tiempo);
        rutaAerea.setShipper(shipper);
        int id = this.buscarUltimaIdRutas();
        rutaAerea.setIdRuta(id + 1);
        rutaAerea.setIdUsu(idUsuario);
        controlPersis.crearRutaAerea(rutaAerea); 
    }

    private int buscarUltimaIdRutas() {
        List <Ruta> listaRutas = this.traerRutas();
        if (listaRutas.isEmpty()) {
            return 0; 
        } else {
            Ruta rut=listaRutas.get(listaRutas.size()-1);
            return rut.getIdRuta(); 
        }
    
    }

    public Ruta traerRuta(int id_rut) {
        return controlPersis.traerRuta(id_rut);
    }

    public void crearRutaMaritima( String origen, String destino, String shipper, int tiempo,int idUsuario) throws Exception {
        RutaMaritima rutaMaritima = new RutaMaritima();
        
        rutaMaritima.setOrigen(origen);
        rutaMaritima.setDestino(destino);
        rutaMaritima.setTiempoEnvio(tiempo);
        rutaMaritima.setShipper(shipper);
        int id = this.buscarUltimaIdRutas();
        rutaMaritima.setIdRuta(id + 1);
        rutaMaritima.setIdUsu(idUsuario);
        controlPersis.crearRutaMaritima(rutaMaritima); 
    }

    public void crearRutaTerrestre(String origen, String destino, String shipper, int tiempo,int idUsuario) throws Exception {
        RutaTerrestre rutaTerrestre = new RutaTerrestre();
        
        rutaTerrestre.setOrigen(origen);
        rutaTerrestre.setDestino(destino);
        rutaTerrestre.setTiempoEnvio(tiempo);
        rutaTerrestre.setShipper(shipper);
        int id = this.buscarUltimaIdRutas();
        rutaTerrestre.setIdRuta(id + 1);
        rutaTerrestre.setIdUsu(idUsuario);
        controlPersis.crearRutaTerrestre(rutaTerrestre); 
    }

    public void editarRutaMaritima(Ruta ru,String origen, String destino, int tiempo) {
        ru.setOrigen(origen);
        ru.setDestino(destino);
        
        ru.setTiempoEnvio(tiempo);
        
        
        controlPersis.editarRutaMaritima(ru); 
    }

    public void editarRutaAerea(Ruta ru,String origen, String destino, int tiempo) {
        ru.setOrigen(origen);
        ru.setDestino(destino);
        
        ru.setTiempoEnvio(tiempo);
        controlPersis.editarRutaAerea(ru); 
    }

    public void editarRutaTerrestre(Ruta ru,String origen, String destino, int tiempo) {
        ru.setOrigen(origen);
        ru.setDestino(destino);
       
        ru.setTiempoEnvio(tiempo);
        controlPersis.editarRutaTerrestre(ru); 
    }
    
    public Set<String> obtenerDestinosDisponibles() {
        List<Ruta> rutas = this.traerRutas(); 
        Set<String> destinos = new HashSet<>();
        for (Ruta ruta : rutas) {
            destinos.add(ruta.getDestino());
        }
        return destinos;
    }

    public void editarProducto(Producto pro, int idProducto, String descripcion, double precio, double peso, double iva, int cantidadProducto) {
        
        pro.setIdProducto(idProducto);
        pro.setDescripcion(descripcion);
        pro.setPrecio(precio);
        pro.setPeso(peso);
        pro.setIva(iva);   
        pro.setCantidadProducto(cantidadProducto);

        controlPersis.editarProducto(pro);
    }


    
   public Factura crearFactura(List<LineaFactura> lineasFactura) throws Exception{
        Factura factura = new Factura();
        double totalIva = 0;
        double subtotal = 0;

        for (LineaFactura linea : lineasFactura) {
            subtotal += linea.getPrecio() * linea.getCantidadLinea();
            totalIva += linea.getPrecio() * linea.getCantidadLinea() * (linea.getIva() / 100);
            linea.setFactura(factura);
            factura.getLineasFactura().add(linea);
            

        }

        double total = subtotal + totalIva;
        factura.setSubtotal(subtotal);
        factura.setTotalIva(totalIva);
        factura.setTotal(total);
        factura.setLineasFactura(lineasFactura);
        
        controlPersis.crearFactura(factura);
        return factura;
}
   
   public LineaFactura crearLineaFactura(Producto pro,int cantidad,double precio,double iva,String descripcion) throws Exception{
        LineaFactura linea = new LineaFactura();
        linea.setProducto(pro);
        linea.setCantidadLinea(cantidad);
        linea.setPrecio(precio);
        linea.setIva(iva);
        double costoTotal = cantidad * precio * (1 + iva / 100);
        linea.setCostoTotal(costoTotal);
        linea.setDescripcion(descripcion);
        controlPersis.crearLineaFactura(linea);
        
        return linea;
   }

    public void editarCantidad(Producto producto, int cantidad) {
        producto.setCantidadProducto(cantidad);

        controlPersis.editarProducto(producto);
    }
    public void crearPedido(Factura factura, Ruta ruta, Usuario usr) throws Exception {
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setRuta(ruta);
        nuevoPedido.setFechaPedido(LocalDate.now());
        nuevoPedido.setEstado(EstadoPedido.EN_PREPARACION);
            // Asignar la factura al pedido
        nuevoPedido.setFactura(factura);

        // Importante: Asignar el pedido a la factura
        factura.setPedido(nuevoPedido);
        nuevoPedido.setUsr(usr);

         // Verificar si el usuario ya tiene pedidos asignados
        List<Pedido> listaPedidos = usr.getPedidos();
        if (listaPedidos == null) {
            listaPedidos = new ArrayList<>();
        }
        // Añadir el nuevo pedido a la lista
        listaPedidos.add(nuevoPedido);

        // Asignar la lista actualizada al usuario
        usr.setPedidos(listaPedidos);

   
   
        controlPersis.crearPedido(nuevoPedido);
    }
    public Pedido traerPedido(int idPedido) {
        return controlPersis.traerPedido(idPedido);
    }
    
    public List<Pedido> traerPedidos() {
        return controlPersis.traerPedidos();
    }
        public Factura traerFactura(int idFactura) {
        return controlPersis.traerFactura(idFactura);
    }

    public void editarPedido(Pedido ped, Empaquetado emp ) throws Exception {
        ped.setEstado(EstadoPedido.ENVIADO);
        ped.setEmpaquetado(emp);
        controlPersis.editarPedido(ped);
    }

    public Empaquetado createEmpaquetado(int numeroContenedores, double pesoTotalPedido, Pedido pedido) {
        Empaquetado nuevoEmpaquetado = new Empaquetado();
        nuevoEmpaquetado.setPesoTotal(pesoTotalPedido);
        nuevoEmpaquetado.setPedido(pedido);
        controlPersis.crearEmpaquetado(nuevoEmpaquetado);
        return nuevoEmpaquetado;
    }

    public void editarEstado(Pedido ped, EstadoPedido nuevoEstado) throws Exception {
        ped.setEstado(nuevoEstado);
        controlPersis.editarEstado(ped);
    }


}
