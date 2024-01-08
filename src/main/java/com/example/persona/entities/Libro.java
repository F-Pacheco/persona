package com.example.persona.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Table(name = "Libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends BaseEntity{
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "genero", length = 1)
    private String genero;
    @Column(name = "paginas")
    private Integer paginas;
    @Column(name = "titulo")
    private String titulo;
}
