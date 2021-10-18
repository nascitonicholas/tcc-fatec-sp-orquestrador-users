package br.com.fatec.sp.tcc.orquestradorusers.v1.config.secutiry;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;
    
    public String builderToken(String nrMatricula){

        Date today = new Date();

        return Jwts.builder()
                .setIssuer("Usuário Autenticado")
                .setSubject(nrMatricula)
                .setIssuedAt(getDateInitial())
                .setExpiration(getDateExpiration()).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    private Date getDateInitial() {
        return  new Date();
    }

    private Date getDateExpiration() {

        Date today = new Date();

        return new Date(( today.getTime() + Long.parseLong(expiration)));
    }

    public boolean isTokenValido(String token){
        try{
            Jwts.parser()
                    .setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e ){
            return false;
        }
    }

    public Long getNrMatriculaUsuario(String token){
        Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();

        return Long.parseLong(body.getSubject());
    }
}
