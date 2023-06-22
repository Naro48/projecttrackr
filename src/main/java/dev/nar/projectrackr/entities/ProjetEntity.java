package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="projet")
@Data
@AllArgsConstructor
public class ProjetEntity implements Serializable {

    @Id()
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

    @OneToMany(mappedBy ="projet",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;


}
