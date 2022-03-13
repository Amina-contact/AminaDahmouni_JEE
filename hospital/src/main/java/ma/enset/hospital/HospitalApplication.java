package ma.enset.hospital;
import ma.enset.hospital.Entities.*;
import ma.enset.hospital.Service.IHospitalService;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;
@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    /* Dans Spring lorsqu'il y'a une méthode qui utilise l'annotation
       @Bean c.a.d cette méthode va etre exécuté au démarage et au meme
       temps cette méthode va retourner un objet et cette objet devient
       un composant spring elle est équivalente à l'annotation @Component.
     */
    @Bean

    //Méthode 1
/*    CommandLineRunner start(PatientRepository patientRepository
    , MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository){
     return  args -> {
         //Une boocle pour créer 3 patients
         Stream.of("Mohamed","Imane","Halima").forEach(name->{
             Patient patient = new Patient();
             patient.setNom(name);
             patient.setDateNaissance(new Date());
             patient.setMalade(false);
             patientRepository.save(patient);
         });
        Stream.of("Bouchra","Hamid","Hounayda").forEach(name->{
             Medecin medecin = new Medecin();
             medecin.setNom(name);
             medecin.setEmail(name+"@gmail.com");
             medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
             medecinRepository.save(medecin);
         });
        Patient patient1=patientRepository.findById(1L).orElse(null);
        Patient patient2=patientRepository.findByNom("Halima");

        Medecin medecin=medecinRepository.findByNom("Bouchra");

         RendezVous rendezVous=new RendezVous();
         rendezVous.setDate(new Date());
         rendezVous.setStatus(StatusRND.PENDING);
         rendezVous.setMedecin(medecin);
         rendezVous.setPatient(patient1);
         rendezVousRepository.save(rendezVous);

         RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);

         Consultation consultation=new Consultation();
         consultation.setDateConsultation(new Date());
         consultation.setRendezVous(rendezVous1);
         consultation.setRapport("Rapport de la consultation ...");
         consultationRepository.save(consultation);
     };
    }*/
    //Méthode 2 avec service de cauche métier
    //La cauche présentation utilise la cauche métier
    //La cauche métier utilise la cauche dao
    CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository
            , MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository){
        return  args -> {
            //Une boocle pour créer 3 patients
            Stream.of("Mohamed","Imane","Halima").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });
            Stream.of("Bouchra","Hamid","Hounayda").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient1=patientRepository.findById(1L).orElse(null);
            Patient patient2=patientRepository.findByNom("Halima");

            Medecin medecin=medecinRepository.findByNom("Bouchra");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRND.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient1);
            hospitalService.saveRDV(rendezVous);
            //récuperer tt les RDV et prendre le première findAll().get(0)
            //Dans le domaine du Big Data il y'a pas d'auto-increment
            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ...");
            hospitalService.saveConsultation(consultation);
        };
    }

}
