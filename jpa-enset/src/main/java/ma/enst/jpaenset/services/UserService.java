package ma.enst.jpaenset.services;
import ma.enst.jpaenset.entities.Role;
import ma.enst.jpaenset.entities.User;
public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String rolename);
    User authentificate(String userName,String password);
}

