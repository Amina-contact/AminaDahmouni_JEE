package com.example.gestion_etudiant.Sec.Service;

import com.example.gestion_etudiant.Sec.Entities.AppRole;
import com.example.gestion_etudiant.Sec.Entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username,String roleName);
    void removeRoleFromUser(String username,String roleName);
    AppUser loadUserByUserName(String username);
}
