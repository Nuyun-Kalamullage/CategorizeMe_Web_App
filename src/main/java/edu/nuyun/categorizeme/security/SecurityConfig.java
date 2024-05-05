package edu.nuyun.categorizeme.security;

import edu.nuyun.categorizeme.PostgresDB.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.security
 * @project_Name CategorizeMe
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthProvider userAuthProvider;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(userAuthenticationEntryPoint));
        httpSecurity.addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class);
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.authorizeHttpRequests(requests ->{
            requests.requestMatchers(HttpMethod.POST, "api/v1/auth/login", "api/v1/auth/register").permitAll();//to connect React Front-end without authentication.
            requests.requestMatchers("/api/v1/task/**").permitAll();//to connect React Front-end without authentication for testing purpose we have to turn this off
            requests.anyRequest().authenticated();
        });
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrfCustomizer -> {
            csrfCustomizer.ignoringRequestMatchers("/api/v1/users/**"); //to connect the postman for testing purpose we have to turn this off
            csrfCustomizer.ignoringRequestMatchers("/api/v1/task/**"); //to connect the postman for testing purpose we have to turn this off
            csrfCustomizer.ignoringRequestMatchers("/api/v1/auth/**"); //to connect the postman for testing purpose we have to turn this off
        });
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return  provider;
    }

}
