package fr.massi.m2.Bean;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Registration {

    @NotEmpty(message = "le pseudo ne doit pas etre vide")
    private String pseudo;

    @Email(message = "Email non valide")
    private String email;

    @Valid
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Valid
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
