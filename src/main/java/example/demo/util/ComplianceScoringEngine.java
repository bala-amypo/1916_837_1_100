package com.example.demo.util;

import com.example.demo.model.ComplianceScore;
import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;

import java.time.LocalDate;
import java.util.List;

public class ComplianceScoringEngine {

    public static double calculateScore(
            List<DocumentType> requiredDocs,
            List<VendorDocument> uploadedDocs
    ) {

        double totalWeight = requiredDocs.stream()
                .mapToDouble(DocumentType::getWeight)
                .sum();

        if (totalWeight == 0) {
            return 100.0;
        }

        double achieved = 0.0;

        for (DocumentType type : requiredDocs) {
            boolean found = uploadedDocs.stream()
                    .anyMatch(doc ->
                            doc.getDocumentType().getId().equals(type.getId())
                                    && (doc.getExpiryDate() == null
                                    || !doc.getExpiryDate().isBefore(LocalDate.now()))
                    );

            if (found) {
                achieved += type.getWeight();
            }
        }

        return (achieved / totalWeight) * 100;
    }


    public static String calculateRating(double score) {
        if (score >= 90) return "EXCELLENT";
        if (score >= 70) return "GOOD";
        if (score >= 40) return "POOR";
        return "NON_COMPLIANT";
    }
}
