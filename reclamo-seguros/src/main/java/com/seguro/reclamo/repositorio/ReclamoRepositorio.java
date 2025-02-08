package com.seguro.reclamo.repositorio;

import com.seguro.reclamo.modelo.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepositorio extends JpaRepository<Reclamo, Integer> {
}
