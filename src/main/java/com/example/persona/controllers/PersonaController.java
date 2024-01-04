package com.example.persona.controllers;

import com.example.persona.entities.Persona;
import com.example.persona.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaService.findAll());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaService.findById(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona personaSave){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaService.save(personaSave));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona personaUpdate){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaService.update(id, personaUpdate));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(personaService.delete(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }
}
