package com.gerenciador.cursos.dto.request;

public record RegistrationRequestDTO(
    String nomeAluno,
    String emailAluno,
    Long courseId
) {}
