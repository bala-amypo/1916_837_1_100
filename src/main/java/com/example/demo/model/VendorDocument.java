package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendor_documents")
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;

    private String fileUrl;

    private LocalDate expiryDate;

    private Boolean isValid;

    private LocalDateTime uploadedAt;

    public VendorDocument() {}

    @PrePersist
    public void prePersist() {
        this.uploadedAt = LocalDateTime.now();
        if (this.expiryDate != null) {
            this.isValid = expiryDate.isAfter(LocalDate.now());
        }
    }

    // ======================
    // REQUIRED GETTERS/SETTERS (TEST & SERVICE SAFE)
    // ======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // 🔑 THIS IS THE FIX
    public Boolean getIsValid() {
        return isValid;
    }

    // Optional but safe
    public boolean isValid() {
        return Boolean.TRUE.equals(isValid);
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
}
