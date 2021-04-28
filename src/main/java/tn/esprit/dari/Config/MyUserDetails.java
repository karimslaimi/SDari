package tn.esprit.dari.Config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.esprit.dari.entities.AuthenticationProvider;
import tn.esprit.dari.entities.Role;
import tn.esprit.dari.entities.Utilisateur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

    private Utilisateur utilisateur;

   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
   String[] userRoles= utilisateur.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        //String userRoles= utilisateur.getRole().getName();
    Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
      //  SimpleGrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole().toString());
        return authorities;
    }*/
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       List<Role> roles = utilisateur.getRoles();
       List<SimpleGrantedAuthority> authorities = new ArrayList<>();

       for (Role role : roles) {
           authorities.add(new SimpleGrantedAuthority(role.getName().replaceAll("\\r\\n","")));
       }

       return authorities;
   }



    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }

    @Override
    public String getUsername() {
        return utilisateur.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return utilisateur.isEnabled();
    }
    public String getEmail(){
        return utilisateur.getEmail();
    }
    public String getFullName(){return utilisateur.getFirstName()+" "+utilisateur.getLastName();}
    public AuthenticationProvider getAuthenticationProvider(){return utilisateur.getAuthenticationProvider();}
}
