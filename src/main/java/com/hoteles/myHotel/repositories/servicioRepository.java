package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.servicioModel;

@Repository
public interface servicioRepository extends CrudRepository<servicioModel, Integer> {
    public abstract ArrayList<servicioModel> findByActivo(Boolean activo);

}