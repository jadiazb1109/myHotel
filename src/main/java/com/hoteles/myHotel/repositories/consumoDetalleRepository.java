
package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.consumoDetalleModel;

@Repository
public interface consumoDetalleRepository extends CrudRepository<consumoDetalleModel, Integer> {
    public abstract ArrayList<consumoDetalleModel> findByActivo(Boolean activo);

}