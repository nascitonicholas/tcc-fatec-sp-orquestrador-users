package br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoUpdateRequest {

    @JsonProperty("tipo_endereco")
    private String tipoEndereco;

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

    @JsonProperty("id_estado")
    private Long idEstado;

    @JsonProperty("cep")
    private String cep;
}
