package br.com.fatec.sp.tcc.orquestradorusers.v1.mapper;

import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request.EnderecoUpdateRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioEnderecoRequestCreate.*;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper {


    EnderecoRequestCreate mapEnderecoUpdateRequestToEnderecoRequestCreate(EnderecoUpdateRequest enderecoUpdateRequest);


}
