package com.gerenciador.cursos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gerenciador.cursos.dto.request.InstructorRequestDTO;
import com.gerenciador.cursos.dto.response.InstructorResponseDTO;
import com.gerenciador.cursos.entity.Instructor;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    @Mapping(target = "id", ignore = true)
    Instructor toEntity(InstructorRequestDTO dto);
    
    InstructorResponseDTO toResponseDTO(Instructor entity);
}
