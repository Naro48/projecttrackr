package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tâche")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Date date_debut;

    @Column(nullable = false)
    private Date date_fin_estime;

    @Column(nullable = false)
    private Date dead_line;

    private String description;

    private String priority;

    private String etat;

    private String effort;

    private String num_ligne_code;

    @ManyToOne
    private ProjetEntity projet;

    @ManyToOne
    private FonctionnaireEntity respo_tâche;

    @ManyToOne
    @JoinColumn(name = "tâche_parente",nullable = true)
    private TaskEntity father_task;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    private List<CostEntity> costs;














}
