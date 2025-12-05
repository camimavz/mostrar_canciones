package com.camilamorales.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.camilamorales.modelos.Artista;
import com.camilamorales.modelos.Cancion;
import com.camilamorales.servicios.ServicioCanciones;
import com.camilamorales.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioC;

    @Autowired
    private ServicioArtistas servicioA;

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


    @GetMapping("/canciones/formulario/agregar")
        public String formularioAgregarCancion(Model modelo){
        Cancion cancion = new Cancion();
        cancion.setArtista(new Artista()); // ← LÍNEA CLAVE

        modelo.addAttribute("cancion", cancion);

        List<Artista> listaArtistas = servicioA.obtenerTodosLosArtistas();
        modelo.addAttribute("listaArtistas", listaArtistas);

        return "agregarCancion";
}

    //agregar cancion a base de datos 
    @PostMapping("/canciones/procesa/agregar")
        public String procesarAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult resultado,
            Model modelo){

    // si hay errores, debemos volver al formulario y reenviar la lista de artistas
        if(resultado.hasErrors()){
        
        List<Artista> listaArtistas = servicioA.obtenerTodosLosArtistas();
            modelo.addAttribute("listaArtistas", listaArtistas);
            return "agregarCancion";
    }

    servicioC.agregarCancion(cancion);
    return "redirect:/canciones";
}

    //metodo para edicar cancion con formulario
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion")Long id, Model modelo) {
        Cancion cancion  = servicioC.obtenerCancionPorId(id);
        modelo.addAttribute("cancion", cancion);
        modelo.addAttribute("idCancion", id);
        return "editarCancion";
    }

    //procesar formulario de edicion
    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCanciones(@PathVariable("idCancion") Long id,
                                            @Valid @ModelAttribute("cancion") Cancion cancion,
                                            BindingResult resultado,
                                            Model modelo) {
                                            
                                            //si hay error de validación -> redirigir al formulario
                                            if(resultado.hasErrors()){
                                                cancion.setId(id);
                                                return "editarCancion";
                                            }
                                            //que le id de la cancion sea correcto
                                            cancion.setId(id);
                                            servicioC.actualizaCancion(cancion);
                                            //redirigir a lista de canciones
                                            return "redirect:/canciones";
                                            }

    //elimina canción dado el id recibido y redirige a /canciones
    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion")Long idCancion){
        servicioC.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }
}
