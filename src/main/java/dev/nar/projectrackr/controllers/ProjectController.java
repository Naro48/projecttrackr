package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.repositories.ProjetRepository;
import dev.nar.projectrackr.service.FonctionnaireServiceImpl;
import dev.nar.projectrackr.service.ProjetServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projets")
@CrossOrigin("*")
public class ProjectController {

    private final ProjetServiceImpl projetService;

    private final ProjetRepository projetRepository;

    private final FonctionnaireServiceImpl fonctionnaireService;

    public ProjectController(ProjetServiceImpl projetService, ProjetRepository projetRepository, FonctionnaireServiceImpl fonctionnaireService) {
        this.projetService = projetService;
        this.projetRepository = projetRepository;
        this.fonctionnaireService = fonctionnaireService;
    }

    @PostMapping("/creation_projet")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjetEntity> createProject(@RequestBody ProjectRequest projet){
        ProjetEntity projetEntity = projetService.createProject(projet.getTitle(),projet.getDate_debut(),projet.getDate_fin_estimee(),projet.getDead_line(),projet.getRespo_email());
        return new ResponseEntity<>(projetEntity,HttpStatus.OK);
    }

    @PostMapping("/search")
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
    public ResponseEntity<ProjetEntity> update(@PathVariable Integer id,@RequestBody ProjectRequest projet){
        ProjetEntity projetEntity = projetService.getProjectById(id);

        projetEntity.setTitle(projet.getTitle());
        projetEntity.setDate_debut(projet.getDate_debut());
        projetEntity.setDate_fin_estime(projet.getDate_fin_estimee());
        projetEntity.setDead_line(projet.getDead_line());
        projetEntity.setRespo_projet(fonctionnaireService.findByEmail(projet.getRespo_email()));

        projetRepository.save(projetEntity);


        return new ResponseEntity<>(projetEntity,HttpStatus.OK);
    }

    @GetMapping("/email/{id}")
    public ResponseEntity<FonctionnaireEntity> getProjectRespo(@PathVariable Integer id){
        FonctionnaireEntity fonctionnaireEntity = projetService.GetProjectRespo(id);
        return new ResponseEntity<>(fonctionnaireEntity, HttpStatus.OK);
    }

    @GetMapping("/all_users")
    public ResponseEntity<Integer> getNumberOfAllUsers(){
        Integer NumberOfUsers = fonctionnaireService.GetNumberOfUsers();

        return new ResponseEntity<>(NumberOfUsers, HttpStatus.OK);
    }
    @GetMapping("/find_users")
    public ResponseEntity<List<FonctionnaireEntity>> findAllUsers(){
        List<FonctionnaireEntity> fonctionnaireEntities = fonctionnaireService.findAll();
        return new ResponseEntity<>(fonctionnaireEntities,HttpStatus.OK);
    }

    @GetMapping("/tdev/{id}")
    public ResponseEntity<Double> getProjectTdev(@PathVariable Integer id){
        Double tdev = projetService.getTimeDev(id);
        return new ResponseEntity<>(tdev,HttpStatus.OK);
    }

    @GetMapping("/pm/{id}")
    public ResponseEntity<Double> getProjectPm(@PathVariable Integer id){
        Double Effort = projetService.getEffort(id);
        return new ResponseEntity<>(Effort,HttpStatus.OK);
    }

    @GetMapping("/pm/all")
    public ResponseEntity<Double> getTotalPm(){
        List<ProjetEntity> projets = projetRepository.findAll();
        Double TotalPm = 0.0;
        for (ProjetEntity projet : projets) {
            TotalPm += projetService.getEffort(projet.getId());
        }

        return new ResponseEntity<>(TotalPm, HttpStatus.OK);
    }

    @GetMapping("/pm")
    public ResponseEntity<Map<String,Double>> getMapProjectPM(){
        Map<String,Double> map = new HashMap<>();
        List<ProjetEntity> projets = projetService.findAllProjects();

        for (ProjetEntity projet : projets) {
            Double effort = projetService.getEffort(projet.getId());

            map.put(projet.getTitle(),effort);
        }
        
        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    private static class ProjectRequest {
        private String title;
        private Date date_debut;
        private Date date_fin_estimee;
        private Date dead_line;
        private String respo_email;
    }
}


