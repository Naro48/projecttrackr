package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import dev.nar.projectrackr.service.CostFactorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cost-factors")
@CrossOrigin("*")
public class CostFactorsController {

    private final CostFactorsService costFactorsService;

    public CostFactorsController(CostFactorsService costFactorsService) {
        this.costFactorsService = costFactorsService;
    }



    @GetMapping("/{id}")
    public CostFactorsEntity getCostFactorsById(@PathVariable int id) {
        return costFactorsService.findById(id)
                .orElseThrow(() -> new RuntimeException("Le facteur de coût est introuvable"));
    }



    @GetMapping("/title/{title}")
    public CostFactorsEntity getCostFactorsByTitle(@PathVariable String title) {
        return costFactorsService.findByTitle(title);
    }

    @GetMapping("/search/{title}")
    public List<CostFactorsEntity> searchCostFactorsByTitle(@PathVariable String title) {
        return costFactorsService.searchByTitle(title);
    }


}
