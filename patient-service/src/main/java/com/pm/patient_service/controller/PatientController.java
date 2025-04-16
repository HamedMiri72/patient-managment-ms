package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientResponeDto;
import com.pm.patient_service.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponeDto>> getAllPatients(){

        List<PatientResponeDto> patients = service.getPatients();

        return ResponseEntity.ok().body(patients);
    }
}
