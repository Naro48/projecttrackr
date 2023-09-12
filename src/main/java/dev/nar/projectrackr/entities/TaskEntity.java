package dev.nar.projectrackr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.nar.projectrackr.TypeCOCOMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

    private String tdev;

    private String person_required;


    @Column(nullable = false)
    private Double num_ligne_code; //KLOC



    private TypeCOCOMO typeCOCOMO ;

    @ManyToOne
    @JsonIgnore
    private ProjetEntity projet;

    @ManyToOne
    @JsonIgnore
    private FonctionnaireEntity respo_tâche;

    @ManyToOne
    @JoinColumn(name = "tâche_parente",nullable = true)
    @JsonIgnore
    private TaskEntity father_task;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CostEntity> costs;

    private List<String> ratings ;














}
