package com.maxdevcic.inventario2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxdevcic.inventario2.model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long>{
}
