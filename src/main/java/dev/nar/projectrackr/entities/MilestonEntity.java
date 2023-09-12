package dev.nar.projectrackr.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "milestone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilestonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="date",nullable = false)
    private Date date;

    @Column(name="type")
    private String type;

    @Column(name = "compte_rendu")
    private String compte_rendu;

    @ManyToOne
    @JsonIgnore
    private ProjetEntity projet;



}
