package br.com.dett.dettperson.config.security;

import br.com.dett.dettperson.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {

    @Value("${person.jwt.expiration}")
    private String expiration;

    @Value("${person.jwt.secret}")
    private String secret;

    public String createToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date toDay = new Date();
        Date dateExpiration = new Date(toDay.getTime()+Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("Api Person Dett")
                .setSubject(user.getId().toString())
                .setIssuedAt(toDay)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    boolean isTokenTrue(String token){
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public UUID getIdUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return UUID.fromString(claims.getSubject());
    }
}
