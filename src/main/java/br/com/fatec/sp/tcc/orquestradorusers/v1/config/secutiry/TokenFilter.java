package br.com.fatec.sp.tcc.orquestradorusers.v1.config.secutiry;

import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.facade.UsuariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuariosFacade usuariosFacade;

    public TokenFilter(TokenService tokenService, UsuariosFacade usuariosFacade) {
        this.tokenService = tokenService;
        this.usuariosFacade = usuariosFacade;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(request);

        if(tokenService.isTokenValido(token)){
            autenticarClient(token);
        }

        filterChain.doFilter(request, response);
    }

    private void autenticarClient(String token) {

        Long nrMatriculaUsuario = tokenService.getNrMatriculaUsuario(token);

        UsuariosResponse usuario = usuariosFacade.getUsuarioByNrMatricula(nrMatriculaUsuario.toString());

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer")){
            return null;
        }
        return token.substring(7,token.length());
    }
}
