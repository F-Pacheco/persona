package com.example.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends BaseEntity{
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private Integer fecha;
    @Column(name = "genero")
    private String genero;
    @Column(name = "paginas")
    private Integer paginas;

    @ManyToMany(cascade = CascadeType.REFRESH) //para que al guardar el libro, se actualice con los autores
    private List<Autor> autores;
}
