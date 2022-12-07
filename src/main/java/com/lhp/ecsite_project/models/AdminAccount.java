package com.lhp.ecsite_project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class AdminAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Long id;
    @Column(name = "admin_name")

    private String username;

    private String password;

    public AdminAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
