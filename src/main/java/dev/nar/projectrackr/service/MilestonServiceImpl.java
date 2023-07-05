package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.MilestonEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.exception.MilestoneNotFoundException;
import dev.nar.projectrackr.repositories.MilestonRepository;

import java.util.List;

public class MilestonServiceImpl implements MilestonService{

    private final MilestonRepository milestonRepository;

    public MilestonServiceImpl(MilestonRepository milestonRepository) {
        this.milestonRepository = milestonRepository;
    }

    @Override
    public MilestonEntity createMilestone(ProjetEntity projet) {
        MilestonEntity mileston = new MilestonEntity();

        mileston.setProjet(projet);

        return milestonRepository.save(mileston);

    }

    @Override
    public MilestonEntity findMilestoneById(Integer id) {
        return milestonRepository.findById(id).orElseThrow(() -> new MilestoneNotFoundException("Milestone By Id "+id+"Not Found") );
    }

    @Override
    public List<MilestonEntity> GetMilestoneByType(String type) {
        return milestonRepository.findByTypeIgnoreCase(type);
    }

    @Override
    public void deleteAllMilestoneByProject(ProjetEntity projet) {
        milestonRepository.deleteByProjet(projet);
    }

    @Override
    public void deleteAllMilestones() {
        milestonRepository.deleteAll();
    }

    @Override
    public void deleteMilestoneById(int id) {
        milestonRepository.deleteById(id);
    }

    @Override
    public MilestonEntity updateMilestone(MilestonEntity milestone) {
        return milestonRepository.save(milestone);
    }
}
