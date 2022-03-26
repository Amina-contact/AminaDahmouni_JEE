package ma.enset.patientmvc;
import ma.enset.patientmvc.Entities.Patient;
import ma.enset.patientmvc.Repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            /*patientRepository.save(new Patient(null,"Amina",new Date(),false,12));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),false,15));
            patientRepository.save(new Patient(null,"Hanane",new Date(),true,19));
            patientRepository.save(new Patient(null,"Karima",new Date(),false,10));
            patientRepository.save(new Patient(null,"Mounir",new Date(),true,16));*/

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}
