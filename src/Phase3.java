import java.util.Vector;

public class Phase3 implements Phase{
    @Override
    public Vector selectionnerJoueurs(Vector select) {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);
        Joueur joueur4 = (Joueur) select.elementAt(3);
        Joueur elimine = joueur1;

        int sc1 = joueur1.getScore();
        int sc2 = joueur2.getScore();

        int petit = sc1;

        if (sc2 < petit){
            petit = sc2;
            elimine = joueur2;
        }


        select.remove(elimine);

        return select;

    }

    @Override
    public void phasedeJeu(Vector select) {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);

    }
}
