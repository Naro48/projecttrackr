package dev.nar.projectrackr.entities;

import dev.nar.projectrackr.FonctionnaireRole;
import dev.nar.projectrackr.ProfilFctn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name="fonctionnaire")
@Data
@AllArgsConstructor
public class FonctionnaireEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;


    @Column(nullable = false, name = "email",unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private ProfilFctn profil;

    @Enumerated(EnumType.STRING)
    private FonctionnaireRole role;

    @Column(length = 14)
    private String mot_de_passe;

    @OneToMany(mappedBy = "respo_projet",cascade = CascadeType.ALL)
    private List<ProjetEntity> projects;

    @OneToMany(mappedBy = "respo_tâche",cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
