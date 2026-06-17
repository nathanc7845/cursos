package com.gerenciador.cursos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.cursos.dto.request.RegistrationRequestDTO;
import com.gerenciador.cursos.dto.response.RegistrationResponseDTO;
import com.gerenciador.cursos.entity.Course;
import com.gerenciador.cursos.entity.Registration;
import com.gerenciador.cursos.mapper.RegistrationMapper;
import com.gerenciador.cursos.repository.CourseRepository;
import com.gerenciador.cursos.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    public RegistrationResponseDTO register(RegistrationRequestDTO matriculaDTO) {
        Course course = null;
        if (matriculaDTO.courseId() != null) {
            course = courseRepository.findById(matriculaDTO.courseId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + matriculaDTO.courseId()));
        }

        Registration matricula = registrationMapper.toEntity(matriculaDTO, course);
        Registration saved = registrationRepository.save(matricula);
        return registrationMapper.toResponseDTO(saved);
    }

    public List<RegistrationResponseDTO> listRegistration() {
        return registrationRepository.findAll().stream()
                .map(registrationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public RegistrationResponseDTO findById(Long id) {
        Registration matricula = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada com o ID: " + id));
        return registrationMapper.toResponseDTO(matricula);
    }

    public RegistrationResponseDTO updateRegistration(Long id, RegistrationRequestDTO registrationUpdated) {
        Registration registrationBefore = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("matricula não encontrado com o ID: " + id));
        
        Course course = null;
        if (registrationUpdated.courseId() != null) {
            course = courseRepository.findById(registrationUpdated.courseId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + registrationUpdated.courseId()));
        }

        registrationBefore.setNomeAluno(registrationUpdated.nomeAluno());
        registrationBefore.setEmailAluno(registrationUpdated.emailAluno());
        registrationBefore.setCourse(course);
        
        Registration saved = registrationRepository.save(registrationBefore);
        return registrationMapper.toResponseDTO(saved);
    }

    public RegistrationResponseDTO updatePartially(Long id, RegistrationRequestDTO dadosParciais) {
        Registration matriculaAtual = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada com o ID: " + id));

        if (dadosParciais.nomeAluno() != null) {
            matriculaAtual.setNomeAluno(dadosParciais.nomeAluno());
        }

        if (dadosParciais.emailAluno() != null) {
            matriculaAtual.setEmailAluno(dadosParciais.emailAluno());
        }

        if (dadosParciais.courseId() != null) {
            Course course = courseRepository.findById(dadosParciais.courseId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + dadosParciais.courseId()));
            matriculaAtual.setCourse(course);
        }
        
        Registration saved = registrationRepository.save(matriculaAtual);
        return registrationMapper.toResponseDTO(saved);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
