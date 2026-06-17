package com.gerenciador.cursos.dto.response;

public record CourseResponseDTO(
    Long id,
    String title,
    String description,
    Integer cargaHoraria,
    InstructorResponseDTO instructor
) {}
