package br.com.fatec.sp.tcc.orquestradorusers.v1.controller;

import br.com.fatec.sp.tcc.orquestradorusers.v1.config.AbstractController;
import br.com.fatec.sp.tcc.orquestradorusers.v1.config.SaidaDefault;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.LoginRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.facade.UsuariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuariosController implements AbstractController<SaidaDefault> {

    @Autowired
    private UsuariosFacade usuariosFacade;

    @PostMapping("/login")
    public ResponseEntity<?> getByEmail( @RequestBody @Validated LoginRequest loginRequest){

        UsuariosResponse response = usuariosFacade.login(loginRequest);

        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message("Usuários retornados com sucesso").build(), HttpStatus.OK);
    }
}
