package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class UsuariosEnderecoBdResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("municipio")
    private String municipio;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("data_criacao")
    private String dataCriacao;
    @JsonProperty("data_ultima_alteracao")
    private String dataUltimaAlteracao;

}
