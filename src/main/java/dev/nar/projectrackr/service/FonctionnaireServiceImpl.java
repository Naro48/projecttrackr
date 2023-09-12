package dev.nar.projectrackr.service;

import dev.nar.projectrackr.FonctionnaireRole;
import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.repositories.FonctionnaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FonctionnaireServiceImpl implements FonctionnaireService {

    private final FonctionnaireRepository fonctionnaireRepository;


    public FonctionnaireServiceImpl(FonctionnaireRepository fonctionnaireRepository) {
        this.fonctionnaireRepository = fonctionnaireRepository;
    }

    @Override
    public FonctionnaireEntity findByEmail(String email){
        return fonctionnaireRepository.findByEmail(email);
    }

    @Override
    public Integer GetNumberOfUsers() {
        return fonctionnaireRepository.findAll().size();
    }

    @Override
    public List<FonctionnaireEntity> findAll() {
        List<FonctionnaireEntity> fonctionnaireEntities = fonctionnaireRepository.findAll();
        List<FonctionnaireEntity> fonctionnaireEntities1 = new java.util.ArrayList<>(List.of());

        for (FonctionnaireEntity fonctionnaire : fonctionnaireEntities){
            if (fonctionnaire.getRole() == null) {
                continue;
            }
            else {
                fonctionnaireEntities1.add(fonctionnaire);
            }
        }

        return fonctionnaireEntities1;


    }


}
