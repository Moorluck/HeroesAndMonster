package be.bxl.formation.interfaces;

import be.bxl.formation.models.Personnage;

public interface IPersonnage {
    int getEndurance();
    int getForce();
    int getPdv();
    boolean isVivant();

    void frapper(Personnage personnage);
    void recevoirUnCoup(int degat);
}
