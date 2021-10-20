package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.service;

import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.client.UsuariosBdClient;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequestCreate;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosBdService {

    @Autowired
    private UsuariosBdClient usuariosBdClient;

    public UsuariosBd login(UsuarioRequest request){
        return usuariosBdClient.login(request).getResponseBody();
    }

    public UsuariosBd getUsuarioByNrMatricula(String nrMatricula){
        return usuariosBdClient.getUsuarioByMatricula(nrMatricula).getResponseBody();
    }
    
    public int cadastrar(UsuarioRequestCreate requestCreate){
        return usuariosBdClient.cadastrar(requestCreate).hashCode();
    }

}
