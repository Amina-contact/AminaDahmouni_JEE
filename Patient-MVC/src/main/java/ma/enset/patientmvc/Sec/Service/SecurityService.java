package ma.enset.patientmvc.Sec.Service;

import ma.enset.patientmvc.Sec.Entities.AppRole;
import ma.enset.patientmvc.Sec.Entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username,String password,String rePassword);
    AppRole saveNewRole(String roleName,String description);
    void addRoleToUser(String username,String roleName);
    void removeRoleFromUser(String username,String roleName);
    AppUser loadUserByUserName(String username);
}
