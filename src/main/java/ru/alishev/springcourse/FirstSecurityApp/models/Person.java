package ru.alishev.springcourse.FirstSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity       //there is just class with our new entity,
            // but we need also class-OBERTKA (UserDetails) in package "security"
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "2 - 100 symbols required")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "year more then 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    //need default constructor for
    public Person() {}

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public int getYearOfBirth() {return yearOfBirth;}
    public void setYearOfBirth(int yearOfBirth) {this.yearOfBirth = yearOfBirth;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ",username=" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password=" + password + '\'' +
                '}';
    }
}
