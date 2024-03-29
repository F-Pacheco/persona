package com.example.persona.services;

import com.example.persona.entities.Persona;
import com.example.persona.repositories.BaseRepository;
import com.example.persona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

@Autowired
PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
            return personas;
        }catch (Exception e){
            throw new Exception();
        }
    }
    @Override //CON PAGINACION
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro,pageable);
            return personas;
        }catch (Exception e){
            throw new Exception();
        }
    }
}
