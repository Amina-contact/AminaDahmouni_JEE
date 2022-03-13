package ma.enset.hospital.repositories;

import ma.enset.hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
         Patient findByNom(String name);
}
