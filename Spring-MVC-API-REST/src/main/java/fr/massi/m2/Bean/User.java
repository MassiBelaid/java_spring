package fr.massi.m2.Bean;

public class User {
    private String nom;
    private String prenom;
    private int age;


    public User(){}

    public void printUser(){
        System.out.println("Nom : "+nom+", prénom : "+prenom+", age : "+age);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
