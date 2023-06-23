package dev.nar.projectrackr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entité")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentEntity {

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
