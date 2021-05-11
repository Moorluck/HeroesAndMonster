package be.bxl.formation;

import be.bxl.formation.enums.RaceHeros;
import be.bxl.formation.enums.RaceMonstre;
import be.bxl.formation.models.GestionnaireJeu;
import be.bxl.formation.utils.Dice;

public class Main  {

    public static void main(String[] args) {
        GestionnaireJeu jeu = new GestionnaireJeu();

        jeu.addNewHero("Jean", RaceHeros.HUMAIN);
        jeu.addNewHero("Jacques", RaceHeros.NAIN);
        jeu.addNewHero("Jackie", RaceHeros.NAIN);

        jeu.addNewMonstre(RaceMonstre.LOUP);
        jeu.addNewMonstre(RaceMonstre.ORQUE);
        jeu.addNewMonstre(RaceMonstre.DRAGONNET);

        int i = 1;
        while (!jeu.getHeros().isEmpty() && !jeu.getMonstres().isEmpty()) {
            System.out.printf("Tour %s :", i);
            System.out.println();

            jeu.passerUnTourDeJeu();
            String message = jeu.generateDetail();
            System.out.println(message);

            System.out.println("---------------------------------");
            i++;
        }
    }
}
