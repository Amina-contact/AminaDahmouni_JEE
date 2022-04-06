package ma.enset.patientmvc.Sec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;
//Pour dire que c'est une classe de configuration
@Configuration
//Pour activer la sécurité web
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //injecter le dataSource courant
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        /*String encodedPWD= passwordEncoder().encode("1234");
        System.out.println(encodedPWD);
        auth.inMemoryAuthentication().withUser("user1").password(encodedPWD).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1122")).roles("USER","ADMIN");*/
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal,password as credentials,active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal,role as role from users_roles where username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin().loginPage("/login");
        http.formLogin();
        //ne necessite pas authentififcation
        http.authorizeRequests().antMatchers("/").permitAll();
        //autoriser les ressources statiques
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER");

        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
    }
    //au démarrage créer un objet PasswordEncoder
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
