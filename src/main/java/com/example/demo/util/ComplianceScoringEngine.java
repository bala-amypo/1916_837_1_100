package com.example.demo.util;

import com.example.demo.model.DocumentType;

import java.util.List;

public class ComplianceScoringEngine {

    // ✅ REQUIRED BY TESTS
    public static double calculateScore(
            List<DocumentType> required,
            List<DocumentType> available
    ) {
        if (required == null || required.isEmpty()) {
            return 0.0;
        }

        int matched = 0;

        for (DocumentType req : required) {
            for (DocumentType av : available) {
                if (req.getId().equals(av.getId())) {
                    matched++;
                    break;
                }
            }
        }

        return ((double) matched / required.size()) * 100;
    }

    // ✅ REQUIRED BY SERVICES
    public static String deriveRating(double score) {
        if (score >= 80) return "EXCELLENT";
        if (score >= 60) return "GOOD";
        if (score >= 40) return "POOR";
        return "NONCOMPLIANT";
    }
}
