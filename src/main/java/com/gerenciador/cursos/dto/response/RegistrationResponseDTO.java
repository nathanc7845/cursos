package com.gerenciador.cursos.dto.response;

import java.time.LocalDate;

public record RegistrationResponseDTO(
    Long id,
    String nomeAluno,
    String emailAluno,
    LocalDate dataMatricula,
    CourseResponseDTO course
) {}
