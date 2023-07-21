package dev.nar.projectrackr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="projet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetEntity implements Serializable {

    @Id()
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

    @OneToMany(mappedBy ="projet",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TaskEntity> tasks;

    @ManyToOne
    @JsonIgnore
    private FonctionnaireEntity respo_projet;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MilestonEntity> milestones;



}
