
package com.hoteles.myHotel.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.hoteles.myHotel.models.diasFestivoModel;
import com.hoteles.myHotel.repositories.diasFestivoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class diasFestivoService {

    @Autowired
    diasFestivoRepository diasFestivoRepository;

    public ArrayList<diasFestivoModel> diasFestivos() {
        return (ArrayList<diasFestivoModel>) this.diasFestivoRepository.findAll();
    }

    public ArrayList<diasFestivoModel> diasFestivosActivos(Boolean activo) {
        return (ArrayList<diasFestivoModel>) this.diasFestivoRepository.findByActivo(activo);
    }

    public diasFestivoModel diasFestivosFecha(Date fecha) {
        return this.diasFestivoRepository.findByFecha(fecha);
    }

    public Optional<diasFestivoModel> diasFestivosxId(Integer id) {
        return this.diasFestivoRepository.findById(id);
    }

    public diasFestivoModel diasFestivosCrear(diasFestivoModel diasFestivos) {
        return this.diasFestivoRepository.save(diasFestivos);
    }

}
