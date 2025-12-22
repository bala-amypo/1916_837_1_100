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
    private LocalDateTime uploadedAt;
    private Boolean isValid;

    public VendorDocument() {}

    @PrePersist
    public void prePersist() {
        this.uploadedAt = LocalDateTime.now();
    }

    // 🔹 REQUIRED BY TESTS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
    public String getFileUrl() { return fileUrl; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public void setIsValid(Boolean isValid) { this.isValid = isValid; }

    public DocumentType getDocumentType() { return documentType; }
    public void setDocumentType(DocumentType documentType) { this.documentType = documentType; }

    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public Vendor getVendor() {
    return vendor;
}

public LocalDateTime getUploadedAt() {
    return uploadedAt;
}

}
