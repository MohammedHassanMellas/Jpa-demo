package net.mellas.jpademo;

import net.mellas.jpademo.entities.Patient;
import net.mellas.jpademo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Kamal", new Date("04/01/1990"), false, 567));
        patientRepository.save(new Patient(null, "Doha", new Date("09/04/1992"), false, 890));
        patientRepository.save(new Patient(null, "karim", new Date("59/04/2007"), true, 890));
        patientRepository.save(new Patient(null, "Sami", new Date("07/05/1998"), true, 890));


        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
            System.out.println("**********************");
        });
        // find By Id   
        System.out.println(patientRepository.findById(Long.valueOf(1)).get());
        // find By Nom
        System.out.println(patientRepository.findPatientByNom("Sami"));
        //
        System.out.println("*******deleted********");
        patientRepository.delete(patients.get(3));
        List<Patient> p = patientRepository.findAll();
        p.forEach(patient ->{
            System.out.println(patient.toString());
        });
        //


    }
}
