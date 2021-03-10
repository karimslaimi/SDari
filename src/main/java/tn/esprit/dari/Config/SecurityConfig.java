package tn.esprit.dari.Config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.esprit.dari.oauth.CustomOAuth2Service;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* @Override
     protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable()
                 .authorizeRequests()
                 .anyRequest()
                 .permitAll()
         ;
     }*/
    @Autowired
    private DataSource dataSource;

  /*  @Autowired
    protected void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password,enabled from utilisateur where username=? ")
                .authoritiesByUsernameQuery("select username , role  from utilisateur where username=? ")

        ;
      /*  auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username  , password  , enabled from utilisateur where username=?")

                ;*/

 @Bean
 public UserDetailsService userDetailsService(){
     return new UserDetailsServiceImpl();
 }
 @Bean
 public DaoAuthenticationProvider authenticationProvider(){
     DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
     authenticationProvider.setUserDetailsService(userDetailsService());
     authenticationProvider.setPasswordEncoder(passwordEncoder());
     return authenticationProvider;
 }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /*@Override
        protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable()
                   .authorizeRequests()
                   .antMatchers("/oauth2/**").permitAll()
                   .antMatchers("/UserCrud/**").authenticated()
                   .anyRequest().permitAll()
                   .and().oauth2Login()
                   .loginPage("/login")
                   .userInfoEndpoint().userService(userService)
                   .and()
                   .and().logout().permitAll();


        }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/UserCrud/**").hasRole("ADMIN").anyRequest().authenticated()


                .and()
                .formLogin().permitAll()



                .and().logout().permitAll();

    }
}
