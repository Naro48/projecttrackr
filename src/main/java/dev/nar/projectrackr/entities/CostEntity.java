package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="coût")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
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

    @Column(name = "ratinqs")
    private List<String> rating;

    private Double poid;





}
