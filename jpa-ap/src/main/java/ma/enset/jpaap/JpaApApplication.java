package ma.enset.jpaap;
import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.Date;
import java.util.List;
@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    /** on a créee l'interface mais on a pas créé l'implementation
     * car spring dispose déja d'une implémentation générique
     * et il l'injecte
     */
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }
    @Override
    //Faire des tests au démarage de l'application
    public void run(String... args) throws Exception {
       /*for (int i = 0;i<100;i++) {
            patientRepository.save(new Patient(null, "Amina", new Date(),
                    Math.random()>0.5?true:false, (int)(Math.random()*1000)));
        }*/
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total des pages: "+patients.getTotalPages());
        System.out.println("Total des élements : "+patients.getTotalElements());
        System.out.println("Numéro Page : "+patients.getNumber());
        List<Patient>  content = patients.getContent();
        //Liste des patients qui sont malades
        Page<Patient>  byMalade = patientRepository.findByMalade(true,PageRequest.of(0,4));
        byMalade.forEach(p -> {
            System.out.println("############################################");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });
        System.out.println("*******************************************");
        //s'il existe il va l'afficher sinon il va afficher un méssage d'erreur
        Patient patient1=patientRepository.findById(1L).orElseThrow(()->new RuntimeException("patient not found"));
        //s'il existe il va l'afficher sinon il va afficher une exception
        Patient patient2=patientRepository.findById(1L).get();
        //s'il existe il va l'afficher sinon il va afficher null
        Patient patient3=patientRepository.findById(1L).orElse(null);
        if (patient3!=null){
            System.out.println(patient3.getNom());
            System.out.println(patient3.isMalade());
        }
        //patient2.setScore(59);
    }
}
