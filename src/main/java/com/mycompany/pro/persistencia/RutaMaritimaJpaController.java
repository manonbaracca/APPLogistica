/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro.persistencia;

import com.mycompany.pro.logica.RutaMaritima;
import com.mycompany.pro.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.pro.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author manu
 */
public class RutaMaritimaJpaController implements Serializable {

    public RutaMaritimaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public RutaMaritimaJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(RutaMaritima rutaMaritima) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rutaMaritima);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRutaMaritima(rutaMaritima.getIdRuta()) != null) {
                throw new PreexistingEntityException("RutaMaritima " + rutaMaritima + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RutaMaritima rutaMaritima) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rutaMaritima = em.merge(rutaMaritima);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rutaMaritima.getIdRuta();
                if (findRutaMaritima(id) == null) {
                    throw new NonexistentEntityException("The rutaMaritima with id " + id + " no longer exists.");
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
            RutaMaritima rutaMaritima;
            try {
                rutaMaritima = em.getReference(RutaMaritima.class, id);
                rutaMaritima.getIdRuta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutaMaritima with id " + id + " no longer exists.", enfe);
            }
            em.remove(rutaMaritima);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RutaMaritima> findRutaMaritimaEntities() {
        return findRutaMaritimaEntities(true, -1, -1);
    }

    public List<RutaMaritima> findRutaMaritimaEntities(int maxResults, int firstResult) {
        return findRutaMaritimaEntities(false, maxResults, firstResult);
    }

    private List<RutaMaritima> findRutaMaritimaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RutaMaritima.class));
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

    public RutaMaritima findRutaMaritima(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RutaMaritima.class, id);
        } finally {
            em.close();
        }
    }

    public int getRutaMaritimaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RutaMaritima> rt = cq.from(RutaMaritima.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
