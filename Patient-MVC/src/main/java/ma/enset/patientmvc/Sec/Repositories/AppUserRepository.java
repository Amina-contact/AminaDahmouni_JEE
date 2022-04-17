package ma.enset.patientmvc.Sec.Repositories;

import ma.enset.patientmvc.Sec.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
      AppUser findByUsername(String username);
}
