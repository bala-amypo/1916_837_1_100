package com.example.demo.repository;

import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorDocumentRepository
        extends JpaRepository<VendorDocument, Long> {

    // ✅ SAFE: vendor must be an entity field
    List<VendorDocument> findByVendor_Id(Long vendorId);
}
