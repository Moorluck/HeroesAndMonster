package be.bxl.formation.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dice {

    private static Random rd;

    public static int throwD4() {

        rd = new Random();

        return rd.nextInt(4) + 1;

    }

    public static int throwD6() {

        rd = new Random();

        return rd.nextInt(6) + 1;

    }

    public static int randomCharac() {

        ArrayList<Integer> jets = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int jet = throwD6();
            jets.add(jet);
        }

        jets.remove(Collections.min(jets));

        int resultat = 0;

        for (int jet : jets) {
            resultat += jet;
        }

        return resultat;

    }
}
