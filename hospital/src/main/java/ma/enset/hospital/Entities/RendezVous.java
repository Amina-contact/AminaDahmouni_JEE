package ma.enset.hospital.Entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id
    private  String id;
    private Date date;
    //Type ennuméré
    @Enumerated(EnumType.STRING)//Stocker le type au format string
    private StatusRND status;
    @ManyToOne
    /*Prendre en consédiration l'attribut patient dans l'ajout
     mais dans la lecture c'est pas l'appel
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Patient patient;
    @ManyToOne
    private  Medecin medecin;
    @OneToOne(mappedBy="rendezVous")
    private  Consultation consultation;
}

