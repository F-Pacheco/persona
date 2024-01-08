package com.example.persona.controllers;

import com.example.persona.entities.Persona;
import com.example.persona.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona,PersonaServiceImpl>{
    @GetMapping("/searchFiltroPaged") //Este metodo es especifico para buscar por filtro
    public ResponseEntity<?> search(@RequestParam(name = "filtro") String filtro, Pageable pageable){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicio.search(filtro, pageable));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error:"+e.getMessage()+"\"}");
        }
    }

}
