package org.example.itassignpro.dao;



import org.example.itassignpro.model.ProjectAssignment;
import org.example.itassignpro.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * DAO pour l'entité ProjectAssignment.
 * Fournit les opérations de création et de suppression pour les affectations.
 */
public class ProjectAssignmentDAO {

    /**
     * Persiste une nouvelle affectation dans la base de données.
     * @param assignment L'affectation à créer.
     */
    public void create(ProjectAssignment assignment) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(assignment);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Supprime une affectation de la base de données par son identifiant.
     * @param assignmentId L'identifiant de l'affectation à supprimer.
     */
    public void delete(Long assignmentId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ProjectAssignment assignment = em.find(ProjectAssignment.class, assignmentId);
            if (assignment != null) {
                em.remove(assignment);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}

