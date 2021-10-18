package br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    @JsonProperty("nrMatricula")
    private String nrMatricula;
    @JsonProperty("senha")
    private String senha;
}
