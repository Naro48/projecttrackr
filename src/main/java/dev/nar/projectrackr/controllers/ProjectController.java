package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.service.ProjetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjectController {

    private final ProjetServiceImpl projetService;

    public ProjectController(ProjetServiceImpl projetService) {
        this.projetService = projetService;
    }

    @PostMapping("/creation_projet")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetEntity createProject(@RequestBody ProjetEntity projet){
        return projetService.createProject(projet.getTitle(),projet.getDate_debut(),projet.getDate_fin_estime(),projet.getDead_line());
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<ProjetEntity>> searchProjectByTitle(@RequestBody String title){
        List<ProjetEntity> projetEntities = projetService.searchProjectByTitle(title);
        return new ResponseEntity<>(projetEntities,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProjetEntity> getProjectById(@PathVariable("id") int id){
        ProjetEntity projet = projetService.getProjectById(id);

        return new ResponseEntity<>(projet,HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<ProjetEntity> addProject(@RequestBody ProjetEntity projet){
        ProjetEntity project = projetService.addProject(projet);


        return new ResponseEntity<>(project,HttpStatus.OK);

    }

    @DeleteMapping("/delete/all")
    public void deleteAllProjects(){
        projetService.deleteAllProjects();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        projetService.deleteProjectById(id);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<ProjetEntity>> findAll(){
        List<ProjetEntity> projet = projetService.findAllProjects();

        return new ResponseEntity<>(projet,HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProjetEntity> update(@RequestBody ProjetEntity projet){
        projetService.updateProject(projet);

        return new ResponseEntity<>(projet,HttpStatus.OK);
    }

}
