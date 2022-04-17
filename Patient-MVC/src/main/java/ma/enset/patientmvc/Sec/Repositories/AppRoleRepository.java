package ma.enset.patientmvc.Sec.Repositories;

import ma.enset.patientmvc.Sec.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
       AppRole findByRoleName(String roleName);
}
