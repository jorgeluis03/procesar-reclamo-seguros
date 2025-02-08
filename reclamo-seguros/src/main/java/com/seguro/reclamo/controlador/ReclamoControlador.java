package com.seguro.reclamo.controlador;

import com.seguro.reclamo.modelo.Reclamo;
import com.seguro.reclamo.modelo.ReclamoDTO;
import com.seguro.reclamo.servicio.ReclamoServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamos")
public class ReclamoControlador {
    private final ReclamoServicio servicio;

    public ReclamoControlador(ReclamoServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public Reclamo crearReclamo(@RequestBody ReclamoDTO reclamoDTO) {
        return servicio.crearReclamo(reclamoDTO);
    }

    @GetMapping
    public List<Reclamo> obtenerReclamos() {
        return servicio.listarReclamos();
    }
}
