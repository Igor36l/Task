package com.naumen.task.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "birth_day", nullable = false)
    private LocalDateTime birthDay;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;


    public User() {}

    public User(String login, String password, String fullName, UserRole role, String email, Department department,
                LocalDateTime birthDay, boolean active, LocalDateTime updateDate) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.department = department;
        this.birthDay = birthDay;
        this.active = active;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getUpdate_date() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
