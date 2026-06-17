package com.gerenciador.cursos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.cursos.dto.request.CourseRequestDTO;
import com.gerenciador.cursos.dto.response.CourseResponseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.entity.Instructor;
import com.gerenciador.cursos.mapper.CourseMapper;
import com.gerenciador.cursos.repository.CourseRepository;
import com.gerenciador.cursos.repository.InstructorRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseMapper courseMapper;

    public CourseResponseDTO registerCourse(CourseRequestDTO courseDTO) {
        Instructor instructor = null;
        if (courseDTO.instructorId() != null) {
            instructor = instructorRepository.findById(courseDTO.instructorId())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o ID: " + courseDTO.instructorId()));
        }

        Course course = courseMapper.toEntity(courseDTO, instructor);
        Course saved = courseRepository.save(course);
        return courseMapper.toResponseDTO(saved);
    }

    public List<CourseResponseDTO> findCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CourseResponseDTO findCoursesById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
        return courseMapper.toResponseDTO(course);
    }

    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseUpdated) {
        Course courseBefore = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
        
        Instructor instructor = null;
        if (courseUpdated.instructorId() != null) {
            instructor = instructorRepository.findById(courseUpdated.instructorId())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o ID: " + courseUpdated.instructorId()));
        }

        courseBefore.setTitle(courseUpdated.title());
        courseBefore.setCargaHoraria(courseUpdated.cargaHoraria());
        courseBefore.setDescription(courseUpdated.description());
        courseBefore.setInstructor(instructor);
        
        Course saved = courseRepository.save(courseBefore);
        return courseMapper.toResponseDTO(saved);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
