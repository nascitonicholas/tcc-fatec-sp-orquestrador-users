package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.service;

import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.client.UsuariosBdClient;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse.UsuariosBd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosBdService {

    @Autowired
    private UsuariosBdClient usuariosBdClient;

    public List<UsuariosBd> getListUsuarios(String email){
        return usuariosBdClient.getUsuarios(email).getResponseBody();
    }
}
