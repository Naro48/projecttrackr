package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="coût")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
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
