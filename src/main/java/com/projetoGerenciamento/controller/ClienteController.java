package com.projetoGerenciamento.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamento.entities.Cliente;
import com.projetoGerenciamento.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Clientes", description = "API REST DE GERENCIAMENTO DE CLIENTES")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService clienteService;
    
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza usuario por ID")
    public ResponseEntity<Cliente> getProductById(@PathVariable Long id) {
    	Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    @Operation(summary = "Apresenta todos os Clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }
    @PostMapping("/")
    @Operation(summary = "Cadastra um Cliente")
    public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid Cliente cliente) {
    	Cliente criarCliente = clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarCliente);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera o Cliente")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
    	Cliente updatedCliente = clienteService.updateCliente(id, cliente);
        if (updatedCliente != null) {
            return ResponseEntity.ok(updatedCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o Cliente")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        boolean deleted = clienteService.deleteCliente(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}