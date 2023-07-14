package dev.nar.projectrackr.service;

import dev.nar.projectrackr.FonctionnaireRole;
import dev.nar.projectrackr.ProfilFctn;
import dev.nar.projectrackr.entities.FonctionnaireEntity;

public interface FonctionnaireService {

    public FonctionnaireEntity findByEmail(String email);

}
