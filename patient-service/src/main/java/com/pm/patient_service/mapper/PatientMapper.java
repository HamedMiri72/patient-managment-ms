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

    public static Patient toPatient(PatientRequestDto patientRequestDto){

        Patient newPatient = new Patient();

        newPatient.setName(patientRequestDto.getName());
        newPatient.setEmail(patientRequestDto.getEmail());
        newPatient.setAddress(patientRequestDto.getAddress());
        newPatient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        newPatient.setRegisteredDate(LocalDate.now());

        return newPatient;
    }
}
