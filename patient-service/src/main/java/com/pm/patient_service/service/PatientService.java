package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.exception.CustomerExceptionNotFoundById;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //service always convert domain entity to response dto that we want to return to customer

    public List<PatientResponseDto> getAllPatients(){

        List<Patient> patients = patientRepository.findAll();

//        List<PatientResponseDto> patientResponseDtos = patients
//                .stream()
//                .map(patient -> PatientMapper.toDto(patient)).toList();

        return patients
                .stream()
                .map(PatientMapper::toDto).toList();


    }



    public PatientResponseDto createPatient(@Valid PatientRequestDto patientRequestDto) {


        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists:: " + patientRequestDto.getEmail());
        }

        Patient newPatient = patientRepository.save(PatientMapper.toPatient(patientRequestDto));

        // an email address must be unique
        return PatientMapper.toDto(newPatient);
    }


    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new CustomerExceptionNotFoundById("Customer not found by Provided ID:: " + id));

        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists:: " + patientRequestDto.getEmail());
        }

        patient.setName(patientRequestDto.getName());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));


        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toDto(updatedPatient);


    }




}
