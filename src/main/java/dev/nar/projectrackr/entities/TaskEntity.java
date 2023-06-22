package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="tâche")
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String intitulé;

    @Column(nullable = false)
    private Date date_debut;

    @Column(nullable = false)
    private Date date_fin_estime;

    @Column(nullable = false)
    private Date dead_line;

    private String description;

    private String priority;

    private String etat;

    @ManyToOne
    private ProjetEntity projet;










}
