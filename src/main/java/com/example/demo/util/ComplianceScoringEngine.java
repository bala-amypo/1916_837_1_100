package com.example.demo.util;

public class ComplianceScoringEngine {

    public static String deriveRating(double score) {
        if (score >= 80) return "EXCELLENT";
        if (score >= 60) return "GOOD";
        if (score >= 40) return "POOR";
        return "NONCOMPLIANT";
    }
}
