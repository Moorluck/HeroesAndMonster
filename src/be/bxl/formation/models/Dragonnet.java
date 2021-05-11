package be.bxl.formation.models;

import be.bxl.formation.interfaces.IMonstreDepecable;
import be.bxl.formation.interfaces.IMonstreDepouillable;
import be.bxl.formation.utils.Dice;

public class Dragonnet extends Monstre implements IMonstreDepouillable, IMonstreDepecable {

    private int or;
    private int cuir;

    @Override
    public int getOr() {
        return this.or;
    }

    @Override
    public int getCuir() {
        return this.cuir;
    }

    public Dragonnet() {
        this.or = Dice.throwD6();
        this.cuir = Dice.throwD4();
    }

    @Override
    public void seFaireDepouiller() {
        this.or = 0;
        this.cuir = 0;
    }

    @Override
    public String toString() {
        return "Dragonnet";
    }
}
