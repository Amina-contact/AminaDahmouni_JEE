package ma.enset.patientmvc.Sec.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.patientmvc.Sec.Entities.AppRole;
import ma.enset.patientmvc.Sec.Entities.AppUser;
import ma.enset.patientmvc.Sec.Repositories.AppRoleRepository;
import ma.enset.patientmvc.Sec.Repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

//Car c'est un service
@Service
//Permet de donner un attribut qu'est log qui permet de loguer
@Slf4j
//Pour raison de securité @Autowired n'est pas recomandée
@AllArgsConstructor
//Spring qui va gérer les transactions
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if (!password.equals(rePassword)) throw new RuntimeException("Password not match");
        String hashedPWD=passwordEncoder.encode(password);
        AppUser appUser=new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUser=appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        //Pour créer un role il faut vérifier s'il n'existe pas
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        if (appRole!=null) throw new RuntimeException("Role "+roleName+" already exist");
        appRole=new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        AppRole savedAppRole= appRoleRepository.save(appRole);
        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
          AppUser appUser=appUserRepository.findByUsername(username);
          if (appUser==null) throw new RuntimeException("User not found");
          AppRole appRole=appRoleRepository.findByRoleName(roleName);
         if (appRole==null) throw new RuntimeException("Role not found");
          appUser.getAppRoles().add(appRole);
          //c'est pas l'appel de faire save car c'est transactionnel
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(username);
        if (appUser==null) throw new RuntimeException("User not found");
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role not found");
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUserName(String username) {

        return appUserRepository.findByUsername(username);
    }
}
