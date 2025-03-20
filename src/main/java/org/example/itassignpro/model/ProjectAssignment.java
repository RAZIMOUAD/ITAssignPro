package org.example.itassignpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PROJECT_ASSIGNMENTS")
public class ProjectAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "involvement_percentage", nullable = false)
    private Double involvementPercentage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public ProjectAssignment() {
    }
    public ProjectAssignment(Double involvementPercentage, Employee employee, Project project) {
        this.involvementPercentage = involvementPercentage;
        this.employee = employee;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public Double getInvolvementPercentage() {
        return involvementPercentage;
    }

    public void setInvolvementPercentage(Double involvementPercentage) {
        this.involvementPercentage = involvementPercentage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
