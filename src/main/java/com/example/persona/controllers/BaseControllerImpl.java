package com.example.persona.controllers;

import com.example.persona.entities.BaseEntity;
import com.example.persona.entities.Persona;
import com.example.persona.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends BaseEntity, S extends BaseServiceImpl<E,Long>> implements BaseController<E,Long>{

    @Autowired
    protected S servicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicio.findAll());
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
                    .body(servicio.findById(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entitySave){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicio.save(entitySave));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entityUpdate){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicio.update(id, entityUpdate));
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
                    .body(servicio.delete(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, no se encontro la persona.\"}");
        }
    }
}
