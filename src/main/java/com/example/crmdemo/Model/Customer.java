package com.example.crmdemo.Model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Entity
@Table(name="customer")
@Getter
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String emailAddress;
    @Column
    private String phoneNumber;
    @Column
    private Long desiredCourse;
    @Column
    private String country;

    public void setCountry(String country) {
        this.country = Objects.requireNonNullElse(country, "Not defined");
    }

    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNullElse(firstName, "Not defined");
    }

    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNullElse(lastName, "Not defined");
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = Objects.requireNonNullElse(emailAddress, "Not defined");
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Objects.requireNonNullElse(phoneNumber, "Not defined");
    }

    public void setDesiredCourse(Long desiredCourse) {
        Long temp = 1L;
        this.desiredCourse = Objects.requireNonNullElse(desiredCourse, temp);
    }
}