package org.example.itassignpro.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "PROJECTS")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double budget;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectAssignment> projectAssignments = new ArrayList<>();
    public Project() {
    }
    public Project(String name, Double budget) {
        this.name = name;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<ProjectAssignment> getProjectAssignments() {
        return projectAssignments;
    }

    public void setProjectAssignments(List<ProjectAssignment> projectAssignments) {
        this.projectAssignments = projectAssignments;
    }
    /**
     * Ajoute une affectation à la liste et gère la relation bidirectionnelle.
     * @param assignment L'affectation à ajouter.
     */
    public void addProjectAssignment(ProjectAssignment assignment) {
        projectAssignments.add(assignment);
        assignment.setProject(this);
    }

    /**
     * Supprime une affectation de la liste et gère la relation bidirectionnelle.
     * @param assignment L'affectation à supprimer.
     */
    public void removeProjectAssignment(ProjectAssignment assignment) {
        projectAssignments.remove(assignment);
        assignment.setProject(null);
    }

}
