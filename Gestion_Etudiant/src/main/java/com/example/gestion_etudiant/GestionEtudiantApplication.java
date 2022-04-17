package com.example.gestion_etudiant;

import com.example.gestion_etudiant.Entities.Etudiant;
import com.example.gestion_etudiant.Entities.Genre;
import com.example.gestion_etudiant.Repositories.EtudiantRepository;
import com.example.gestion_etudiant.Sec.Service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class GestionEtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEtudiantApplication.class, args);
    }
    //au démarrage créer un objet PasswordEncoder
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args -> {
            etudiantRepository.save(new Etudiant(null,"DAHMOUNI","Amina","aminadahmouni@gmail.com",new Date(), Genre.FEMININ,true));
            etudiantRepository.save(new Etudiant(null,"DAHMOUNI","Safae","safaedahmouni@gmail.com",new Date(), Genre.FEMININ,true));
            etudiantRepository.save(new Etudiant(null,"MOUTAWAKIL","Bader","badermoutawakil@gmail.com",new Date(), Genre.MASCULIN,false));
            etudiantRepository.save(new Etudiant(null,"SLIMANI","Houda","houdaslimani@gmail.com",new Date(), Genre.FEMININ,false));
            etudiantRepository.save(new Etudiant(null,"ALAOUI","Karim","Karimalaoui@gmail.com",new Date(), Genre.MASCULIN,true));
            etudiantRepository.save(new Etudiant(null,"MOUTASSIM","Rayan","rayanmoutassim@gmail.com",new Date(), Genre.MASCULIN,false));
        };
    }
     //@Bean
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
