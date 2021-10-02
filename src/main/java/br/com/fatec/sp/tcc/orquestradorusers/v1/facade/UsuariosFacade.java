package br.com.fatec.sp.tcc.orquestradorusers.v1.facade;

import br.com.fatec.sp.tcc.orquestradorusers.v1.config.secutiry.TokenService;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.LoginRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.service.UsuariosBdService;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse.UsuariosBd;
import br.com.fatec.sp.tcc.orquestradorusers.v1.mapper.UsuariosMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Component
public class UsuariosFacade {

    @Autowired
    private UsuariosBdService usuariosBdService;

    @Autowired
    private TokenService tokenService;

    private final UsuariosMapper usuariosMapper = Mappers.getMapper(UsuariosMapper.class);

    public UsuariosResponse login(LoginRequest request) {

        try {

            UsuarioRequest usuarioRequest = usuariosMapper.mapLoginRequestToUsuarioRequest(request);
            UsuariosResponse usuariosResponse = usuariosMapper.mapUsuarioBdToUsuarioResponse(usuariosBdService.login(usuarioRequest));
            String token = tokenService.builderToken(usuariosResponse.getNrMatricula());
            usuariosResponse.setTokenAutenticao(token);

            return usuariosResponse;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula e/ou senha inválidos");
        }
    }

    public UsuariosResponse getUsuarioByNrMatricula(String nrMatricula){
        try{
            return usuariosMapper.mapUsuarioBdToUsuarioResponse(usuariosBdService.getUsuarioByNrMatricula(nrMatricula));
        }catch (Exception e){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
    }

}
