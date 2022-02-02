
package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.servicioModel;
import com.hoteles.myHotel.repositories.servicioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioService {

    @Autowired
    servicioRepository servicioRepository;

    public ArrayList<servicioModel> servicios() {
        return (ArrayList<servicioModel>) this.servicioRepository.findAll();
    }

    public ArrayList<servicioModel> serviciosActivos(Boolean activo) {
        return (ArrayList<servicioModel>) this.servicioRepository.findByActivo(activo);
    }

    public Optional<servicioModel> serviciosxId(Integer id) {
        return this.servicioRepository.findById(id);
    }

    public servicioModel serviciosCrear(servicioModel servicio) {
        return this.servicioRepository.save(servicio);
    }

}
