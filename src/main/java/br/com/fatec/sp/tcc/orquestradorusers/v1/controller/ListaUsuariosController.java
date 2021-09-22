package br.com.fatec.sp.tcc.orquestradorusers.v1.controller;

import br.com.fatec.sp.tcc.orquestradorusers.v1.config.AbstractController;
import br.com.fatec.sp.tcc.orquestradorusers.v1.config.SaidaDefault;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.LoginRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.facade.UsuariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autentication")
public class ListaUsuariosController implements AbstractController<SaidaDefault> {

    @Autowired
    private UsuariosFacade usuariosFacade;

    @PostMapping()
    public ResponseEntity<?> getByEmail( @RequestBody LoginRequest loginRequest){
        List<UsuariosResponse> response = usuariosFacade.getByEmail(loginRequest.getEmail());

        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message("Usuários retornados com sucesso").build(), HttpStatus.OK);
    }
}
