
package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.tarifaModel;
import com.hoteles.myHotel.repositories.tarifaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tarifaService {

    @Autowired
    tarifaRepository tarifaRepository;

    public ArrayList<tarifaModel> tarifas() {
        return (ArrayList<tarifaModel>) this.tarifaRepository.findAll();
    }

    public ArrayList<tarifaModel> tarifasActivos(Boolean activo) {
        return (ArrayList<tarifaModel>) this.tarifaRepository.findByActivo(activo);
    }

    public tarifaModel tarifasDiaSemana(Integer diaSemana) {
        return this.tarifaRepository.findByDia(diaSemana);
    }

    public Optional<tarifaModel> tarifasxId(Integer id) {
        return this.tarifaRepository.findById(id);
    }

    public tarifaModel tarifasCrear(tarifaModel tarifa) {
        return this.tarifaRepository.save(tarifa);
    }

}
