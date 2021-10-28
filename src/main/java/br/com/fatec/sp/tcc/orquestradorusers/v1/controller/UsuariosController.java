package br.com.fatec.sp.tcc.orquestradorusers.v1.controller;

import br.com.fatec.sp.tcc.orquestradorusers.v1.config.AbstractController;
import br.com.fatec.sp.tcc.orquestradorusers.v1.config.SaidaDefault;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.facade.UsuariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{nrMatricula}")
    public ResponseEntity<?> getUsuarioByNrMatricula(@PathVariable String nrMatricula){

        UsuariosResponse usuario = usuariosFacade.getUsuarioByNrMatricula(nrMatricula);

        return saidaSimplificada(SaidaDefault.builder().responseBody(usuario).message("Usuário encontrado com sucesso").build(), HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Validated CreateRequest request){

        UsuariosResponse usuario = usuariosFacade.cadastrar(request);

        return saidaSimplificada(SaidaDefault.builder().responseBody(usuario).message("Usuário já cadastrado no sistema").build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarpassword")
    public ResponseEntity<?> atualizar(@RequestBody @Validated PasswordUpdateRequest request){

        String message = usuariosFacade.atualizarSenha(request);

        return saidaSimplificada(SaidaDefault.builder().message(message).build(), HttpStatus.OK);

    }

    @PutMapping("/atualizarDadosUsuario")
    public ResponseEntity<?> atualizarDadosUsuario(@RequestBody @Validated UpdateRequest updateRequest){

        String message = usuariosFacade.atualizarDadosUsuario(updateRequest);

        return saidaSimplificada(SaidaDefault.builder().message(message).build(), HttpStatus.OK);
    }

    @PutMapping("/atualizarEmailPessoal")
    public ResponseEntity<?> atualizarEmailPessoal(@RequestBody @Validated EmailUpdateRequest emailUpdateRequest){

        UsuariosResponse usuariosResponse = usuariosFacade.atualizarEmailPessoal(emailUpdateRequest);

        return saidaSimplificada(SaidaDefault.builder().responseBody(usuariosResponse).message("Email Atualizado com Sucesso").build(), HttpStatus.OK);
    }
}
