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
import com.mycompany.pro.logica.Factura;
import com.mycompany.pro.logica.LineaFactura;
import com.mycompany.pro.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manu
 */
public class LineaFacturaJpaController implements Serializable {

    public LineaFacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public LineaFacturaJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(LineaFactura lineaFactura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura = lineaFactura.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                lineaFactura.setFactura(factura);
            }
            em.persist(lineaFactura);
            if (factura != null) {
                factura.getLineasFactura().add(lineaFactura);
                factura = em.merge(factura);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LineaFactura lineaFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LineaFactura persistentLineaFactura = em.find(LineaFactura.class, lineaFactura.getIdLinea());
            Factura facturaOld = persistentLineaFactura.getFactura();
            Factura facturaNew = lineaFactura.getFactura();
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                lineaFactura.setFactura(facturaNew);
            }
            lineaFactura = em.merge(lineaFactura);
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.getLineasFactura().remove(lineaFactura);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                facturaNew.getLineasFactura().add(lineaFactura);
                facturaNew = em.merge(facturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = lineaFactura.getIdLinea();
                if (findLineaFactura(id) == null) {
                    throw new NonexistentEntityException("The lineaFactura with id " + id + " no longer exists.");
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
            LineaFactura lineaFactura;
            try {
                lineaFactura = em.getReference(LineaFactura.class, id);
                lineaFactura.getIdLinea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lineaFactura with id " + id + " no longer exists.", enfe);
            }
            Factura factura = lineaFactura.getFactura();
            if (factura != null) {
                factura.getLineasFactura().remove(lineaFactura);
                factura = em.merge(factura);
            }
            em.remove(lineaFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LineaFactura> findLineaFacturaEntities() {
        return findLineaFacturaEntities(true, -1, -1);
    }

    public List<LineaFactura> findLineaFacturaEntities(int maxResults, int firstResult) {
        return findLineaFacturaEntities(false, maxResults, firstResult);
    }

    private List<LineaFactura> findLineaFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LineaFactura.class));
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

    public LineaFactura findLineaFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LineaFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getLineaFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LineaFactura> rt = cq.from(LineaFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
