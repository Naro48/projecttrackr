package dev.nar.projectrackr.entities;

import dev.nar.projectrackr.FonctionnaireRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "entité")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="intitulé",nullable = false)
    private String intitulé;

    @Column(name = "type",nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "entité_parente")
    private DepartmentEntity depart_father;


}
