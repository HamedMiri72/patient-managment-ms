package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.dto.validator.CreatePatientValidationGroup;
import com.pm.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patients")
@Tag(name = "Patient", description = "API for managing patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){

        List<PatientResponseDto> patients = patientService.getAllPatients();
        return ResponseEntity.ok().body(patients);
    }

    // it will run validation on all the fields and additional fields that we make them a group
    @PostMapping("/create")
    @Operation(summary = "Create a new patient")
    public ResponseEntity<PatientResponseDto> createPatient(
            @RequestBody @Validated({Default.class, CreatePatientValidationGroup.class}) PatientRequestDto patientRequestDto
    ){
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);

        return ResponseEntity.ok().body(patientResponseDto);
    }

    //registered date is going to be ignored because we haven't specified the group in the validated tag
    @PutMapping("/update/{id}")
    @Operation(summary = "Update a patient")
    public ResponseEntity<PatientResponseDto> updatePatient(
            @PathVariable UUID id, @Validated({Default.class}) @RequestBody  PatientRequestDto patientRequestDto
    ){
        PatientResponseDto patientResponseDto = patientService.updatePatient(id, patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Update a patient")
    public ResponseEntity<Void> deletePatient(
            @PathVariable UUID id
    ){
        patientService.deletePatient(id);
        return ResponseEntity.accepted().build();
    }
}
