package ma.enset.patientmvc;
import ma.enset.patientmvc.Entities.Patient;
import ma.enset.patientmvc.Repositories.PatientRepository;
import ma.enset.patientmvc.Sec.Service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    //au démarrage créer un objet PasswordEncoder
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
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
   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
             securityService.saveNewUser("Amina","1234","1234");
             securityService.saveNewUser("Bouchra","1234","1234");
             securityService.saveNewUser("Hamid","1234","1234");

             securityService.saveNewRole("USER","");
             securityService.saveNewRole("ADMIN","");

             securityService.addRoleToUser("Amina","USER");
             securityService.addRoleToUser("Amina","ADMIN");
             securityService.addRoleToUser("Bouchra","USER");
             securityService.addRoleToUser("Hamid","USER");
        };
    }
}
