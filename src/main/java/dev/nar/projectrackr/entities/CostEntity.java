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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tâche")
    private TaskEntity task;

    @Column(name = "ratinqs")
    private List<String> rating;

    private Double poid;





}
