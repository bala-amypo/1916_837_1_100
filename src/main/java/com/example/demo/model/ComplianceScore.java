package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_scores")
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Vendor vendor;

    private double scoreValue;

    private LocalDateTime lastEvaluated;

    private String rating;

    public ComplianceScore() {}

    // ✅ REQUIRED SETTERS (used by service)

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setScoreValue(double scoreValue) {
        this.scoreValue = scoreValue;
    }

    public void setLastEvaluated(LocalDateTime lastEvaluated) {
        this.lastEvaluated = lastEvaluated;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    // Optional getters
    public Vendor getVendor() {
        return vendor;
    }

    public double getScoreValue() {
        return scoreValue;
    }
}
