package com.cevenant.backend.data.user;

import javax.persistence.*;

@Entity
@Table( name = "USER" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "USER_ID" )
    private long Id;
    @Column( name = "FIRST_NAME" )
    private String firstName;
    @Column( name = "LAST_NAME" )
    private String lastName;
    @Column( name = "EMAIL" )
    private String email;
    @Column( name = "PASSWORD" )
    private String password;

    public User() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
