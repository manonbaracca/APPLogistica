/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro.persistencia;

import com.mycompany.pro.logica.RutaAerea;
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
public class RutaAereaJpaController implements Serializable {

    public RutaAereaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public RutaAereaJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(RutaAerea rutaAerea) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rutaAerea);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRutaAerea(rutaAerea.getIdRuta()) != null) {
                throw new PreexistingEntityException("RutaAerea " + rutaAerea + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RutaAerea rutaAerea) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rutaAerea = em.merge(rutaAerea);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rutaAerea.getIdRuta();
                if (findRutaAerea(id) == null) {
                    throw new NonexistentEntityException("The rutaAerea with id " + id + " no longer exists.");
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
            RutaAerea rutaAerea;
            try {
                rutaAerea = em.getReference(RutaAerea.class, id);
                rutaAerea.getIdRuta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutaAerea with id " + id + " no longer exists.", enfe);
            }
            em.remove(rutaAerea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RutaAerea> findRutaAereaEntities() {
        return findRutaAereaEntities(true, -1, -1);
    }

    public List<RutaAerea> findRutaAereaEntities(int maxResults, int firstResult) {
        return findRutaAereaEntities(false, maxResults, firstResult);
    }

    private List<RutaAerea> findRutaAereaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RutaAerea.class));
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

    public RutaAerea findRutaAerea(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RutaAerea.class, id);
        } finally {
            em.close();
        }
    }

    public int getRutaAereaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RutaAerea> rt = cq.from(RutaAerea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
