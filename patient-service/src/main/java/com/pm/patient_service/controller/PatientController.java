package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {


    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

  @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){

      List<PatientResponseDto> patients = patientService.getPatients();
      return ResponseEntity.ok().body(patients);
  }

  @PostMapping("/create")
    public ResponseEntity<String> createPatient(
            @RequestBody @Valid PatientRequestDto request
  ){

        return ResponseEntity.ok(patientService.createPatient(request));
  }
}
