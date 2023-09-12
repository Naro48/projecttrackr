package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Entity
@Table(name="facteur_coût")
@Data
@AllArgsConstructor
public class CostFactorsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Column(name = "intitulé", nullable = false)
    private String title;


    @Column
    private Double poid;

    public CostFactorsEntity(String title) {
        this.setTitle(title);
    }
}

