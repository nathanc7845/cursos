package com.gerenciador.cursos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gerenciador.cursos.dto.request.CourseRequestDTO;
import com.gerenciador.cursos.dto.response.CourseResponseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.entity.Instructor;

@Mapper(componentModel = "spring", uses = {InstructorMapper.class})
public interface CourseMapper {

    @Mapping(target = "instructor", source = "instructor")
    @Mapping(target = "id", ignore = true)
    Course toEntity(CourseRequestDTO dto, Instructor instructor);

    CourseResponseDTO toResponseDTO(Course entity);
}
