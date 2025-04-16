package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientResponeDto;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    private PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List<PatientResponeDto> getPatients(){
        List<Patient> patients = repository.findAll();

//        List<PatientResponeDto> patientResponeDtos = patients
//                .stream()
//                .map(PatientMapper::toDto).toList(); //patient -> PatientMapper.toDto(patient)
        return patients
                .stream()
                .map(PatientMapper::toDto).toList();

    }
}
