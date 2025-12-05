package com.camilamorales.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.camilamorales.modelos.Artista;
import com.camilamorales.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioA;

    //para mostrar todos los artistas 
    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo){
        List<Artista> listaArtistas = servicioA.obtenerTodosLosArtistas();
        modelo.addAttribute("listaArtistas", listaArtistas);
        return "artistas";
    }

    //para mostrar detalle
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista")Long id, Model modelo){
        Artista artista = servicioA.obtenerArtistaPorId(id);
        modelo.addAttribute("artista", artista);
        return "detalleArtista";
    }

    //formulario
    @GetMapping("/artistas/formulario/agregar/{idArtista}")
    public String formularioAgregarArtista(Model modelo){
        modelo.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    //agregar artista a base de datos 
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(
            @Valid @ModelAttribute("artista") Artista artista,
            BindingResult resultado,
            Model modelo){
                
                //si no pasa validación -> redirigir al mismo formulario
                if(resultado.hasErrors()){
                    return "agregarArtista";
                }

                servicioA.agregarArtista(artista);
                
                //redirigir a artistas 
                return "redirect:/artistas";
            }
}
