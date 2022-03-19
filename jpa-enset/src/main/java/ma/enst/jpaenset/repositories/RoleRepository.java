package ma.enst.jpaenset.repositories;
import ma.enst.jpaenset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository pour indiquer que c'est un componenet de la couche dao
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}

