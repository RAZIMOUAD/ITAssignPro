package org.example.itassignpro.service;

import org.example.itassignpro.dao.EmployeeDAO;
import org.example.itassignpro.dao.ProjectDAO;
import org.example.itassignpro.dao.ProjectAssignmentDAO;
import org.example.itassignpro.model.Employee;
import org.example.itassignpro.model.Project;
import org.example.itassignpro.model.ProjectAssignment;

/**
 * Service de gestion des affectations d'employés aux projets.
 * Il centralise la logique métier de création et de suppression d'affectations.
 */
public class AssignmentService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ProjectDAO projectDAO = new ProjectDAO();
    private ProjectAssignmentDAO assignmentDAO = new ProjectAssignmentDAO();

    /**
     * Affecte un employé à un projet avec un pourcentage d'implication donné.
     *
     * @param employeeId            l'identifiant de l'employé
     * @param projectId             l'identifiant du projet
     * @param involvementPercentage le pourcentage d'implication
     * @throws IllegalArgumentException si l'employé ou le projet n'existe pas
     */
    public void assignEmployeeToProject(Long employeeId, Long projectId, Double involvementPercentage) {
        Employee employee = employeeDAO.findById(employeeId);
        Project project = projectDAO.findById(projectId);

        if (employee == null || project == null) {
            throw new IllegalArgumentException("L'employé ou le projet n'existe pas.");
        }

        ProjectAssignment assignment = new ProjectAssignment(involvementPercentage, employee, project);
        assignmentDAO.create(assignment);
    }

    /**
     * Supprime une affectation en se basant sur son identifiant.
     *
     * @param assignmentId l'identifiant de l'affectation à supprimer
     */
    public void removeAssignment(Long assignmentId) {
        assignmentDAO.delete(assignmentId);
    }
}
