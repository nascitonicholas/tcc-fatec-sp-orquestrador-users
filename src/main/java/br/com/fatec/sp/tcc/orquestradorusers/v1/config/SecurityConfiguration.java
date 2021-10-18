package br.com.fatec.sp.tcc.orquestradorusers.v1.config;

import br.com.fatec.sp.tcc.orquestradorusers.v1.config.secutiry.TokenFilter;
import br.com.fatec.sp.tcc.orquestradorusers.v1.config.secutiry.TokenService;
import br.com.fatec.sp.tcc.orquestradorusers.v1.facade.UsuariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuariosFacade usuariosFacade;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/usuario/login").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                .antMatchers(HttpMethod.GET, "/usuario/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new TokenFilter(tokenService,usuariosFacade), UsernamePasswordAuthenticationFilter.class);
//                .antMatchers(HttpMethod.GET, "*").permitAll()
//                .antMatchers(HttpMethod.POST, "*").permitAll()
//                .antMatchers(HttpMethod.PUT, "*").permitAll()
//                .antMatchers(HttpMethod.DELETE, "*")
//                .permitAll()
//                .anyRequest().permitAll()
//                .and().cors().and().csrf().disable()
        ;

    }
}
