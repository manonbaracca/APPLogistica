/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.pro.logica.Rol;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.Usuario;
import com.mycompany.pro.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.pro.persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manu
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public UsuarioJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getPedidos() == null) {
            usuario.setPedidos(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol unRol = usuario.getUnRol();
            if (unRol != null) {
                unRol = em.getReference(unRol.getClass(), unRol.getId());
                usuario.setUnRol(unRol);
            }
            List<Pedido> attachedPedidos = new ArrayList<Pedido>();
            for (Pedido pedidosPedidoToAttach : usuario.getPedidos()) {
                pedidosPedidoToAttach = em.getReference(pedidosPedidoToAttach.getClass(), pedidosPedidoToAttach.getIdPedido());
                attachedPedidos.add(pedidosPedidoToAttach);
            }
            usuario.setPedidos(attachedPedidos);
            em.persist(usuario);
            if (unRol != null) {
                unRol.getListaUsuarios().add(usuario);
                unRol = em.merge(unRol);
            }
            for (Pedido pedidosPedido : usuario.getPedidos()) {
                Usuario oldUsrOfPedidosPedido = pedidosPedido.getUsr();
                pedidosPedido.setUsr(usuario);
                pedidosPedido = em.merge(pedidosPedido);
                if (oldUsrOfPedidosPedido != null) {
                    oldUsrOfPedidosPedido.getPedidos().remove(pedidosPedido);
                    oldUsrOfPedidosPedido = em.merge(oldUsrOfPedidosPedido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getIdUsuario()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            Rol unRolOld = persistentUsuario.getUnRol();
            Rol unRolNew = usuario.getUnRol();
            List<Pedido> pedidosOld = persistentUsuario.getPedidos();
            List<Pedido> pedidosNew = usuario.getPedidos();
            if (unRolNew != null) {
                unRolNew = em.getReference(unRolNew.getClass(), unRolNew.getId());
                usuario.setUnRol(unRolNew);
            }
            List<Pedido> attachedPedidosNew = new ArrayList<Pedido>();
            for (Pedido pedidosNewPedidoToAttach : pedidosNew) {
                pedidosNewPedidoToAttach = em.getReference(pedidosNewPedidoToAttach.getClass(), pedidosNewPedidoToAttach.getIdPedido());
                attachedPedidosNew.add(pedidosNewPedidoToAttach);
            }
            pedidosNew = attachedPedidosNew;
            usuario.setPedidos(pedidosNew);
            usuario = em.merge(usuario);
            if (unRolOld != null && !unRolOld.equals(unRolNew)) {
                unRolOld.getListaUsuarios().remove(usuario);
                unRolOld = em.merge(unRolOld);
            }
            if (unRolNew != null && !unRolNew.equals(unRolOld)) {
                unRolNew.getListaUsuarios().add(usuario);
                unRolNew = em.merge(unRolNew);
            }
            for (Pedido pedidosOldPedido : pedidosOld) {
                if (!pedidosNew.contains(pedidosOldPedido)) {
                    pedidosOldPedido.setUsr(null);
                    pedidosOldPedido = em.merge(pedidosOldPedido);
                }
            }
            for (Pedido pedidosNewPedido : pedidosNew) {
                if (!pedidosOld.contains(pedidosNewPedido)) {
                    Usuario oldUsrOfPedidosNewPedido = pedidosNewPedido.getUsr();
                    pedidosNewPedido.setUsr(usuario);
                    pedidosNewPedido = em.merge(pedidosNewPedido);
                    if (oldUsrOfPedidosNewPedido != null && !oldUsrOfPedidosNewPedido.equals(usuario)) {
                        oldUsrOfPedidosNewPedido.getPedidos().remove(pedidosNewPedido);
                        oldUsrOfPedidosNewPedido = em.merge(oldUsrOfPedidosNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Rol unRol = usuario.getUnRol();
            if (unRol != null) {
                unRol.getListaUsuarios().remove(usuario);
                unRol = em.merge(unRol);
            }
            List<Pedido> pedidos = usuario.getPedidos();
            for (Pedido pedidosPedido : pedidos) {
                pedidosPedido.setUsr(null);
                pedidosPedido = em.merge(pedidosPedido);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
