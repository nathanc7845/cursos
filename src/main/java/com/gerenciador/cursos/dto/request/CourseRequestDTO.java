package com.gerenciador.cursos.dto.request;

public record CourseRequestDTO(
    String title,
    String description,
    Integer cargaHoraria,
    Long instructorId
) {}
