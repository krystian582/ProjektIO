package edu.uph.ii.platformy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile(ProfileNames.INMEMORY)
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        User.UserBuilder userBuilder = User.builder();

        UserDetails user = userBuilder
                .username("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = userBuilder
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails test = userBuilder
                .username("useradmin")
                .password(passwordEncoder.encode("useradmin"))
                .roles("USER", "ADMIN")
                .build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        manager.createUser(admin);
        manager.createUser(test);

        return manager;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/statics/**", "/webjars/**", "/", "/x.html", "/registrationForm.html")
                .permitAll()//do powyższych zasobów ma mieć każdy
                .antMatchers( "/userList.html").hasAnyAuthority("ROLE_LEKARZ","ROLE_ZARZAD","ROLE_RECEPCJA")//do tych zasobów ma dostęp tylko ADMIN
                .anyRequest().authenticated();//pozostałe żądania mają być uwierzytelnione

        http
                .formLogin()//pozwól użytkownikom uwierzytelniać się poprzez formularz logowania
                .loginPage("/login")//formularz dostępny jest pod URL
                .permitAll();//pozwól każdemu się zalogować.

        http.logout().permitAll();//pozwól każdemu się wylogować
    }



}

