package net.mellas.jpademo.repository;

import net.mellas.jpademo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
     List<Patient> findPatientByNom(String nom);

}
