package br.com.zup.ot6.izabel.transacao.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests ->
        authorizeRequests
        			.antMatchers(GET, "/actuator/health/**").hasAuthority("SCOPE_actuator")
        			.antMatchers(GET, "/actuator/prometheus/**").permitAll()
        			.antMatchers(GET, "/transacoes/**").hasAuthority("SCOPE_transacao")
        			.anyRequest().authenticated()
				  )
		  .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
	
}
