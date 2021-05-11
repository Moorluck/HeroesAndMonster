package be.bxl.formation.models;

import be.bxl.formation.interfaces.IMonstre;

public abstract class Monstre extends Personnage implements IMonstre {

    // Constructeur

    public Monstre() {
        super();
    }

    // Méthode

    @Override
    public abstract void seFaireDepouiller();

}
