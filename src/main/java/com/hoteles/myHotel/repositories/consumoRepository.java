
package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.consumoModel;

@Repository
public interface consumoRepository extends CrudRepository<consumoModel, Integer> {
    public abstract ArrayList<consumoModel> findByActivo(Boolean activo);

}
