package com.gerenciador.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.cursos.dto.request.RegistrationRequestDTO;
import com.gerenciador.cursos.dto.response.RegistrationResponseDTO;
import com.gerenciador.cursos.services.RegistrationService;

@RestController
@RequestMapping("/matriculas")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<RegistrationResponseDTO>> consultRegistration() {
        return ResponseEntity.ok(registrationService.listRegistration());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> consultRegistrationById(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationResponseDTO> registerRegistration(@RequestBody RegistrationRequestDTO matricula) {
        return ResponseEntity.ok(registrationService.register(matricula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> editRegistration(@PathVariable Long id, @RequestBody RegistrationRequestDTO matricula) {
        return ResponseEntity.ok(registrationService.updateRegistration(id, matricula));
    }

   @PatchMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> editRegistrationPartially(@PathVariable Long id, @RequestBody RegistrationRequestDTO dadosParciais) {
        return ResponseEntity.ok(registrationService.updatePartially(id, dadosParciais));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
