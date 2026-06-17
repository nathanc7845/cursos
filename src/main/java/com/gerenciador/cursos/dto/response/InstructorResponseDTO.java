package com.gerenciador.cursos.dto.response;

public record InstructorResponseDTO(
    Long id,
    String name,
    String email,
    String especialidade
) {}
