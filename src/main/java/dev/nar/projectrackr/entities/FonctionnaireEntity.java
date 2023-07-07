package dev.nar.projectrackr.entities;

import dev.nar.projectrackr.FonctionnaireRole;
import dev.nar.projectrackr.ProfilFctn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
@Entity
@Table(name="fonctionnaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Column(length = 14,name = "mot_de_passe")
    private String password;

    @OneToMany(mappedBy = "respo_projet",cascade = CascadeType.ALL)
    private List<ProjetEntity> projects;

    @OneToMany(mappedBy = "respo_tâche",cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }


    public String getFullName() {
        return null;
    }


    public void setFullName(String s) {

    }


    public Iterator<Group> getGroups() {
        return null;
    }


    public Iterator<Role> getRoles() {
        return null;
    }


    public UserDatabase getUserDatabase() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }


    public void setUsername(String s) {

    }


    public void addGroup(Group group) {

    }


    public void addRole(Role role) {

    }


    public boolean isInGroup(Group group) {
        return false;
    }


    public boolean isInRole(Role role) {
        return false;
    }


    public void removeGroup(Group group) {

    }


    public void removeGroups() {

    }


    public void removeRole(Role role) {

    }


    public void removeRoles() {

    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return true;
    }


    public String getName() {
        return null;
    }
}
