package ma.enset.patientmvc.Sec.Service;
import ma.enset.patientmvc.Sec.Entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private  SecurityService securityService;

    public UserDetailsServiceImpl(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //=====>Avec la technique impérative classique
        //J'utilise la cauche service pour chercher les users
        AppUser appUser=securityService.loadUserByUserName(username);
   /*     Collection<GrantedAuthority> authorities=new ArrayList<>();
       //Je vais parcourir les roles de cet user retourné
        appUser.getAppRoles().forEach(role ->{
        //Je prend le role stocké dans la BD et je le met dans un objet de type SimpleGrantedAuthority
                    SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
                    authorities.add(authority);
        });*/
        //====>Avec l'API strems
        Collection<GrantedAuthority> authorities1=
                appUser.getAppRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList());

        //La méthode loadUserByUsername doit retourner un objet qui implémente l'interface UserDetailsService
        //Alors spring va utiliser la classe user de spring security
        User user=new User(appUser.getUsername(), appUser.getPassword(), authorities1);
        return user;
    }
}
