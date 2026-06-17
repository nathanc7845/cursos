package com.gerenciador.cursos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gerenciador.cursos.dto.request.RegistrationRequestDTO;
import com.gerenciador.cursos.dto.response.RegistrationResponseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.entity.Registration;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface RegistrationMapper {

    @Mapping(target = "course", source = "course")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataMatricula", ignore = true)
    Registration toEntity(RegistrationRequestDTO dto, Course course);

    RegistrationResponseDTO toResponseDTO(Registration entity);
}
