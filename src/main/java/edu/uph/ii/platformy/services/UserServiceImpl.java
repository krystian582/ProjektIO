package edu.uph.ii.platformy.services;


import edu.uph.ii.platformy.config.ProfileNames;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.Role;
import edu.uph.ii.platformy.repositories.RoleRepository;
import edu.uph.ii.platformy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;



@Service("userDetailsService")
@Profile(ProfileNames.DATABASE)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    //bez adnotacji @Transactional sesja jest zamykana po wywołaniu findByUsername, co uniemożliwia dociągnięcie ról, mimo fetch=EAGER.
    //ponadto, musi być włączone zarządzanie transakcjami @EnableTransactionManagement
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        edu.uph.ii.platformy.models.User user = userRepository.findByPesel(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return createUserDetails(user);
    }

    private UserDetails createUserDetails(edu.uph.ii.platformy.models.User user) {
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getType().toString()));
//        }

        Set<GrantedAuthority> grantedAuthorities =
                user.getRoles().stream().map(//mapowanie Role na GrantedAuthority
                        r -> new SimpleGrantedAuthority(r.getType().toString())
                ).collect(Collectors.toSet());

        return new User(user.getPesel(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities);
    }

    @Override
    public void save(edu.uph.ii.platformy.models.User user) {

        Role userRole = roleRepository.findRoleByType(Role.Types.ROLE_USER);
        List roles = Arrays.asList(userRole);
        user.setRoles(new HashSet<>(roles));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAdres(user.getAdres());
        user.setImie(user.getImie());
        user.setNazwisko(user.getNazwisko());
        user.setPesel(user.getPesel());
        user.setEmail(user.getEmail());
        user.setPasswordConfirm(null);//wyzerowanie jest potrzebne ze względu na walidację adnotacjami hibernate
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean isUniquePesel(String pesel) {
        return userRepository.findByPesel(pesel) == null;
    }

    @Override
    public Page<edu.uph.ii.platformy.models.User> getAllUser(Pageable pageable) {
        Page page;
        page = userRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<edu.uph.ii.platformy.models.User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public edu.uph.ii.platformy.models.User getUser(Long id) {
        Optional<edu.uph.ii.platformy.models.User> optionalUser = userRepository.findById(id);
        edu.uph.ii.platformy.models.User user = optionalUser.orElseThrow(()->new NotFoundException(id));
        //towary.getAccessories().size();//dociągnięcie leniwych akcesoriów potrzebnych w widoku. Wymagana adnotacja @Transaction nad metodą lub klasą, aby findById nie zamknęło sesji
        return user;
    }

    @Override
    public Page<edu.uph.ii.platformy.models.User> getAllUser(UserFilter filter, Pageable pageable) {
        Page page;
        if(filter.isEmpty()){
            page = userRepository.findAll(pageable);
        }else{
            page = userRepository.findAllUserUsingFilter(filter.getPhraseLIKE(), pageable);
        }
        return page;
    }

}