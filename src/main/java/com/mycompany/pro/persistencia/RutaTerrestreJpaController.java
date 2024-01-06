/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro.persistencia;

import com.mycompany.pro.logica.RutaTerrestre;
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
public class RutaTerrestreJpaController implements Serializable {

    public RutaTerrestreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public RutaTerrestreJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(RutaTerrestre rutaTerrestre) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rutaTerrestre);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRutaTerrestre(rutaTerrestre.getIdRuta()) != null) {
                throw new PreexistingEntityException("RutaTerrestre " + rutaTerrestre + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RutaTerrestre rutaTerrestre) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rutaTerrestre = em.merge(rutaTerrestre);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rutaTerrestre.getIdRuta();
                if (findRutaTerrestre(id) == null) {
                    throw new NonexistentEntityException("The rutaTerrestre with id " + id + " no longer exists.");
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
            RutaTerrestre rutaTerrestre;
            try {
                rutaTerrestre = em.getReference(RutaTerrestre.class, id);
                rutaTerrestre.getIdRuta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rutaTerrestre with id " + id + " no longer exists.", enfe);
            }
            em.remove(rutaTerrestre);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RutaTerrestre> findRutaTerrestreEntities() {
        return findRutaTerrestreEntities(true, -1, -1);
    }

    public List<RutaTerrestre> findRutaTerrestreEntities(int maxResults, int firstResult) {
        return findRutaTerrestreEntities(false, maxResults, firstResult);
    }

    private List<RutaTerrestre> findRutaTerrestreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RutaTerrestre.class));
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

    public RutaTerrestre findRutaTerrestre(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RutaTerrestre.class, id);
        } finally {
            em.close();
        }
    }

    public int getRutaTerrestreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RutaTerrestre> rt = cq.from(RutaTerrestre.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
