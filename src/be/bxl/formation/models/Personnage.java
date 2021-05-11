package be.bxl.formation.models;

import be.bxl.formation.interfaces.IPersonnage;
import be.bxl.formation.utils.Dice;

public abstract class Personnage implements IPersonnage {

    private int endurance;
    private int force;
    private int pdv;
    private boolean vivant;

    private int pdvMax;

    // Getter


    @Override
    public int getEndurance() {
        return endurance;
    }

    public int getModificateurEndurance() {
        return (getEndurance()/5) - 1;
    }

    @Override
    public int getForce() {
        return force;
    }

    public int getModificateurForce() {
        return (getForce()/5) - 1;
    }

    @Override
    public int getPdv() {
        return pdv;
    }

    public int getPdvMax() {
        return pdvMax;
    }

    @Override
    public boolean isVivant() {
        return vivant;
    }

    // Setter


    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    // Constructeur

    public Personnage() {
        this.endurance = Dice.randomCharac();
        this.force = Dice.randomCharac();
        this.pdvMax = this.endurance + getModificateurEndurance();
        this.pdv = this.pdvMax;
        this.setVivant(true);
    }

    // Méthode

    @Override
    public void frapper(Personnage personnage) {
        int degat = Dice.throwD4() + getModificateurForce();
        personnage.recevoirUnCoup(degat);
    }

    public void recevoirUnCoup(int degat) {
        this.pdv -= degat;

        if (this.pdv <= 0) {
            setVivant(false);
        }
    }

    public void heal(int soin) {
        this.pdv += soin;
    }
}
