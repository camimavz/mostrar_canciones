package com.camilamorales.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.camilamorales.modelos.Cancion;
import com.camilamorales.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioC;

    //para mostrar todas las canciones 
    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo){
        List<Cancion> listaCanciones = servicioC.obtenerTodasLasCanciones();
        modelo.addAttribute("listaCanciones", listaCanciones);
        return "canciones";
    }

    //para mostrar detalle
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion")Long id, Model modelo){
        Cancion cancion = servicioC.obtenerCancionPorId(id);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }
}
