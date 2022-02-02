
package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.consumoModel;
import com.hoteles.myHotel.repositories.consumoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class consumoService {

    @Autowired
    consumoRepository consumoRepository;

    public ArrayList<consumoModel> consumos() {
        return (ArrayList<consumoModel>) this.consumoRepository.findAll();
    }

    public ArrayList<consumoModel> consumosActivos(Boolean activo) {
        return (ArrayList<consumoModel>) this.consumoRepository.findByActivo(activo);
    }

    public Optional<consumoModel> consumosxId(Integer id) {
        return this.consumoRepository.findById(id);
    }

    public consumoModel consumosCrear(consumoModel consumo) {
        return this.consumoRepository.save(consumo);
    }

}
