package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.clienteModel;
import com.hoteles.myHotel.repositories.clienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteService {

    @Autowired
    clienteRepository clienteRepository;

    public ArrayList<clienteModel> clientes() {
        return (ArrayList<clienteModel>) this.clienteRepository.findAll();
    }

    public ArrayList<clienteModel> clientesActivos(Boolean activo) {
        return (ArrayList<clienteModel>) this.clienteRepository.findByActivo(activo);
    }

    public Optional<clienteModel> clientesxId(Integer id) {
        return this.clienteRepository.findById(id);
    }

    public clienteModel clientesCrear(clienteModel cliente) {
        return this.clienteRepository.save(cliente);
    }

}
