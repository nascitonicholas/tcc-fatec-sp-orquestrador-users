package br.com.fatec.sp.tcc.orquestradorusers.v1.facade;

import br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response.UsuariosResponse;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.service.UsuariosBdService;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse.UsuariosBd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuariosFacade {

    @Autowired
    private UsuariosBdService usuariosBdService;

    public List<UsuariosResponse> getByEmail(String email){
        List<UsuariosBd> listaUsuarios = usuariosBdService.getListUsuarios(email);

        return null;
    }

}
