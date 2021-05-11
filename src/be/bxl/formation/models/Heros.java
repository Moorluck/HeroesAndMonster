package be.bxl.formation.models;

import be.bxl.formation.interfaces.IHeros;
import be.bxl.formation.interfaces.IMonstre;
import be.bxl.formation.interfaces.IMonstreDepecable;
import be.bxl.formation.interfaces.IMonstreDepouillable;

public abstract class Heros extends Personnage implements IHeros {

    private String name;
    private int or;
    private int cuir;

    // Getter

    @Override
    public int getOr() {
        return this.or;
    }

    @Override
    public int getCuir() {
        return this.cuir;
    }

    public String getName() {
        return name;
    }

    // Setter


    public void setName(String name) {
        this.name = name;
    }

    public void addOr(int or) {
        this.or += or;
    }

    public void addCuir(int cuir) {
        this.cuir += cuir;
    }

    // Constructeur

    public Heros(String name) {
        super();
        this.name = name;
        this.or = 0;
        this.cuir = 0;
    }


    // Méthode

    @Override
    public void depouiller(IMonstre monstre) {

        if (monstre instanceof IMonstreDepecable m) {
            addCuir(m.getCuir());
        }

        if (monstre instanceof IMonstreDepouillable m) {
            addOr(m.getOr());
        }

    }

    @Override
    public void frapper(Personnage personnage) {
        super.frapper(personnage);
        if (!personnage.isVivant() && personnage instanceof IMonstre m) {
            depouiller(m);
            m.seFaireDepouiller();
        }
    }

    @Override
    public void seReposer() {
        heal(getPdvMax() - getPdv());
    }
}
