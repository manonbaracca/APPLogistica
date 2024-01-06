/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pro.persistencia;

import com.mycompany.pro.logica.Empaquetado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class EmpaquetadoJpaController implements Serializable {

    public EmpaquetadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
      public EmpaquetadoJpaController(){
        emf = Persistence.createEntityManagerFactory("proPU");
    }
    public void create(Empaquetado empaquetado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido = empaquetado.getPedido();
            if (pedido != null) {
                pedido = em.getReference(pedido.getClass(), pedido.getIdPedido());
                empaquetado.setPedido(pedido);
            }
            em.persist(empaquetado);
            if (pedido != null) {
                Empaquetado oldEmpaquetadoOfPedido = pedido.getEmpaquetado();
                if (oldEmpaquetadoOfPedido != null) {
                    oldEmpaquetadoOfPedido.setPedido(null);
                    oldEmpaquetadoOfPedido = em.merge(oldEmpaquetadoOfPedido);
                }
                pedido.setEmpaquetado(empaquetado);
                pedido = em.merge(pedido);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empaquetado empaquetado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empaquetado persistentEmpaquetado = em.find(Empaquetado.class, empaquetado.getIdEmpaquetado());
            Pedido pedidoOld = persistentEmpaquetado.getPedido();
            Pedido pedidoNew = empaquetado.getPedido();
            if (pedidoNew != null) {
                pedidoNew = em.getReference(pedidoNew.getClass(), pedidoNew.getIdPedido());
                empaquetado.setPedido(pedidoNew);
            }
            empaquetado = em.merge(empaquetado);
            if (pedidoOld != null && !pedidoOld.equals(pedidoNew)) {
                pedidoOld.setEmpaquetado(null);
                pedidoOld = em.merge(pedidoOld);
            }
            if (pedidoNew != null && !pedidoNew.equals(pedidoOld)) {
                Empaquetado oldEmpaquetadoOfPedido = pedidoNew.getEmpaquetado();
                if (oldEmpaquetadoOfPedido != null) {
                    oldEmpaquetadoOfPedido.setPedido(null);
                    oldEmpaquetadoOfPedido = em.merge(oldEmpaquetadoOfPedido);
                }
                pedidoNew.setEmpaquetado(empaquetado);
                pedidoNew = em.merge(pedidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empaquetado.getIdEmpaquetado();
                if (findEmpaquetado(id) == null) {
                    throw new NonexistentEntityException("The empaquetado with id " + id + " no longer exists.");
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
            Empaquetado empaquetado;
            try {
                empaquetado = em.getReference(Empaquetado.class, id);
                empaquetado.getIdEmpaquetado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empaquetado with id " + id + " no longer exists.", enfe);
            }
            Pedido pedido = empaquetado.getPedido();
            if (pedido != null) {
                pedido.setEmpaquetado(null);
                pedido = em.merge(pedido);
            }
            em.remove(empaquetado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empaquetado> findEmpaquetadoEntities() {
        return findEmpaquetadoEntities(true, -1, -1);
    }

    public List<Empaquetado> findEmpaquetadoEntities(int maxResults, int firstResult) {
        return findEmpaquetadoEntities(false, maxResults, firstResult);
    }

    private List<Empaquetado> findEmpaquetadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empaquetado.class));
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

    public Empaquetado findEmpaquetado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empaquetado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpaquetadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empaquetado> rt = cq.from(Empaquetado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
