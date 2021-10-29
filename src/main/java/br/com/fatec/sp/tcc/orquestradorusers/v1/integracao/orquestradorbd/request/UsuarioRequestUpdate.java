package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestUpdate {

    @JsonProperty("lista_usuarios")
    public List<UpdateRequestUsuario> updateRequest;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequestUsuario{

        @JsonProperty("nrMatricula")
        private Long nrMatricula;

        @JsonProperty("nome")
        private String nome;

        @JsonProperty("email")
        private String email;

        @JsonProperty("email_pessoal")
        private String emailPessoal;

        @JsonProperty("senha_atual")
        private String senhaAtual;

        @JsonProperty("nova_senha")
        private String novaSenha;

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

        @JsonProperty("id_endereco")
        private Long idEndereco;

        @JsonProperty("id_curso")
        private Long Idcurso;

        @JsonProperty("id_turno")
        private Long Idturno;

    }
}
