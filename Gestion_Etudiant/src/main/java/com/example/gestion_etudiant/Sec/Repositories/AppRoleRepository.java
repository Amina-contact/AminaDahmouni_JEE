package com.example.gestion_etudiant.Sec.Repositories;
import com.example.gestion_etudiant.Sec.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
       AppRole findByRoleName(String roleName);
}
