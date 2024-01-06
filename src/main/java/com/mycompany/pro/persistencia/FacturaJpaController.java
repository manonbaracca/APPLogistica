
package com.mycompany.pro.persistencia;

import com.mycompany.pro.logica.Factura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.pro.logica.Pedido;
import com.mycompany.pro.logica.LineaFactura;
import com.mycompany.pro.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
          public FacturaJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }

    public Factura create(Factura factura) {
        if (factura.getLineasFactura() == null) {
            factura.setLineasFactura(new ArrayList<LineaFactura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido = factura.getPedido();
            if (pedido != null) {
                pedido = em.getReference(pedido.getClass(), pedido.getIdPedido());
                factura.setPedido(pedido);
            }
            List<LineaFactura> attachedLineasFactura = new ArrayList<LineaFactura>();
            for (LineaFactura lineasFacturaLineaFacturaToAttach : factura.getLineasFactura()) {
                lineasFacturaLineaFacturaToAttach = em.getReference(lineasFacturaLineaFacturaToAttach.getClass(), lineasFacturaLineaFacturaToAttach.getIdLinea());
                attachedLineasFactura.add(lineasFacturaLineaFacturaToAttach);
            }
            factura.setLineasFactura(attachedLineasFactura);
            em.persist(factura);
            if (pedido != null) {
                Factura oldFacturaOfPedido = pedido.getFactura();
                if (oldFacturaOfPedido != null) {
                    oldFacturaOfPedido.setPedido(null);
                    oldFacturaOfPedido = em.merge(oldFacturaOfPedido);
                }
                pedido.setFactura(factura);
                pedido = em.merge(pedido);
            }
            for (LineaFactura lineasFacturaLineaFactura : factura.getLineasFactura()) {
                Factura oldFacturaOfLineasFacturaLineaFactura = lineasFacturaLineaFactura.getFactura();
                lineasFacturaLineaFactura.setFactura(factura);
                lineasFacturaLineaFactura = em.merge(lineasFacturaLineaFactura);
                if (oldFacturaOfLineasFacturaLineaFactura != null) {
                    oldFacturaOfLineasFacturaLineaFactura.getLineasFactura().remove(lineasFacturaLineaFactura);
                    oldFacturaOfLineasFacturaLineaFactura = em.merge(oldFacturaOfLineasFacturaLineaFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return factura;
    }

    public void edit(Factura factura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Pedido pedidoOld = persistentFactura.getPedido();
            Pedido pedidoNew = factura.getPedido();
            List<LineaFactura> lineasFacturaOld = persistentFactura.getLineasFactura();
            List<LineaFactura> lineasFacturaNew = factura.getLineasFactura();
            if (pedidoNew != null) {
                pedidoNew = em.getReference(pedidoNew.getClass(), pedidoNew.getIdPedido());
                factura.setPedido(pedidoNew);
            }
            List<LineaFactura> attachedLineasFacturaNew = new ArrayList<LineaFactura>();
            for (LineaFactura lineasFacturaNewLineaFacturaToAttach : lineasFacturaNew) {
                lineasFacturaNewLineaFacturaToAttach = em.getReference(lineasFacturaNewLineaFacturaToAttach.getClass(), lineasFacturaNewLineaFacturaToAttach.getIdLinea());
                attachedLineasFacturaNew.add(lineasFacturaNewLineaFacturaToAttach);
            }
            lineasFacturaNew = attachedLineasFacturaNew;
            factura.setLineasFactura(lineasFacturaNew);
            factura = em.merge(factura);
            if (pedidoOld != null && !pedidoOld.equals(pedidoNew)) {
                pedidoOld.setFactura(null);
                pedidoOld = em.merge(pedidoOld);
            }
            if (pedidoNew != null && !pedidoNew.equals(pedidoOld)) {
                Factura oldFacturaOfPedido = pedidoNew.getFactura();
                if (oldFacturaOfPedido != null) {
                    oldFacturaOfPedido.setPedido(null);
                    oldFacturaOfPedido = em.merge(oldFacturaOfPedido);
                }
                pedidoNew.setFactura(factura);
                pedidoNew = em.merge(pedidoNew);
            }
            for (LineaFactura lineasFacturaOldLineaFactura : lineasFacturaOld) {
                if (!lineasFacturaNew.contains(lineasFacturaOldLineaFactura)) {
                    lineasFacturaOldLineaFactura.setFactura(null);
                    lineasFacturaOldLineaFactura = em.merge(lineasFacturaOldLineaFactura);
                }
            }
            for (LineaFactura lineasFacturaNewLineaFactura : lineasFacturaNew) {
                if (!lineasFacturaOld.contains(lineasFacturaNewLineaFactura)) {
                    Factura oldFacturaOfLineasFacturaNewLineaFactura = lineasFacturaNewLineaFactura.getFactura();
                    lineasFacturaNewLineaFactura.setFactura(factura);
                    lineasFacturaNewLineaFactura = em.merge(lineasFacturaNewLineaFactura);
                    if (oldFacturaOfLineasFacturaNewLineaFactura != null && !oldFacturaOfLineasFacturaNewLineaFactura.equals(factura)) {
                        oldFacturaOfLineasFacturaNewLineaFactura.getLineasFactura().remove(lineasFacturaNewLineaFactura);
                        oldFacturaOfLineasFacturaNewLineaFactura = em.merge(oldFacturaOfLineasFacturaNewLineaFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            Pedido pedido = factura.getPedido();
            if (pedido != null) {
                pedido.setFactura(null);
                pedido = em.merge(pedido);
            }
            List<LineaFactura> lineasFactura = factura.getLineasFactura();
            for (LineaFactura lineasFacturaLineaFactura : lineasFactura) {
                lineasFacturaLineaFactura.setFactura(null);
                lineasFacturaLineaFactura = em.merge(lineasFacturaLineaFactura);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
