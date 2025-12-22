package com.example.demo.repository;

import com.example.demo.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    // REQUIRED by DocumentTypeServiceImpl
    boolean existsByTypeName(String typeName);

    // REQUIRED by ComplianceScoreServiceImpl
    List<DocumentType> findByRequiredTrue();
}
