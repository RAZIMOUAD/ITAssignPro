package org.example.itassignpro.controller;
import org.example.itassignpro.dao.ProjectDAO;
import org.example.itassignpro.model.Project;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("projectController")
@SessionScoped
public class ProjectController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Project project = new Project();
    private List<Project> projects;

    private ProjectDAO projectDAO = new ProjectDAO();

    public ProjectController() {
        loadProjects();
    }
    public void loadProjects() {
        projects = projectDAO.findAll();
    }
    public String createProject() {
        try {
            projectDAO.create(project);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Projet créé avec succès"));
            project = new Project(); // Réinitialise pour un nouvel ajout
            loadProjects();
            return "projectList?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erreur lors de la création du projet : " + e.getMessage(), null));
            return null;
        }
    }
    public String updateProject() {
        try {
            projectDAO.update(project);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Projet mis à jour avec succès"));
            project = new Project(); // Réinitialise le bean
            loadProjects();
            return "projectList?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erreur lors de la mise à jour du projet : " + e.getMessage(), null));
            return null;
        }
    }
    public String deleteProject(Long projectId) {
        try {
            projectDAO.delete(projectId);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Projet supprimé avec succès"));
            loadProjects();
            return "projectList?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erreur lors de la suppression du projet : " + e.getMessage(), null));
            return null;
        }
    }

    // Getters et setters

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
