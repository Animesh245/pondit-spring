package com.pondit.b4.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "name")
    private String name;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
