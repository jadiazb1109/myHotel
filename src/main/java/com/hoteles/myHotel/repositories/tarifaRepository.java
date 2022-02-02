package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.tarifaModel;

@Repository
public interface tarifaRepository extends CrudRepository<tarifaModel, Integer> {
    public abstract ArrayList<tarifaModel> findByActivo(Boolean activo);

    public abstract tarifaModel findByDia(Integer dia);

}