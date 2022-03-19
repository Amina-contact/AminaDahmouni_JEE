package ma.enst.jpaenset.services;
import lombok.AllArgsConstructor;
import ma.enst.jpaenset.entities.Role;
import ma.enst.jpaenset.entities.User;
import ma.enst.jpaenset.repositories.RoleRepository;
import ma.enst.jpaenset.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
   /*public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }*/
    /*Si on veut faire l'injection des dépendances via la constructeur
      il faut faire un seule constructeur avec paramètre
     */
    @Override
    public User addNewUser(User user) {
        /**
         *Avec UUID à chaque fois qu'on génére un Id il est unique et
          qui depende de la date système
         */
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
    @Override
    public void addRoleToUser(String username, String rolename) {
        User user=findUserByUserName(username);
        Role role=findRoleByRoleName(rolename);
        if (user.getRoles()!=null){
            user.getRoles().add(role);
            /**C'est nessecaire de faire userRepository.save(user)
             * car déja la méthode est transactionelle
             * donc tt les changement sont attribués dans la BD
             */
            //userRepository.save(user)
            role.getUsers().add(user);
        }
    }
    @Override
    public User authentificate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if (user==null) throw new RuntimeException("Bad credentials");
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw  new RuntimeException("Bad credentials");
    }
}
