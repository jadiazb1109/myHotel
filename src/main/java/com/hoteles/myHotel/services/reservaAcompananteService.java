
package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.reservaAcompananteModel;
import com.hoteles.myHotel.repositories.reservaAcompananteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reservaAcompananteService {

    @Autowired
    reservaAcompananteRepository reservaAcompananteRepository;

    public ArrayList<reservaAcompananteModel> reservaAcompanantes() {
        return (ArrayList<reservaAcompananteModel>) this.reservaAcompananteRepository.findAll();
    }

    public ArrayList<reservaAcompananteModel> reservaAcompanantesActivos(Boolean activo) {
        return (ArrayList<reservaAcompananteModel>) this.reservaAcompananteRepository.findByActivo(activo);
    }

    public Optional<reservaAcompananteModel> reservaAcompanantesxId(Integer id) {
        return this.reservaAcompananteRepository.findById(id);
    }

    public reservaAcompananteModel reservaAcompanantesCrear(reservaAcompananteModel reservaAcompanante) {
        return this.reservaAcompananteRepository.save(reservaAcompanante);
    }

}