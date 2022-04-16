package com.example.gestion_etudiant.Sec.Repositories;

import com.example.gestion_etudiant.Sec.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
      AppUser findByUsername(String username);
}
