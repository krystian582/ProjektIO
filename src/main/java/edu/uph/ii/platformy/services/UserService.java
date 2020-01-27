package edu.uph.ii.platformy.services;


import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.models.Wizyta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
// Własne metody
    void save(User user);

    boolean isUniquePesel(String pesel);

    Page<User> getAllUser(Pageable pageable);
    List<User> getAllUser();
    User getUser(Long id);
    Page<User> getAllUser(UserFilter filter, Pageable pageable);

}
