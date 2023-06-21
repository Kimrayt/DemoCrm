package com.example.crmdemo.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="course")
@Getter
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int duration;
    @Column
    private int price;
    @Column
    private String description;
}