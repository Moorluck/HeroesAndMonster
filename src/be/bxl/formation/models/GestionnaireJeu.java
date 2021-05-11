package be.bxl.formation.models;

import be.bxl.formation.enums.RaceHeros;
import be.bxl.formation.enums.RaceMonstre;
import be.bxl.formation.interfaces.IHeros;
import be.bxl.formation.interfaces.IMonstre;

import java.util.ArrayList;
import java.util.Random;

public class GestionnaireJeu {

    ArrayList<IHeros> heros = new ArrayList<>();
    ArrayList<IMonstre> monstres = new ArrayList<>();

    public GestionnaireJeu() {
        this.heros = new ArrayList<>();
        this.monstres = new ArrayList<>();
    }

    // Getter

    public ArrayList<IHeros> getHeros() {
        return heros;
    }

    public ArrayList<IMonstre> getMonstres() {
        return monstres;
    }

    // Setter

    public void addNewHero(String name, RaceHeros race) {
        if (race == RaceHeros.HUMAIN) {
            Humain newHumain = new Humain(name);
            heros.add(newHumain);
        }

        if (race == RaceHeros.NAIN) {
            Nain newNain = new Nain(name);
            heros.add(newNain);
        }
    }

    public void addNewMonstre(RaceMonstre race) {
        if (race == RaceMonstre.LOUP) {
            monstres.add(new Loup());
        }

        else if (race == RaceMonstre.ORQUE) {
            monstres.add(new Orque());
        }

        else if (race == RaceMonstre.DRAGONNET) {
            monstres.add(new Dragonnet());
        }
    }

    // Méthode

    public String generateDetail() {

        StringBuilder sb = new StringBuilder();

        sb.append("Heros : \n \n");

        for (IHeros hero : heros) {
            sb.append(String.format("- %s \n" +
                    "%s PDV \n" +
                    "%s or \n" +
                    "%s cuir \n \n", hero.getName(), hero.getPdv(), hero.getOr(), hero.getCuir()));
        }

        sb.append("Monstre : \n \n");

        for (IMonstre monstre : monstres) {
            sb.append(String.format("- %s \n" +
                    "%s PDV \n \n", monstre.toString(), monstre.getPdv()));
        }

        return sb.toString();
    }

    public void passerUnTourDeJeu() {

        boolean win = true;

        Random rd = new Random();

        for (IHeros heros : heros) {
            IMonstre monstre = monstres.get(rd.nextInt(monstres.size()));
            heros.frapper((Personnage) monstre);
        }

        for (IMonstre monstre : monstres) {
            IHeros hero = heros.get(rd.nextInt(heros.size()));
            monstre.frapper((Personnage) hero);
        }

        checkDead();
    }


    private void checkDead() {

        for (int i = heros.size() - 1; i >= 0; i--) {
            if (!heros.get(i).isVivant()) {
                heros.remove(heros.get(i));
            }
        }

        for (int i = monstres.size() - 1; i >= 0; i--) {
            if (!monstres.get(i).isVivant()) {
                monstres.remove(monstres.get(i));
            }
        }

    }


}
