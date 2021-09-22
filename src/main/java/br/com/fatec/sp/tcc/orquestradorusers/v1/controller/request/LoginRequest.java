package br.com.fatec.sp.tcc.orquestradorusers.v1.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    private String email;
    private String senha;
}
