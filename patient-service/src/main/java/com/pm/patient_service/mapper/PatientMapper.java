package com.pm.patient_service.mapper;


import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;

import java.util.Date;

public class PatientMapper {



    public static PatientResponseDto toDto(Patient patient) {


        PatientResponseDto patientDto = new PatientResponseDto();

        patientDto.setId(patient.getId().toString());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patientDto.getAddress());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;
    }

    public static Patient toPatientDto(PatientRequestDto request) {

        Patient patient = new Patient();

        patient.setId(request.getId());
        patient.setAddress(request.getAddress());
        patient.setEmail(request.getEmail());
        patient.setName(request.getName());
        patient.setRegisteredDate(request.getRegisteredDate());
        patient.setDateOfBirth(request.getDateOfBirth());

        return patient;

    }
}
