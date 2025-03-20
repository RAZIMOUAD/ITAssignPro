package org.example.itassignpro.dao;


import org.example.itassignpro.model.Employee;
import org.example.itassignpro.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * DAO pour l'entité Employee.
 * Fournit les opérations de création, mise à jour, suppression et lecture.
 */
public class EmployeeDAO {

    /**
     * Persiste un nouvel employé dans la base de données.
     * @param employee L'employé à créer.
     */
    public void create(Employee employee) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(employee);
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
     * Met à jour un employé existant.
     * @param employee L'employé avec les nouvelles données.
     * @return L'employé mis à jour.
     */
    public Employee update(Employee employee) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Employee updatedEmployee = em.merge(employee);
            tx.commit();
            return updatedEmployee;
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
     * Supprime un employé de la base de données.
     * @param employeeId L'identifiant de l'employé à supprimer.
     */
    public void delete(Long employeeId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Employee employee = em.find(Employee.class, employeeId);
            if (employee != null) {
                em.remove(employee);
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

    /**
     * Récupère un employé par son identifiant.
     * @param employeeId L'identifiant de l'employé.
     * @return L'employé trouvé ou null s'il n'existe pas.
     */
    public Employee findById(Long employeeId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Employee.class, employeeId);
        } finally {
            em.close();
        }
    }

    /**
     * Récupère la liste de tous les employés.
     * @return Une liste d'employés.
     */
    public List<Employee> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
