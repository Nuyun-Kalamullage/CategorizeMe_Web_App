package edu.nuyun.categorizeme.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.nuyun.categorizeme.Services.AuthenticationService;
import edu.nuyun.categorizeme.Services.UserService;
import edu.nuyun.categorizeme.models.DTO.UserDTO;
import edu.nuyun.categorizeme.models.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.security
 * @project_Name CategorizeMe
 */
@RequiredArgsConstructor
@Component
public class UserAuthProvider {
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

//    private final UserService userService;
    private final AuthenticationService authenticationService;
    @PostConstruct
    protected void  init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    public String createToken(String email){
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3_600_000);
        return JWT.create()
                .withIssuer(email)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        UserDTO user = authenticationService.findUserByLogin(decodedJWT.getIssuer());
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
