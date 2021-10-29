package br.com.fatec.sp.tcc.orquestradorusers.v1.integracao.orquestradorbd.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioBDEnderecoCreateResponse {

    @JsonProperty("data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<EnderecoId> responseBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnderecoId{

        @JsonProperty("id_endereco")
        private Long id;
    }



}
