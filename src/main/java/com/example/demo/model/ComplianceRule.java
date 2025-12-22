package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_rules")
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String ruleDescription;
    private String matchType;
    private Double threshold;

    private LocalDateTime createdAt;

    public ComplianceRule() {
    }

    public ComplianceRule(String ruleName, String ruleDescription, String matchType, Double threshold) {
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public Double getThreshold() {
        return threshold;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
