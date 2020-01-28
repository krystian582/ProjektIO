package edu.uph.ii.platformy.config;

import edu.uph.ii.platformy.models.*;
import edu.uph.ii.platformy.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Configuration
public class RepositoriesInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private KartaZdrowiaRepository kartaZdrowiaRepository;
    @Autowired
    private ReceptaRepository receptaRepository;
    @Autowired
    private RefundacjaRepository refundacjaRepository;
    @Autowired
    private StatusWizytyRepository statusWizytyRepository;
    @Autowired
    private TerminarzRepository terminarzRepository;
    @Autowired
    private UslugaRepository uslugaRepository;
    @Autowired
    private WizytaRepository wizytaRepository;


    @Bean
    InitializingBean init() {

        return () -> {

            if (roleRepository.findAll().isEmpty() == true) {
                try {
                    Role roleUser = roleRepository.save(new Role(Role.Types.ROLE_USER));
                    Role roleLekarz = roleRepository.save(new Role(Role.Types.ROLE_LEKARZ));
                    Role roleRecepcja = roleRepository.save(new Role(Role.Types.ROLE_RECEPCJA));
                    Role roleZarzad = roleRepository.save(new Role(Role.Types.ROLE_ZARZAD));
                    

                    User lekarz = new User("12345678900","Kamil","Pogorzelski","123456789","M.C.Skłodowskiej","xd@wp.pl",true);
                    lekarz.setRoles(new HashSet<>(Arrays.asList(roleLekarz)));
                    lekarz.setPassword(passwordEncoder.encode("12345"));
                    userRepository.save(lekarz);

                    User recepcja = new User("23456789000","Krystian","Koc","765432122","M.C.Skłodowskiej","xd@wp.pl",true);
                    recepcja.setRoles(new HashSet<>(Arrays.asList(roleRecepcja)));
                    recepcja.setPassword(passwordEncoder.encode("12345"));
                    userRepository.save(recepcja);

                    User zarzad = new User("34567890000","Patryk","Koc","234567822","M.C.Skłodowskiej","xd@wp.pl",true);
                    zarzad.setRoles(new HashSet<>(Arrays.asList(roleZarzad)));
                    zarzad.setPassword(passwordEncoder.encode("12345"));
                    userRepository.save(zarzad);

                    User user = new User("45678900000","Jan","Kowalski","234567822","M.C.Skłodowskiej","xd@wp.pl",true);
                    user.setRoles(new HashSet<>(Arrays.asList(roleUser)));
                    user.setPassword(passwordEncoder.encode("12345"));
                    userRepository.save(user);

                    Refundacja ref1 = new Refundacja("100% Refundowana");
                    refundacjaRepository.save(ref1);
                    Refundacja ref2 = new Refundacja("50% Refundowana");
                    refundacjaRepository.save(ref2);
                    Refundacja ref3 = new Refundacja("30% Refundowana");
                    refundacjaRepository.save(ref3);
                    Refundacja ref4 = new Refundacja("Nie Refundowana");
                    refundacjaRepository.save(ref4);

                    StatusWizyty sta1 = new StatusWizyty("Zarejestrowana");
                    statusWizytyRepository.save(sta1);
                    StatusWizyty sta2 = new StatusWizyty("Potwierdzona");
                    statusWizytyRepository.save(sta2);
                    StatusWizyty sta3 = new StatusWizyty("Zakończona");
                    statusWizytyRepository.save(sta3);

                    Usluga usluga1 = new Usluga("Wyrwanie zęba", (float) 100.00);
                    uslugaRepository.save(usluga1);
                    Usluga usluga2 = new Usluga("Leczenie zęba", (float) 200.00);
                    uslugaRepository.save(usluga2);
                    Usluga usluga3 = new Usluga("Leczenie zęba kanałowo", (float) 500.00);
                    uslugaRepository.save(usluga3);
                    Usluga usluga4 = new Usluga("Borowanie", (float) 100.00);
                    uslugaRepository.save(usluga4);

                    String data = "2019/11/11";
                    Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(data);
                    KartaZdrowia karta1 = new KartaZdrowia(user,date1,"Wyrwano zęba");
                    kartaZdrowiaRepository.save(karta1);
                    KartaZdrowia karta2 = new KartaZdrowia(user,date1,"Leczenie kanałowe");
                    kartaZdrowiaRepository.save(karta2);
                    KartaZdrowia karta3 = new KartaZdrowia(user,date1,"COS123");
                    kartaZdrowiaRepository.save(karta3);

                    Recepta recepta1 = new Recepta(user,date1,"Rutinoscorbin","Rano i Wieczorem po 1 tabletce",ref1);
                    receptaRepository.save(recepta1);
                    Recepta recepta2 = new Recepta(user,date1,"Apap","Rano i Wieczorem po 1 tabletce",ref2);
                    receptaRepository.save(recepta2);
                    Recepta recepta3 = new Recepta(user,date1,"Etopiryna","Rano i Wieczorem po 1 tabletce",ref3);
                    receptaRepository.save(recepta3);
                    Recepta recepta4 = new Recepta(user,date1,"Aviomarin","Rano i Wieczorem po 1 tabletce",ref4);
                    receptaRepository.save(recepta4);

                    Wizyta wizyta1 = new Wizyta(date1,usluga1,user,sta1);
                    wizytaRepository.save(wizyta1);
                    Wizyta wizyta2 = new Wizyta(date1,usluga2,user,sta2);
                    wizytaRepository.save(wizyta2);
                    Wizyta wizyta3 = new Wizyta(date1,usluga3,user,sta3);
                    wizytaRepository.save(wizyta3);
                    Wizyta wizyta4 = new Wizyta(date1,usluga4,user,sta3);
                    wizytaRepository.save(wizyta4);

                    Terminarz terminarz1 = new Terminarz(lekarz,wizyta1);
                    terminarzRepository.save(terminarz1);
                    Terminarz terminarz2 = new Terminarz(lekarz,wizyta2);
                    terminarzRepository.save(terminarz2);
                    Terminarz terminarz3 = new Terminarz(lekarz,wizyta3);
                    terminarzRepository.save(terminarz3);
                    Terminarz terminarz4 = new Terminarz(lekarz,wizyta4);
                    terminarzRepository.save(terminarz4);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
