package be.bxl.formation.models;

public class Nain extends Heros{

    // Getter

    @Override
    public int getEndurance() {
        return super.getEndurance() + 2;
    }

    // Constructeur

    public Nain(String name) {
        super(name);
    }


}
