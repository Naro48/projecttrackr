package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.service.ProjetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projets")
public class ProjectController {

    private final ProjetServiceImpl projetService;

    public ProjectController(ProjetServiceImpl projetService) {
        this.projetService = projetService;
    }

    @PostMapping("/projets")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetEntity createProject(@RequestBody ProjetEntity projet){
        return projetService.createProject(projet.getTitle(),projet.getDate_debut(),projet.getDate_fin_estime(),projet.getDead_line());
    }
}
