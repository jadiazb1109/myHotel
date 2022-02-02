
package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.reservaAcompananteModel;

@Repository
public interface reservaAcompananteRepository extends CrudRepository<reservaAcompananteModel, Integer> {
    public abstract ArrayList<reservaAcompananteModel> findByActivo(Boolean activo);

}