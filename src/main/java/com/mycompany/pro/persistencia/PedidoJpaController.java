
package com.mycompany.pro.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.pro.logica.Usuario;
import com.mycompany.pro.logica.Empaquetado;
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manu
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public PedidoJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(Pedido pedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usr = pedido.getUsr();
            if (usr != null) {
                usr = em.getReference(usr.getClass(), usr.getIdUsuario());
                pedido.setUsr(usr);
            }
            Empaquetado empaquetado = pedido.getEmpaquetado();
            if (empaquetado != null) {
                empaquetado = em.getReference(empaquetado.getClass(), empaquetado.getIdEmpaquetado());
                pedido.setEmpaquetado(empaquetado);
            }
            Factura factura = pedido.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                pedido.setFactura(factura);
            }
            em.persist(pedido);
            if (usr != null) {
                usr.getPedidos().add(pedido);
                usr = em.merge(usr);
            }
            if (empaquetado != null) {
                Pedido oldPedidoOfEmpaquetado = empaquetado.getPedido();
                if (oldPedidoOfEmpaquetado != null) {
                    oldPedidoOfEmpaquetado.setEmpaquetado(null);
                    oldPedidoOfEmpaquetado = em.merge(oldPedidoOfEmpaquetado);
                }
                empaquetado.setPedido(pedido);
                empaquetado = em.merge(empaquetado);
            }
            if (factura != null) {
                Pedido oldPedidoOfFactura = factura.getPedido();
                if (oldPedidoOfFactura != null) {
                    oldPedidoOfFactura.setFactura(null);
                    oldPedidoOfFactura = em.merge(oldPedidoOfFactura);
                }
                factura.setPedido(pedido);
                factura = em.merge(factura);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Usuario usrOld = persistentPedido.getUsr();
            Usuario usrNew = pedido.getUsr();
            Empaquetado empaquetadoOld = persistentPedido.getEmpaquetado();
            Empaquetado empaquetadoNew = pedido.getEmpaquetado();
            Factura facturaOld = persistentPedido.getFactura();
            Factura facturaNew = pedido.getFactura();
            if (usrNew != null) {
                usrNew = em.getReference(usrNew.getClass(), usrNew.getIdUsuario());
                pedido.setUsr(usrNew);
            }
            if (empaquetadoNew != null) {
                empaquetadoNew = em.getReference(empaquetadoNew.getClass(), empaquetadoNew.getIdEmpaquetado());
                pedido.setEmpaquetado(empaquetadoNew);
            }
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                pedido.setFactura(facturaNew);
            }
            pedido = em.merge(pedido);
            if (usrOld != null && !usrOld.equals(usrNew)) {
                usrOld.getPedidos().remove(pedido);
                usrOld = em.merge(usrOld);
            }
            if (usrNew != null && !usrNew.equals(usrOld)) {
                usrNew.getPedidos().add(pedido);
                usrNew = em.merge(usrNew);
            }
            if (empaquetadoOld != null && !empaquetadoOld.equals(empaquetadoNew)) {
                empaquetadoOld.setPedido(null);
                empaquetadoOld = em.merge(empaquetadoOld);
            }
            if (empaquetadoNew != null && !empaquetadoNew.equals(empaquetadoOld)) {
                Pedido oldPedidoOfEmpaquetado = empaquetadoNew.getPedido();
                if (oldPedidoOfEmpaquetado != null) {
                    oldPedidoOfEmpaquetado.setEmpaquetado(null);
                    oldPedidoOfEmpaquetado = em.merge(oldPedidoOfEmpaquetado);
                }
                empaquetadoNew.setPedido(pedido);
                empaquetadoNew = em.merge(empaquetadoNew);
            }
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.setPedido(null);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                Pedido oldPedidoOfFactura = facturaNew.getPedido();
                if (oldPedidoOfFactura != null) {
                    oldPedidoOfFactura.setFactura(null);
                    oldPedidoOfFactura = em.merge(oldPedidoOfFactura);
                }
                facturaNew.setPedido(pedido);
                facturaNew = em.merge(facturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            Usuario usr = pedido.getUsr();
            if (usr != null) {
                usr.getPedidos().remove(pedido);
                usr = em.merge(usr);
            }
            Empaquetado empaquetado = pedido.getEmpaquetado();
            if (empaquetado != null) {
                empaquetado.setPedido(null);
                empaquetado = em.merge(empaquetado);
            }
            Factura factura = pedido.getFactura();
            if (factura != null) {
                factura.setPedido(null);
                factura = em.merge(factura);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
