package be.bxl.formation.models;

import be.bxl.formation.interfaces.IMonstreDepouillable;
import be.bxl.formation.utils.Dice;

public class Orque extends Monstre implements IMonstreDepouillable {

    private int or;

    @Override
    public int getOr() {
        return this.or;
    }

    public Orque() {
        super();
        this.or = Dice.throwD6();
    }

    @Override
    public void seFaireDepouiller() {
        this.or = 0;
    }

    @Override
    public String toString() {
        return "Orque";
    }
}
