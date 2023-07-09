package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import dev.nar.projectrackr.service.CostFactorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cost-factors")
public class CostFactorsController {

    private final CostFactorsService costFactorsService;

    public CostFactorsController(CostFactorsService costFactorsService) {
        this.costFactorsService = costFactorsService;
    }

    @PostMapping
    public CostFactorsEntity createCostFactors(@RequestParam String title, @RequestParam float poids,
                                               @RequestBody List<CostEntity> costs) {
        return costFactorsService.createCostFactors(title, poids, costs);
    }

    @PutMapping("/{id}")
    public CostFactorsEntity updateCostFactors(@PathVariable int id, @RequestParam String newTitle,
                                               @RequestParam float newPoids,
                                               @RequestBody List<CostEntity> newCosts) {
        Optional<CostFactorsEntity> optionalCostFactors = costFactorsService.findById(id);
        if (optionalCostFactors.isPresent()) {
            CostFactorsEntity costFactorsEntity = optionalCostFactors.get();
            return costFactorsService.updateCostFactors(costFactorsEntity, newTitle, newPoids, newCosts);
        } else {
            throw new RuntimeException("Le facteur de coût est introuvable");
        }
    }

    @GetMapping("/{id}")
    public CostFactorsEntity getCostFactorsById(@PathVariable int id) {
        return costFactorsService.findById(id)
                .orElseThrow(() -> new RuntimeException("Le facteur de coût est introuvable"));
    }

    @DeleteMapping("/{id}")
    public void deleteCostFactorsById(@PathVariable int id) {
        costFactorsService.deleteById(id);
    }

    @GetMapping("/title/{title}")
    public CostFactorsEntity getCostFactorsByTitle(@PathVariable String title) {
        return costFactorsService.findByTitle(title);
    }

    @GetMapping("/search/{title}")
    public List<CostFactorsEntity> searchCostFactorsByTitle(@PathVariable String title) {
        return costFactorsService.searchByTitle(title);
    }

    @DeleteMapping
    public void deleteAllCostFactors() {
        costFactorsService.deleteAll();
    }

    // Autres méthodes du contrôleur...

}
