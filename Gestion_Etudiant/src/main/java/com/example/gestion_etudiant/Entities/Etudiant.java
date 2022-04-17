package com.example.gestion_etudiant.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3,max = 50)
    private String nom;
    @Size(min = 3,max = 50)
    private String prenom;
    @Email @NotEmpty
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    //Pour stocker les valeurs en format String
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean regle;
}
