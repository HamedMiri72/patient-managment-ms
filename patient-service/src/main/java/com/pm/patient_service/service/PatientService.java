package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class PatientService {


   private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



    public List<PatientResponseDto> getPatients() {

        List<Patient> patients = patientRepository.findAll();


//        List<PatientResponseDto> patientResponseDtos = patients
//                .stream()
//                .map(patient -> PatientMapper.toDto(patient)).toList();

        return patients
                .stream()
                .map(PatientMapper::toDto).toList();
    }


    public String createPatient(PatientRequestDto request) {

        var patient = patientRepository.save(PatientMapper.toPatientDto(request));
        return patient.getId().toString();
    }
}
