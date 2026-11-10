package com.gremio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gremio.model.Proyecto;
import com.gremio.model.Tarea;
import com.gremio.repository.ProyectoRepository;
import com.gremio.repository.TareaRepository;

@Controller
public class ProyectoController {

    private final ProyectoRepository proyectoRepo;
    private final TareaRepository tareaRepo;

    public ProyectoController(ProyectoRepository proyectoRepo, TareaRepository tareaRepo) {
        this.proyectoRepo = proyectoRepo;
        this.tareaRepo = tareaRepo;
    }

    // 1. Listar todos los proyectos
    @GetMapping("/proyectos")
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoRepo.findAll());
        return "proyectos";
    }

    // 2. Formulario para nuevo proyecto
    @GetMapping("/proyectos/nuevo")
    public String formularioProyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "nuevo_proyecto";
    }

    // 3. Guardar proyecto
    @PostMapping("/proyectos/guardar")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoRepo.save(proyecto);
        return "redirect:/proyectos";
    }

    // 4. Ver detalle de un proyecto y sus tareas
    @GetMapping("/proyectos/{id}")
    public String verProyecto(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoRepo.findById(id).orElseThrow();
        model.addAttribute("proyecto", proyecto);
        
        // Objeto vacío para el formulario de nueva tarea dentro del proyecto
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setProyecto(proyecto);
        model.addAttribute("tarea", nuevaTarea);
        
        return "detalle_proyecto";
    }

    // 5. Guardar una tarea dentro de un proyecto
    @PostMapping("/proyectos/{proyectoId}/tareas/guardar")
    public String guardarTarea(@PathVariable Long proyectoId, @ModelAttribute Tarea tarea) {
        Proyecto proyecto = proyectoRepo.findById(proyectoId).orElseThrow();
        tarea.setProyecto(proyecto);
        tareaRepo.save(tarea);
        return "redirect:/proyectos/" + proyectoId;
    }

    // 6. Eliminar tarea
    @GetMapping("/tareas/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        Tarea tarea = tareaRepo.findById(id).orElseThrow();
        Long proyectoId = tarea.getProyecto().getId();
        tareaRepo.deleteById(id);
        return "redirect:/proyectos/" + proyectoId;
    }
}