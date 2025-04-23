package com.pm.patient_service.repository;

import com.pm.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsByEmail(String email);
    /// it checks that do we have any email like this and then ignore the patient with this id that we trying to update
    boolean existsByEmailAndIdNot(String email, UUID id);
}
