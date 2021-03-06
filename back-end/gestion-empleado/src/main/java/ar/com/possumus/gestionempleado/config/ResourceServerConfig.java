/**
 * 
 */
package ar.com.possumus.gestionempleado.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author santiago
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/candidate", "/", "/home","/index" ,"/signup","adduser", "/resources/**", "/static/**",
						"/css/**", "/js/**")
				.permitAll()
			      .antMatchers(
			                "/bootstrap/**",                        
			                "/images/**",
			                "/tinymce/**",
			                "/logos/**").permitAll()
				.antMatchers(HttpMethod.POST, "/signup").permitAll()
				.antMatchers(HttpMethod.GET, "/delete/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/lock/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/unlock/{id}").permitAll()
				
				.antMatchers(HttpMethod.GET, "/api/candidate/{id}").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/api/candidate/upload").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/api/candidate").hasRole("ADMIN").antMatchers("/api/candidate/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and()
				.logout().permitAll().and().cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4201"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		config.addAllowedOrigin("*");
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		config.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//               
//    }

}
