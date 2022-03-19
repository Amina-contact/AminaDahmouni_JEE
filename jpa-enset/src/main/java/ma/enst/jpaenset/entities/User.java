package ma.enst.jpaenset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME",unique = true,length = 20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    //Charger les roles de chaque user
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    /*Dons il faut inicialiser la liste pour
      éviter un nullPointerException
     */
    private List<Role> roles=new ArrayList<>();
}

