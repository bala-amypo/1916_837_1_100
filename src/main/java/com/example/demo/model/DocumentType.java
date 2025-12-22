package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "document_types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
    private Boolean required;
    private Integer weight;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private Set<Vendor> vendors = new HashSet<>();

    public DocumentType() {}

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    public String getTypeName() {
    return typeName;
}

    public void setTypeName(String typeName) {
    this.typeName = typeName;
}


    // 🔹 REQUIRED BY TESTS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    public Set<Vendor> getVendors() { return vendors; }
    public LocalDateTime getCreatedAt() {
    return createdAt;
}

}
