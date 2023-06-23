package dev.nar.projectrackr.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="coût")
public class CostEntity implements Serializable {

    @EmbeddedId
    private CostKey id;

    @ManyToOne
    @MapsId("tasksId")
    @JoinColumn(name = "id_tâche")
    private TaskEntity task;

    @ManyToOne
    @MapsId("FactorId")
    @JoinColumn(name = "id_facteur")
    private CostFactorsEntity CostFactor;



}
