package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UsuariosBdResponse {


    @JsonProperty("data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private UsuariosBd responseBody;

    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  message;

    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  description;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties
    public static class UsuariosBd{

        @JsonProperty("nrMatricula")
        private String nrMatricula;
        @JsonProperty("nome")
        private String nome;
        @JsonProperty("email")
        private String email;
        @JsonProperty("senha")
        private String senha;
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
        @JsonInclude(value = JsonInclude.Include.NON_NULL)
        @JsonProperty("enderecos")
        private List<UsuariosEnderecoBdResponse> enderecos;
        @JsonProperty("curso")
        private UsuariosBdCursoResponse curso;
        @JsonProperty("turno")
        private UsuariosBdTurnoResponse turno;
        @JsonProperty("data_criacao")
        private String dataCriacao;
        @JsonProperty("data_ultima_alteracao")
        private String dataUltimaAlteracao;




    }
}
