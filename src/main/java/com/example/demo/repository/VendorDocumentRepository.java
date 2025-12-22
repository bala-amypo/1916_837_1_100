package com.example.demo.repository;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {

    // Used in tests
    List<VendorDocument> findByVendor(Vendor vendor);

    // Used in tests
    @Query("SELECT d FROM VendorDocument d WHERE d.expiryDate < :date")
    List<VendorDocument> findExpiredDocuments(LocalDate date);
}
