package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class UsuarioBDEstadoResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
}
