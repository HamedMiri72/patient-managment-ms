package com.pm.patient_service.mapper;


import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Date;
// this mapper class accepts domain entity models and return response dtos
public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient){

        PatientResponseDto patientDto = new PatientResponseDto();

        patientDto.setName(patient.getName());
        patientDto.setId(patient.getId().toString());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;

    }

    public static Patient toPatient(@Valid PatientRequestDto patientRequestDto) {

        Patient patient = new Patient();

        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.now());

        return patient;
    }

}
