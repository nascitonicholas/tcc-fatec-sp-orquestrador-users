package br.com.fatec.sp.tcc.orquestradorusers.v1.facade;

import br.com.fatec.sp.tcc.orquestradorusers.v1.config.secutiry.TokenService;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioEnderecoRequestCreate;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioEnderecoRequestCreate.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestCreate;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestCreate.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestUpdate;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestUpdate.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuarioBDEnderecoCreateResponse.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.service.UsuariosBdService;
import br.com.fatec.sp.tcc.orquestradorusers.v1.mapper.EnderecoMapper;
import br.com.fatec.sp.tcc.orquestradorusers.v1.mapper.UsuariosMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuariosFacade {

    @Autowired
    private UsuariosBdService usuariosBdService;

    @Autowired
    private TokenService tokenService;

    private final UsuariosMapper usuariosMapper = Mappers.getMapper(UsuariosMapper.class);

    private final EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

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

    public UsuariosResponse getUsuarioByNrMatricula(String nrMatricula) {
        try {
            return usuariosMapper.mapUsuarioBdToUsuarioResponse(usuariosBdService.getUsuarioByNrMatricula(nrMatricula));
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
    }

    public UsuariosResponse cadastrar(CreateRequest request) {

        UsuarioRequestCreate usuarioRequestCreate = new UsuarioRequestCreate();
        List<CreateRequestUsuario> list = new ArrayList<>();

        try {
            list.add(usuariosMapper.mapCreateRequestToCreateRequestUsuario(request));
            usuarioRequestCreate.setRequest(list);
            usuariosBdService.cadastrar(usuarioRequestCreate);

            UsuariosResponse usuariosResponse = login(getLoginRequest(request));

            return usuariosResponse;

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao cadastrar usuário " + e.getMessage());
        }
    }

    private LoginRequest getLoginRequest(CreateRequest request) {

        LoginRequest login = new LoginRequest();
        login.setSenha(request.getSenha());
        login.setNrMatricula(String.valueOf(request.getNrMatricula()));

        return login;
    }

    public String atualizarDadosUsuario(UpdateRequest updateRequest) {

        Long idEndereco = cadastrarEndereco(updateRequest.getEnderecoUpdateRequest());

        UsuarioRequestUpdate usuarioRequestUpdate = new UsuarioRequestUpdate();
        List<UpdateRequestUsuario> list = new ArrayList<>();

        try {

            list.add(usuariosMapper.mapUpdateRequestToUpdateRequestUsuario(updateRequest,idEndereco));
            usuarioRequestUpdate.setUpdateRequest(list);

            return usuariosBdService.atualizar(usuarioRequestUpdate);

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao atualizar dados do usuário" + e.getMessage());
        }

    }

    private Long cadastrarEndereco(EnderecoUpdateRequest enderecoUpdateRequest) {

        try {

            UsuarioEnderecoRequestCreate requestEndereco = new UsuarioEnderecoRequestCreate();
            List<EnderecoRequestCreate> list = new ArrayList<>();
            list.add(enderecoMapper.mapEnderecoUpdateRequestToEnderecoRequestCreate(enderecoUpdateRequest));
            requestEndereco.setListEnderecos(list);

            List<EnderecoId> responseBody = usuariosBdService.cadastrarEndereco(requestEndereco);

            return responseBody.get(0).getId();

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao cadastrar novo endereço" + e.getMessage());
        }

    }

    public String atualizarSenha(PasswordUpdateRequest request) {

        try {
            UsuarioRequestUpdate usuarioRequestUpdate = new UsuarioRequestUpdate();
            List<UpdateRequestUsuario> list = new ArrayList<>();
            list.add(usuariosMapper.mapUsuariosBdToUpdateRequestUsuario(usuariosBdService.getUsuarioByNrMatricula(String.valueOf(request.getNrMatricula())), request));
            usuarioRequestUpdate.setUpdateRequest(list);

            return usuariosBdService.atualizar(usuarioRequestUpdate);

        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao atualizar dados do usuário" + e.getMessage());
        }
    }

    public UsuariosResponse atualizarEmailPessoal(EmailUpdateRequest emailUpdateRequest) {

        try{
            UsuarioRequestUpdate usuarioRequestUpdate = new UsuarioRequestUpdate();
            List<UpdateRequestUsuario> list = new ArrayList<>();
            list.add(usuariosMapper.mapUsuariosBdToUpdateRequestUsuario(usuariosBdService.getUsuarioByNrMatricula(String.valueOf(emailUpdateRequest.getNrMatricula())), emailUpdateRequest));
            usuarioRequestUpdate.setUpdateRequest(list);

            String atualizar = usuariosBdService.atualizar(usuarioRequestUpdate);

            UsuariosResponse usuario = getUsuarioByNrMatricula(String.valueOf(emailUpdateRequest.getNrMatricula()));

            return usuario;



        }catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao atualizar dados do usuário" + e.getMessage());
        }
    }
}
