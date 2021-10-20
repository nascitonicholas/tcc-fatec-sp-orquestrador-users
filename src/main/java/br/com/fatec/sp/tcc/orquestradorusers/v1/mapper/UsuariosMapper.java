package br.com.fatec.sp.tcc.orquestradorusers.v1.mapper;

import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.CreateRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.LoginRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestCreate.*;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse.UsuariosBd;
import org.mapstruct.Mapper;

@Mapper
public interface UsuariosMapper {

    UsuarioRequest mapLoginRequestToUsuarioRequest(LoginRequest loginRequest);


    UsuariosResponse mapUsuarioBdToUsuarioResponse(UsuariosBd usuariosBd);

    CreateRequestUsuario mapCreateRequestToCreateRequestUsuario(CreateRequest request);

}
