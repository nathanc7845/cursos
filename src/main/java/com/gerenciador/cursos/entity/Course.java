package com.gerenciador.cursos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cursos")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer cargaHoraria;
    
    @ManyToOne
    @JoinColumn(name="instrutor_id" , referencedColumnName="id")
    private Instructor instructor;

}
