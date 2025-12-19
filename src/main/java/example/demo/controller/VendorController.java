package com.example.demo.controller;

import com.example.demo.dto.VendorRequest;
import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(
            VendorService vendorService
    ) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<Vendor> create(@RequestBody VendorRequest req) {
        Vendor vendor = new Vendor(
                req.getVendorName(),
                req.getEmail(),
                req.getPhone(),
                req.getIndustry()
        );
        return ResponseEntity.ok(vendorService.createVendor(vendor));
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> all() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> get(@PathVariable Long id) {
        return ResponseEntity.ok(vendorService.getVendor(id));
    }
}
