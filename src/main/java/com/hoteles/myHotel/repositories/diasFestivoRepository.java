
package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.ArrayList;

import com.hoteles.myHotel.models.diasFestivoModel;

@Repository
public interface diasFestivoRepository extends CrudRepository<diasFestivoModel, Integer> {
    public abstract ArrayList<diasFestivoModel> findByActivo(Boolean activo);

    public abstract diasFestivoModel findByFecha(Date fecha);

}
