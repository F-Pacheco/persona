package com.example.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Domicilio extends BaseEntity{
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;

    @ManyToOne(optional = false) //para que siempre que se agrege un domicilio, tenga localidad
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}