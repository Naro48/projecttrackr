package dev.nar.projectrackr.auth;

import dev.nar.projectrackr.FonctionnaireRole;
import io.micrometer.observation.Observation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String role;



    public FonctionnaireRole getRealRole() throws RuntimeException{
        if (Objects.equals(this.role, "Responsable projet")){
            return FonctionnaireRole.PROJECT_MANAGER;
        }
        if (Objects.equals(this.role, "Responsable tâche")){
            return FonctionnaireRole.TASK_MANAGER;
        }
        else {
            Observation.CheckedCallable<RuntimeException, Throwable> erreur = () -> new RuntimeException("Erreur");
        }
        return null;
    }


}
