package com.camilamorales.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilamorales.modelos.Artista;
import com.camilamorales.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
    @Autowired
    private RepositorioArtistas repositorioA;

    //metodo para obtener todos los artistas
    public List<Artista> obtenerTodosLosArtistas() {
        return repositorioA.findAll();
    }

    //metodo para obtener cancion por id
    public Artista obtenerArtistaPorId(Long id){
        return repositorioA.findById(id).orElse(null);
    }

    //para agregar artista
    public Artista agregarArtista(Artista artista){
        return repositorioA.save(artista);
    }
}
