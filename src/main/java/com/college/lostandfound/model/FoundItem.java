package com.college.lostandfound.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "found_items")
public class FoundItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "location")
    private String location;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "date_found")
    private LocalDate dateFound;

    // Getters and setters (or lombok annotations) for all fields

    // Constructors, if needed
}
