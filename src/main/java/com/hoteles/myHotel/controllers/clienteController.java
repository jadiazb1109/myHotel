package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.clienteModel;
import com.hoteles.myHotel.services.clienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class clienteController {

    @Autowired
    clienteService clienteService;

    @GetMapping()
    public ArrayList<clienteModel> clientes() {
        return this.clienteService.clientes();
    }

    @GetMapping(path = "/query")
    public ArrayList<clienteModel> clientesActivos(@RequestParam("activo") Boolean activo) {
        return this.clienteService.clientesActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<clienteModel> clientesxId(@PathVariable("id") Integer id) {
        return this.clienteService.clientesxId(id);
    }

    @PostMapping()
    public clienteModel clientesCrear(@RequestBody clienteModel cliente) {
        return this.clienteService.clientesCrear(cliente);
    }

    @PutMapping()
    public clienteModel clientesModificar(@RequestBody clienteModel cliente) {
        return this.clienteService.clientesCrear(cliente);
    }

}
