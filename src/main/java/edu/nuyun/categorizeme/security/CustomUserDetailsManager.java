//package edu.nuyun.categorizeme.security;
//
//import edu.nuyun.categorizeme.PostgresDB.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// * @author Nuyun-Kalamullage
// * @IDE IntelliJ IDEA
// * @date 21/01/2024
// * @package edu.nuyun.categorizeme.security
// * @project_Name CategorizeMe
// */
//public class CustomUserDetailsManager extends CustomUserDetailsService
////        implements UserDetailsManager
//{
//
//    public CustomUserDetailsManager(UserRepository userRepository) {
//        super(userRepository);
//    }
//
//    @Override
//    public void createUser(UserDetails user) {
//    }
//
//    @Override
//    public void updateUser(UserDetails user) {
//
//    }
//
//    @Override
//    public void deleteUser(String username) {
//
//    }
//
//    @Override
//    public void changePassword(String oldPassword, String newPassword) {
//
//    }
//
//    @Override
//    public boolean userExists(String username) {
//        return super.userExists(username) ;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return super.loadUserByUsername(username);
//    }
//}
