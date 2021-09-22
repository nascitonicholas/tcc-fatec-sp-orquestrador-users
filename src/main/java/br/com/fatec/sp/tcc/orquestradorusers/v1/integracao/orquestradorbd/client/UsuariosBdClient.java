package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.client;

import br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response.UsuariosBdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuariosBdClient", url = "${usuarios.bd.url}")
public interface UsuariosBdClient {

    @GetMapping(value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
    UsuariosBdResponse getUsuarios(@RequestParam("email") String email);
}
