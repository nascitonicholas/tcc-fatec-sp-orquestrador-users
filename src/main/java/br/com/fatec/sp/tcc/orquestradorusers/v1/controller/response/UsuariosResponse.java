package br.com.fatec.sp.tcc.orquestradorusers.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuariosResponse {

    @JsonProperty("nrMatricula")
    private String nrMatricula;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("email")
    private String email;
    @JsonProperty("email_pessoal")
    private String emailPessoal;
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
    @JsonProperty("enderecos")
    private List<UsuariosEnderecoResponse> enderecos;
    @JsonProperty("curso")
    private UsuariosCursoResponse curso;
    @JsonProperty("turno")
    private UsuariosTurnoResponse turno;
    @JsonProperty("data_criacao")
    private String dataCriacao;
    @JsonProperty("data_ultima_alteracao")
    private String dataUltimaAlteracao;
    @JsonProperty("tokenAutenticacao")
    private String tokenAutenticao;
}
