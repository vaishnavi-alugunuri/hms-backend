package com.hospital.hms.service;

import com.hospital.hms.model.Patient;
import com.hospital.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient != null) {
            patient.setFirstName(patientDetails.getFirstName());
            patient.setLastName(patientDetails.getLastName());
            patient.setDateOfBirth(patientDetails.getDateOfBirth());
            patient.setContactNumber(patientDetails.getContactNumber());
            patient.setEmail(patientDetails.getEmail());
            patient.setInsuranceProvider(patientDetails.getInsuranceProvider());
            patient.setInsuranceNumber(patientDetails.getInsuranceNumber());
            return patientRepository.save(patient);
        }
        return null;
    }
}

