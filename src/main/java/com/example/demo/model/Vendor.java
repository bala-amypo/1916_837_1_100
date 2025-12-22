package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vendorName;

    private String email;
    private String phone;
    private String industry;

    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "vendor_document_types",
            joinColumns = @JoinColumn(name = "vendor_id"),
            inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();

    public Vendor() {}

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 REQUIRED BY TESTS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Set<DocumentType> getSupportedDocumentTypes() {
        return supportedDocumentTypes;
    }
    public Vendor(String vendorName, String email, String phone, String industry) {
    this.vendorName = vendorName;
    this.email = email;
    this.phone = phone;
    this.industry = industry;
}

}
