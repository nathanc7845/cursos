package com.gerenciador.cursos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.cursos.dto.request.InstructorRequestDTO;
import com.gerenciador.cursos.dto.response.InstructorResponseDTO;
import com.gerenciador.cursos.entity.Instructor;
import com.gerenciador.cursos.mapper.InstructorMapper;
import com.gerenciador.cursos.repository.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorMapper instructorMapper;

    public InstructorResponseDTO registerInstructor(InstructorRequestDTO instructorDTO) {
        Instructor instructor = instructorMapper.toEntity(instructorDTO);
        Instructor saved = instructorRepository.save(instructor);
        return instructorMapper.toResponseDTO(saved);
    }

    public List<InstructorResponseDTO> findInstructor() {
        return instructorRepository.findAll().stream()
                .map(instructorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public InstructorResponseDTO findInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o ID: " + id));
        return instructorMapper.toResponseDTO(instructor);
    }

    public InstructorResponseDTO updateInstrutor(Long id, InstructorRequestDTO dadoAtualizado) {
        Instructor instructorExistente = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o ID: " + id));
        instructorExistente.setName(dadoAtualizado.name());
        instructorExistente.setEmail(dadoAtualizado.email());
        instructorExistente.setEspecialidade(dadoAtualizado.especialidade());

        Instructor saved = instructorRepository.save(instructorExistente);
        return instructorMapper.toResponseDTO(saved);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

}
