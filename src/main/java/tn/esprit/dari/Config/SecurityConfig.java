package tn.esprit.dari.Config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //this method will do the authentication if you don't to waste time looking for how to do it

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.jdbcAuthentication()
                .dataSource(dataSource)//inject data dource object with autowired (@Autowired private DataSource dataSource ;) it will have access to data source(data base)
                .usersByUsernameQuery("select username as principal , password as credentials , active from users where username=?")//get user by username and password u can change it for email
                .authoritiesByUsernameQuery("select username as principal, role as role from users where username=? ")//select the role in our case u can just fetch the discr col it will do the work
                .rolePrefix("ROLE_")//this is a prefix for role (if the user discr is C then the role will be ROLE_C you can configure it as u like
                .passwordEncoder(bcpe)//this one is for password encryption  the bcpe will be defined as follow (PasswordEncoder bcpe=passwordEncoder() ; ) ;}

                //you can change it if you have something else but this is the most used method
                */



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
        ;




        /*
            //with this code you can handle the requests its simple i will explain every line
        http.formLogin().loginPage("/login").successHandler(authenticationSuccessHandler) ;//saying that it s form login you have to change it because we don't work with dorm login
        http.authorizeRequests().antMatchers("/admin/*").hasAnyRole("ADMIN") ;//the antmachter will match an url and give access to the specified user role anyrole means multiple role
        http.authorizeRequests().antMatchers("/user/*").hasAnyRole("CLIENT","ADMIN") ;// the user url may be accessed by client and admin
        http.authorizeRequests().antMatchers("/client/*").hasRole("CLIENT") ;//this one only client can access to this one
        //http.authorizeRequests().antMatchers("/Reclamation/ajouter").hasRole("CLIENT") ;
        http.exceptionHandling().accessDeniedPage("/403") ;//if the user isn't allowed it will be redirected to the url 403 you can change it to return only a response
        http.logout()  //to configure the logout
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//any url with /logout it will logout the user
        .logoutSuccessUrl("/login")//after logout the user will be redirected to /login
        .invalidateHttpSession(true)//the session will be closed
        .deleteCookies("JSESSIONID");//the cookies too

	*/
    }

}
