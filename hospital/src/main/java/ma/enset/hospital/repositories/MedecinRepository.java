package ma.enset.hospital.repositories;

import ma.enset.hospital.Entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
 Medecin findByNom(String name);
}
