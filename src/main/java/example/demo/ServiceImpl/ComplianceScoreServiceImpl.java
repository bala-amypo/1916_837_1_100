package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.ComplianceRuleRepository;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final ComplianceScoreRepository complianceScoreRepository;
    private final VendorRepository vendorRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceRuleRepository complianceRuleRepository;

    public ComplianceScoreServiceImpl(
            ComplianceScoreRepository complianceScoreRepository,
            VendorRepository vendorRepository,
            VendorDocumentRepository vendorDocumentRepository,
            ComplianceRuleRepository complianceRuleRepository
    ) {
        this.complianceScoreRepository = complianceScoreRepository;
        this.vendorRepository = vendorRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceRuleRepository = complianceRuleRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        List<VendorDocument> docs = vendorDocumentRepository.findByVendorId(vendorId);

        double baseScore = docs.isEmpty() ? 0 : 100;

        if (baseScore < 0) {
            throw new ValidationException("Compliance score cannot be negative");
        }

        ComplianceScore score = complianceScoreRepository
                .findByVendorId(vendorId)
                .orElse(new ComplianceScore());

        score.setVendor(vendor);
        score.setScoreValue(baseScore);
        score.setLastEvaluated(LocalDateTime.now());
        score.setRating(baseScore == 100 ? "EXCELLENT" : "NON_COMPLIANT");

        return complianceScoreRepository.save(score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    @Override
    public List<ComplianceScore> getAllScores() {
        return complianceScoreRepository.findAll();
    }
}
