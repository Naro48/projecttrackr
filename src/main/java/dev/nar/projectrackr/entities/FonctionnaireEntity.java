package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="fonctionnaire")
@Data
@AllArgsConstructor
public class FonctionnaireEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;


    @Column(nullable = false, name = "email",unique = true)
    private String email;

    @Column(nullable = false)
    private String profil;

    @Column(length = 14)
    private String mot_de_passe;

    @OneToMany(mappedBy = "respo_projet",cascade = CascadeType.ALL)
    private List<ProjetEntity> projects;

    @OneToMany(mappedBy = "respo_tâche",cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;


}
