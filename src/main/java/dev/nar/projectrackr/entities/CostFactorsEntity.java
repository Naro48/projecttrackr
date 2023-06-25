package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="facteur_coût")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostFactorsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "intitulé", nullable = false)
    private String title;

    @Column(nullable = false)
    private float poids;

    @OneToMany(mappedBy = "CostFactor",cascade = CascadeType.ALL)
    private List<CostEntity> costs;







}

