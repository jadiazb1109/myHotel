package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.diasFestivoModel;
import com.hoteles.myHotel.services.diasFestivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diasFestivos")
public class diasFestivoController {

    @Autowired
    diasFestivoService diasFestivoService;

    @GetMapping()
    public ArrayList<diasFestivoModel> diasFestivos() {
        return this.diasFestivoService.diasFestivos();
    }

    @GetMapping(path = "/query")
    public ArrayList<diasFestivoModel> diasFestivosActivos(@RequestParam("activo") Boolean activo) {
        return this.diasFestivoService.diasFestivosActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<diasFestivoModel> diasFestivosxId(@PathVariable("id") Integer id) {
        return this.diasFestivoService.diasFestivosxId(id);
    }

    @PostMapping()
    public diasFestivoModel diasFestivosCrear(@RequestBody diasFestivoModel diasFestivo) {
        return this.diasFestivoService.diasFestivosCrear(diasFestivo);
    }

    @PutMapping()
    public diasFestivoModel diasFestivosModificar(@RequestBody diasFestivoModel diasFestivo) {
        return this.diasFestivoService.diasFestivosCrear(diasFestivo);
    }

}
