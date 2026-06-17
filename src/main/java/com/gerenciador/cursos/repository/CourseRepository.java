package com.gerenciador.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.cursos.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
