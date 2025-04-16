package com.pm.patient_service.mapper;


import com.pm.patient_service.dto.PatientResponeDto;
import com.pm.patient_service.model.Patient;

public class PatientMapper {

    public static PatientResponeDto toDto(Patient patient){


        PatientResponeDto patientDto = new PatientResponeDto();



        patientDto.setId(patient.getId().toString());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;
    }
}
