package tn.esprit.dari.Config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import tn.esprit.dari.oauth.CustomOAuth2Service;
import tn.esprit.dari.oauth.OAuth2LoginSucsessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private DataSource dataSource;

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

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }*/
    private OAuth2LoginSucsessHandler oAuth2LoginSucsessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/Auth/signupCustomer","/UserCrud/getAllCustomers","/UserCrud/getAllUsers","/forgotpssd/reset_password","/Auth/signup","/forgotpssd/**","/forgotpssd/reset_password","/UserCrud/customerDelete/**","/Auth/signupAgent","/Customer/**","/Auth/**","/forgot_passwordp","/reset_password/**");
    }

    @Override
        protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable()
                   .authorizeRequests()
                   .antMatchers("/*","/message/*").permitAll();
            /*
                   .antMatchers("/","/login","/oauth/**","/forgot_password").permitAll()
                // .antMatchers("/UserCrud/**").hasAuthority("CUSTOMER")
                   .antMatchers("/UserCrud/**").permitAll()

                   .anyRequest().authenticated()
                   .and()
                   .formLogin()
                         .permitAll()
                   .failureUrl("/UserCrud/loginFailure")
                   .failureForwardUrl("/UserCrud/loginFailure")
                   .successForwardUrl("/UserCrud/getLocalLoggedInUser")

                   .and()
                   .rememberMe()
                   //.tokenValiditySeconds(3 * 24 * 60 * 60 )
                   .tokenRepository(persistentTokenRepository())
                         .and()
                         .oauth2Login()
                     //    .loginPage("/login")
                   //.defaultSuccessUrl("/getLoggedInUser")
                   .userInfoEndpoint().userService(utilisateurOauth)
                   .and()
                   .successHandler(oAuth2LoginSucsessHandler)


                   .and().logout().permitAll()
                   ;*/



        }
     //   @Autowired
       // PersistentTokenRepository persistentTokenRepository;
    @Autowired
    CustomOAuth2Service utilisateurOauth;
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }
 /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/oauth/**").permitAll()
                .antMatchers("/Customer/getLoggedInUser").hasAuthority("USER")
                .anyRequest().authenticated()

                .and()

                .formLogin()
                .loginPage("/login")

                .permitAll()
                .and().logout().permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(3 * 24 * 60 * 60 )
                .tokenRepository(persistentTokenRepository())
                .and()
                .oauth2Login().loginPage("/login")
                .userInfoEndpoint().userService(utilisateurOauth);

    }
*/

/*@Override
   protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().permitAll()
                .loginPage("/login")

    ;

    }*/

}
