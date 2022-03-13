package ma.enset.hospital.Web;
import ma.enset.hospital.Entities.Patient;
import ma.enset.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    //Méthode pour consulter la liste des patients
    @GetMapping ("/patients")
        public List<Patient> patientList(){
        return patientRepository.findAll();
        }
        /* à cause de la relation bidiréctionnelle
          on obtient un affichage infini des données
         */
}
