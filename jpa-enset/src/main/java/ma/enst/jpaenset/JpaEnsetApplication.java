package ma.enst.jpaenset;
import ma.enst.jpaenset.entities.Role;
import ma.enst.jpaenset.entities.User;
import ma.enst.jpaenset.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
@SpringBootApplication
public class JpaEnsetApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
          return  args -> {
              User u1=new User();
              u1.setUsername("user1");
              u1.setPassword("123456");
              userService.addNewUser(u1);

              User u2=new User();
              u2.setUsername("admin");
              u2.setPassword("123456");
              userService.addNewUser(u2);

              Stream.of("STUDENT","USER","ADMIN").forEach(r->{
                  Role role1=new Role();
                  role1.setRoleName(r);
                  userService.addNewRole(role1);
              });
              userService.addRoleToUser("user1","STUDENT");
              userService.addRoleToUser("user1","USER");
              userService.addRoleToUser("admin","USER");
              userService.addRoleToUser("admin","ADMIN");

              try {
                  User user =userService.authentificate("user1","123456");
                  System.out.println("User ID : "+user.getUserId());
                  System.out.println("User name : "+user.getUsername());
                  System.out.println("les Roles de ce utilisateur :");
                  System.out.println("******************************");
                  user.getRoles().forEach(r -> {
                      System.out.println("role==>"+r);
                  });
              }
              catch (Exception exception){
                  exception.printStackTrace();
              }
          };
    }
}
