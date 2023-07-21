package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.FonctionnaireEntity;

import java.util.Optional;

public interface FonctionnaireService {

    public FonctionnaireEntity findByEmail(String email);


}
