package com.gerenciador.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.cursos.dto.request.CourseRequestDTO;
import com.gerenciador.cursos.dto.response.CourseResponseDTO;
import com.gerenciador.cursos.services.CourseService;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> buscarPorId(@PathVariable Long id) {
        CourseResponseDTO course = courseService.findCoursesById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> cunsultaCursos() {
        List<CourseResponseDTO> listCourse = courseService.findCourses();
        return ResponseEntity.ok(listCourse);
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> cadastrarCursos(@RequestBody CourseRequestDTO course) {
        CourseResponseDTO newCourse = courseService.registerCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> editarCurso(@PathVariable Long id, @RequestBody CourseRequestDTO course) {
        CourseResponseDTO courseEdited = courseService.updateCourse(id, course);
        return ResponseEntity.ok(courseEdited);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
