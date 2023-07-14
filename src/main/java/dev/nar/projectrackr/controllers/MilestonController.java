package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.ProfilFctn;
import dev.nar.projectrackr.entities.MilestonEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.service.MilestonService;
import dev.nar.projectrackr.service.ProjetService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestones")
public class MilestonController {

    private final MilestonService milestonService;

    private final ProjetService projetService;



    public MilestonController(MilestonService milestonService, ProjetService projetService) {
        this.milestonService = milestonService;
        this.projetService = projetService;
    }

    @PostMapping("/{projectId}/milestones")
    public MilestonEntity createMileston(@RequestBody MilestonRequest milestonRequest){
        ProjetEntity projet = projetService.getProjectById(milestonRequest.getProjectId());

        return milestonService.createMilestone(projet
                ,milestonRequest.getType()
                ,milestonRequest.getCompteRendu());
    }
    @GetMapping("/{milestoneId}")
    public MilestonEntity getMilestoneById(@PathVariable int milestoneId){
        return milestonService.findMilestoneById(milestoneId);
    }

    @GetMapping("/type/{type}")
    public List<MilestonEntity> getMilestonesByType(@PathVariable String type) {
        return milestonService.GetMilestoneByType(type);
    }
    @DeleteMapping("/projets/{projectId}")
    public void deleteAllMilestonesByProject(@PathVariable int projectId){
        ProjetEntity projet = projetService.getProjectById(projectId);

        milestonService.deleteAllMilestoneByProject(projet);
    }

    @DeleteMapping("/{milestoneId}")
    public void deleteMilestoneById(@PathVariable int milestoneId){
        milestonService.deleteMilestoneById(milestoneId);
    }

    @PutMapping("/{milestoneId}")
    public MilestonEntity updateMilestone(@PathVariable Integer milestoneId, @RequestBody MilestonRequest updatedMilestone) {
        MilestonEntity milestone = milestonService.findMilestoneById(milestoneId);
        return milestonService.updateMilestone(milestone,updatedMilestone.getType(), updatedMilestone.getCompteRendu());
    }




    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class MilestonRequest {

        private String type ;
        private String compteRendu;
        private int projectId;


    }

}
