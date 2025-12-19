package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String typeName;

    private String description;
    private Boolean required;
    private Integer weight;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public DocumentType() {}

    public DocumentType(String typeName, String description, Boolean required, Integer weight) {
        this.typeName = typeName;
        this.description = description;
        this.required = required;
        this.weight = weight;
    }

    // getters/setters
}
