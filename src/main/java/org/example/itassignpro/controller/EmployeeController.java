package org.example.itassignpro.controller;

import org.example.itassignpro.dao.EmployeeDAO;
import org.example.itassignpro.model.Employee;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("employeeController")
@SessionScoped
public class EmployeeController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Employee employee = new Employee();
    private List<Employee> employees;

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private String skillsInput;
    public EmployeeController() {
        loadEmployees();
    }
    public void loadEmployees() {
        employees = employeeDAO.findAll();
    }
    public String createEmployee() {
        try {
            employeeDAO.create(employee);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Employé créé avec succès"));
            employee = new Employee(); // réinitialise le bean pour un nouvel ajout
            loadEmployees();
            return "employeeList?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la création : " + e.getMessage(), null));
            return null;
        }
    }

    public String updateEmployee() {
        try {
            employeeDAO.update(employee);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Employé mis à jour avec succès"));
            employee = new Employee(); // réinitialise le bean
            loadEmployees();
            return "employeeList?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la mise à jour : " + e.getMessage(), null));
            return null;
        }
    }
    public String deleteEmployee(Long employeeId) {
        try {
            employeeDAO.delete(employeeId);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Employé supprimé avec succès"));
            loadEmployees();
            return "employeeList?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la suppression : " + e.getMessage(), null));
            return null;
        }
    }
    public String prepareEdit(Employee emp) {
        this.employee = emp;
        // Convertit la liste en chaîne pour la pré-remplir dans le champ texte
        if (emp.getSkills() != null) {
            this.skillsInput = String.join(", ", emp.getSkills());
        } else {
            this.skillsInput = "";
        }
        return null; // Reste sur la même page ou ouvre une modal
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public String getSkillsInput() {
        return skillsInput;
    }

    public void setSkillsInput(String skillsInput) {
        this.skillsInput = skillsInput;
    }

}
