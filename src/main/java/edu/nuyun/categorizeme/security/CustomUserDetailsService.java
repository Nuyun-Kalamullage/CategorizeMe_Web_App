package edu.nuyun.categorizeme.security;

import edu.nuyun.categorizeme.PostgresDB.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import edu.nuyun.categorizeme.models.Role;
import org.springframework.stereotype.Service;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 21/01/2024
 * @package edu.nuyun.categorizeme.security
 * @project_Name CategorizeMe
 */
@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        edu.nuyun.categorizeme.models.User user = userRepository.findUserByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Provided Username Not Found!"));
        return new User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName())).collect(Collectors.toList());
    }
}
