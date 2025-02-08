package com.seguro.reclamo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reclamos")
public class Reclamo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String numeroPoliza;

    @Column(nullable = false)
    private String usuarioId;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoReclamo estado;

    @Column(nullable = false)
    private String tipoReclamo; // "Accidente", "Robo", "Salud"

    @Column(nullable = false)
    private String fechaReclamo;

    public Reclamo(String numeroPoliza, String usuarioId, Double monto, EstadoReclamo estado, String tipoReclamo, String fechaReclamo) {
        this.numeroPoliza = numeroPoliza;
        this.usuarioId = usuarioId;
        this.monto = monto;
        this.estado = estado;
        this.tipoReclamo = tipoReclamo;
        this.fechaReclamo = fechaReclamo;
    }
}

