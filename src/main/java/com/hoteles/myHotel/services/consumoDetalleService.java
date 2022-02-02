package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.consumoDetalleModel;
import com.hoteles.myHotel.repositories.consumoDetalleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class consumoDetalleService {

    @Autowired
    consumoDetalleRepository consumoDetalleRepository;

    public ArrayList<consumoDetalleModel> consumoDetalles() {
        return (ArrayList<consumoDetalleModel>) this.consumoDetalleRepository.findAll();
    }

    public ArrayList<consumoDetalleModel> consumoDetallesActivos(Boolean activo) {
        return (ArrayList<consumoDetalleModel>) this.consumoDetalleRepository.findByActivo(activo);
    }

    public Optional<consumoDetalleModel> consumoDetallesxId(Integer id) {
        return this.consumoDetalleRepository.findById(id);
    }

    public consumoDetalleModel consumoDetallesCrear(consumoDetalleModel consumoDetalle) {
        return this.consumoDetalleRepository.save(consumoDetalle);
    }

}
