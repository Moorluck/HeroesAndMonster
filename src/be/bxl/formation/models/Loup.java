package be.bxl.formation.models;

import be.bxl.formation.interfaces.IMonstreDepecable;
import be.bxl.formation.utils.Dice;

public class Loup extends Monstre implements IMonstreDepecable {

    private int cuir;

    // Constructeur

    public Loup() {
        super();
        this.cuir = Dice.throwD4();
    }

    // Getter

    @Override
    public int getCuir() {
        return this.cuir;
    }

    // Setter

    @Override
    public void seFaireDepouiller() {
        this.cuir = 0;
    }

    @Override
    public String toString() {
        return "Loup";
    }
}
