package com.seguro.reclamo.servicio;

import com.seguro.reclamo.kafka.ReclamoProductor;
import com.seguro.reclamo.modelo.EstadoReclamo;
import com.seguro.reclamo.modelo.Reclamo;
import com.seguro.reclamo.modelo.ReclamoDTO;
import com.seguro.reclamo.repositorio.ReclamoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoServicio {
    private final ReclamoRepositorio repositorio;
    private final ReclamoProductor productorKafka;

    public ReclamoServicio(ReclamoRepositorio repositorio, ReclamoProductor productorKafka) {
        this.repositorio = repositorio;
        this.productorKafka = productorKafka;
    }

    public Reclamo crearReclamo(ReclamoDTO reclamoDTO) {
        Reclamo reclamo = new Reclamo(
                reclamoDTO.getNumeroPoliza(),  // 🔹 Eliminamos el `null`
                reclamoDTO.getUsuarioId(),
                reclamoDTO.getMonto(),
                EstadoReclamo.PENDIENTE, // Estado predeterminado
                reclamoDTO.getTipoReclamo(),
                reclamoDTO.getFechaReclamo()
        );

        reclamo = repositorio.save(reclamo);
        productorKafka.enviarReclamo(reclamo);
        return reclamo;
    }


    public List<Reclamo> listarReclamos() {
        return repositorio.findAll();
    }
}
