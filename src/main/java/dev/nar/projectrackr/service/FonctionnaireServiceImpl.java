package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.repositories.FonctionnaireRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FonctionnaireServiceImpl implements FonctionnaireService {

    private final FonctionnaireRepository fonctionnaireRepository;


    public FonctionnaireServiceImpl(FonctionnaireRepository fonctionnaireRepository) {
        this.fonctionnaireRepository = fonctionnaireRepository;
    }

    @Override
    public FonctionnaireEntity findByEmail(String email){
        return fonctionnaireRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Fonctionnaire Introuvable"));
    }


}
