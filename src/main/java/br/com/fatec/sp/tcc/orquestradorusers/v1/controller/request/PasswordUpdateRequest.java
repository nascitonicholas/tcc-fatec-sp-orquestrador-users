package br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordUpdateRequest {

    @JsonProperty("nrMatricula")
    private Long nrMatricula;

    @JsonProperty("senha_atual")
    private String senhaAtual;

    @JsonProperty("nova_senha")
    private String novaSenha;

}
