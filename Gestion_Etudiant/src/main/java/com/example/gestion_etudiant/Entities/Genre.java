package com.example.gestion_etudiant.Entities;

public enum Genre {
    MASCULIN("Masculin"),
    FEMININ("Féminin");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
