package com.hoteles.myHotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import com.hoteles.myHotel.models.clienteModel;

@Repository
public interface clienteRepository extends CrudRepository<clienteModel, Integer> {
    public abstract ArrayList<clienteModel> findByActivo(Boolean activo);

}
