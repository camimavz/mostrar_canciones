package com.camilamorales.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilamorales.modelos.Cancion;
import com.camilamorales.repositorios.RepositorioCanciones;


@Service
public class ServicioCanciones {
    @Autowired
    private RepositorioCanciones repositorioC;

    public List<Cancion> obtenerTodasLasCanciones(){
        return this.repositorioC.findAll();
    }

    public Cancion obtenerCancionPorId(Long id){
        return repositorioC.findById(id).orElse(null);
    }

    //metodo para agregar cancion
    public Cancion agregarCancion(Cancion cancion){
        return repositorioC.save(cancion);
    }

    //metodo para actualizar una cancion
    public Cancion actualizaCancion(Cancion cancion){
        return repositorioC.save(cancion);
    }
}
