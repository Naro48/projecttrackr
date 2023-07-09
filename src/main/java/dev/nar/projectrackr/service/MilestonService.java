package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.MilestonEntity;
import dev.nar.projectrackr.entities.ProjetEntity;

import java.util.Date;
import java.util.List;

public interface MilestonService {

    public MilestonEntity createMilestone(ProjetEntity projet,String type,String compteRendu);

    public MilestonEntity findMilestoneById(Integer id);

    public List<MilestonEntity> GetMilestoneByType(String type);

    public void deleteAllMilestoneByProject(ProjetEntity projet);

    public void deleteAllMilestones();

    public void deleteMilestoneById(int id);

    public MilestonEntity updateMilestone(MilestonEntity milestone,
                                          String updatedType,
                                          String updatedCompteRendu);

}
