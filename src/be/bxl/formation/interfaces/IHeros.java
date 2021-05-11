package be.bxl.formation.interfaces;

public interface IHeros extends IPersonnage{

    int getOr();
    int getCuir();
    String getName();

    void depouiller(IMonstre monstre);
    void seReposer();

}
