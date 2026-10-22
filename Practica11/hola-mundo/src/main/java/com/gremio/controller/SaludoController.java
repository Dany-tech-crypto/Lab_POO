package com.gremio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gremio.model.Aventurero;

@Controller
public class SaludoController {

    @GetMapping("/aventurero")
    public String aventurero(Model model) {
        Aventurero a = new Aventurero("Sylva", "Druida", 10);
        model.addAttribute("aventurero", a);
        return "aventurero";
    }
}