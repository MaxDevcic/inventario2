package com.maxdevcic.inventario2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxdevcic.inventario2.model.Inventario;
import com.maxdevcic.inventario2.service.InventarioService;

@RequestMapping("/api/inventario")
@Controller
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public Inventario guardarInventario(@RequestBody Inventario inventario) {
        return inventarioService.guardarProducto(inventario);
    }

    @GetMapping
    public List<Inventario> obtenerTodo(){
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> encontrarId(@PathVariable Long id){
        return inventarioService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> cambioCantidad(@PathVariable Long id,@RequestBody int cantidad) {
        try {
            Inventario actualizado_cantidad = inventarioService.nuevaCantidad(id, cantidad);
            return ResponseEntity.ok(actualizado_cantidad);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizar(@PathVariable Long id,@RequestBody Inventario inventario) {
        try {
            Inventario actualizado = inventarioService.actualizarTodo(id, inventario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
