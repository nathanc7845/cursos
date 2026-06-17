package com.gerenciador.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.cursos.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
    
}
