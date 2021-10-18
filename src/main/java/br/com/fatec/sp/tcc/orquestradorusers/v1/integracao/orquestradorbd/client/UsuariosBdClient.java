package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.client;

import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request.UsuarioRequest;
import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuariosBdClient", url = "${usuarios.bd.url}")

public interface UsuariosBdClient {

    @RequestMapping(method = RequestMethod.POST, value = "/usuarios/login", consumes = "application/json")
    UsuariosBdResponse login(@RequestBody UsuarioRequest request);

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/{nrMatricula}", consumes = "application/json")
    UsuariosBdResponse getUsuarioByMatricula(@PathVariable String nrMatricula);
}
