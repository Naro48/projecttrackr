package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "milestone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilestonEntity {

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
    private ProjetEntity projet;



}
