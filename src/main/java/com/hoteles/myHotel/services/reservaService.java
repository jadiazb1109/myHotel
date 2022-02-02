package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.reservaModel;
import com.hoteles.myHotel.repositories.reservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reservaService {

    @Autowired
    reservaRepository reservaRepository;

    public ArrayList<reservaModel> reservas() {
        return (ArrayList<reservaModel>) this.reservaRepository.findAll();
    }

    public ArrayList<reservaModel> reservasActivos(Boolean activo) {
        return (ArrayList<reservaModel>) this.reservaRepository.findByActivo(activo);
    }

    public Optional<reservaModel> reservasxId(Integer id) {
        return this.reservaRepository.findById(id);
    }

    public reservaModel reservasCrear(reservaModel reserva) {
        return this.reservaRepository.save(reserva);
    }

}
