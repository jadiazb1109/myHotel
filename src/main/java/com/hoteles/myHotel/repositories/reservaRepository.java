
package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.reservaModel;

@Repository
public interface reservaRepository extends CrudRepository<reservaModel, Integer> {
    public abstract ArrayList<reservaModel> findByActivo(Boolean activo);

}