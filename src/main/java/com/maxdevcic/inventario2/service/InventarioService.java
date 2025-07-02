package com.maxdevcic.inventario2.service;

import org.springframework.stereotype.Service;

import com.maxdevcic.inventario2.model.Inventario;
import com.maxdevcic.inventario2.repository.InventarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    
    public Inventario guardarProducto(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Optional<Inventario> findById(Long id){
        return inventarioRepository.findById(id);
    }

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public Inventario nuevaCantidad(Long id, int cantidad) {
        Inventario nuevo = inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No existe este producto"));
        nuevo.setCantidad(cantidad + nuevo.getCantidad());
        return inventarioRepository.save(nuevo);
    }

    public Inventario actualizarTodo(Long id, Inventario nuevo) {
        Inventario encontrado = inventarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No existe este producto"));
            encontrado.setNombreproducto(nuevo.getNombreproducto());
            encontrado.setPreciounitario(nuevo.getPreciounitario());
            encontrado.setCantidad(nuevo.getCantidad());
        return inventarioRepository.save(encontrado);
    }
}
