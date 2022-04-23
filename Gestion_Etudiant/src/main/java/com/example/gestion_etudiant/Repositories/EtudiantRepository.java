package com.example.gestion_etudiant.Repositories;
import com.example.gestion_etudiant.Entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String kw, Pageable pageable);
}
