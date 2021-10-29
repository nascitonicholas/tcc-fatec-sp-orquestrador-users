package br.com.fatec.sp.tcc.orquestradorusers.v1.mapper;

import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestCreate.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestUpdate.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse.UsuariosBd;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UsuariosMapper {

    UsuarioRequest mapLoginRequestToUsuarioRequest(LoginRequest loginRequest);

    UsuariosResponse mapUsuarioBdToUsuarioResponse(UsuariosBd usuariosBd);

    CreateRequestUsuario mapCreateRequestToCreateRequestUsuario(CreateRequest request);

    UpdateRequestUsuario mapUpdateRequestToUpdateRequestUsuario(PasswordUpdateRequest updateRequest);

    @Mappings({
            @Mapping(source = "passwordUpdateRequest.nrMatricula", target = "nrMatricula"),
            @Mapping(source = "passwordUpdateRequest.senhaAtual", target = "senhaAtual"),
            @Mapping(source = "passwordUpdateRequest.novaSenha", target = "novaSenha")
    })
    UpdateRequestUsuario mapUsuariosBdToUpdateRequestUsuario(UsuariosBd usuariosBd, PasswordUpdateRequest passwordUpdateRequest);

    @Mappings({
            @Mapping(source = "emailUpdateRequest.nrMatricula", target = "nrMatricula"),
            @Mapping(source = "emailUpdateRequest.emailPessoal", target = "emailPessoal")
    })
    UpdateRequestUsuario mapUsuariosBdToUpdateRequestUsuario(UsuariosBd usuariosBd, EmailUpdateRequest emailUpdateRequest);

    @Mappings({
            @Mapping(source = "idEndereco", target = "idEndereco")
    })
    UpdateRequestUsuario mapUpdateRequestToUpdateRequestUsuario(UpdateRequest updateRequest, Long idEndereco);
}
