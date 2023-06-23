package dev.nar.projectrackr.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class CostKey implements Serializable {


    @Column(name = "id_tâche")
    private int tasksId;

    @Column(name = "id_facteur")
    private int FactorId;





}


