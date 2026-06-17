package com.gerenciador.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.cursos.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Object>{
    
}
