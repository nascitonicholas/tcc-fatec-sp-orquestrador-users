package br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRequest {

    @JsonProperty("nrMatricula")
    private Long nrMatricula;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("nome_mae")
    private String nomeMae;

    @JsonProperty("nome_pai")
    private String nomePai;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("certificadoMilitar")
    private String certificadoMilitar;

    @JsonProperty("numeroTitulo")
    private String numeroTitulo;

    @JsonProperty("zonaTitulo")
    private String zonaTitulo;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("id_curso")
    private Long Idcurso;

    @JsonProperty("id_turno")
    private Long Idturno;

    @JsonProperty("endereco")
    private EnderecoUpdateRequest enderecoUpdateRequest;


}
