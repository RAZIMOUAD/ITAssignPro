package org.example.itassignpro.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @ElementCollection
    @CollectionTable(name = "EMPLOYEE_SKILLS", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skill")
    private List<String> skills = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectAssignment> projectAssignments = new ArrayList<>();

    public Employee() {
    }
    public Employee(String name, String email, List<String> skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
    public List<ProjectAssignment> getProjectAssignments() { return projectAssignments; }
    public void setProjectAssignments(List<ProjectAssignment> projectAssignments) {
        this.projectAssignments = projectAssignments;
    }
    /**
     * Ajoute une affectation et gère la relation bidirectionnelle.
     * @param assignment L'affectation à ajouter.
     */
    public void addProjectAssignment(ProjectAssignment assignment) {
        projectAssignments.add(assignment);
        assignment.setEmployee(this);
    }
    /**
     * Supprime une affectation et gère la relation bidirectionnelle.
     * @param assignment L'affectation à supprimer.
     */
    public void removeProjectAssignment(ProjectAssignment assignment) {
        projectAssignments.remove(assignment);
        assignment.setEmployee(null);
    }
}
