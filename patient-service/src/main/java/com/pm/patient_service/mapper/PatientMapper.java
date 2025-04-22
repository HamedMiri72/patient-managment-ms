package com.pm.patient_service.mapper;


import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;

import java.util.Date;
// this mapper class accepts domain entity models and return response dtos
public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient){

        PatientResponseDto patientDto = new PatientResponseDto();

        patientDto.setName(patient.getName());
        patientDto.setId(patient.getId().toString());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patientDto.getAddress());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;

    }
}
