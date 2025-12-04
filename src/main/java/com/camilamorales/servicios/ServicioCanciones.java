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

    //public ServicioCanciones(RepositorioCanciones repositorioC){
    //    this.repositorioC = repositorioC;
    //}

    public List<Cancion> obtenerTodasLasCanciones(){
        return this.repositorioC.findAll();
    }

    public Cancion obtenerCancionPorId(Long id){
        return repositorioC.findById(id).orElse(null);
    }
}
