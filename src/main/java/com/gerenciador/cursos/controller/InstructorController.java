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

import com.gerenciador.cursos.dto.request.InstructorRequestDTO;
import com.gerenciador.cursos.dto.response.InstructorResponseDTO;
import com.gerenciador.cursos.services.InstructorService;

@RestController
@RequestMapping("/instrutor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponseDTO> findInstructorsById(@PathVariable Long id) {
        InstructorResponseDTO instructors = instructorService.findInstructorById(id);
        return ResponseEntity.ok(instructors);
    }

    @GetMapping
    public ResponseEntity<List<InstructorResponseDTO>> findAllInstructors(){
        List<InstructorResponseDTO> instructors = instructorService.findInstructor();
        return ResponseEntity.ok(instructors);
    }

    @PostMapping
    public ResponseEntity<InstructorResponseDTO> registerInstructor(@RequestBody InstructorRequestDTO instructor) {
        InstructorResponseDTO newInstructor = instructorService.registerInstructor(instructor);
        return ResponseEntity.ok(newInstructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorResponseDTO> editInstructor(@PathVariable Long id, @RequestBody InstructorRequestDTO instructor){
        InstructorResponseDTO instructorEdited = instructorService.updateInstrutor(id, instructor);
        return ResponseEntity.ok(instructorEdited);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
