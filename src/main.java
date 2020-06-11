import Joueurs.EnsJoueurs;
import Joueurs.Joueur;
import Phases.Phase1;
import Phases.Phase2;
import Phases.Phase3;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class main{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // initialistion d'une variable qui contiendra le nombre de joueurs
        int nbrJoueurs;

        // Création de 4 variables joueurs
        Joueur joueur1;
        Joueur joueur2;
        Joueur joueur3;
        Joueur joueur4;

        // Création d'un scanner pour récupérer le nombre de joueur voulu par l'utilisateur
        Scanner scan = new Scanner(System.in);
        System.out.println("Combien de joueur êtes-vous ?");
        nbrJoueurs = scan.nextInt();

        if(nbrJoueurs <4){
            System.out.println("il faut au moins 4 joueurs");
        }else {
            EnsJoueurs nouvellePartie = new EnsJoueurs(nbrJoueurs);
            nouvellePartie.afficher();
            System.out.println("\n");
            Vector select = new Vector(4);
            while (nbrJoueurs>=4) {


                joueur1 = nouvellePartie.selectionnerJoueur();
                joueur2 = nouvellePartie.selectionnerJoueur();
                joueur3 = nouvellePartie.selectionnerJoueur();
                joueur4 = nouvellePartie.selectionnerJoueur();

                joueur1.afficher();
                joueur2.afficher();
                joueur3.afficher();
                joueur4.afficher();

                select.addElement(joueur1);
                select.addElement(joueur2);
                select.addElement(joueur3);
                select.addElement(joueur4);


                nbrJoueurs = nbrJoueurs-4;

                Phase1 start = new Phase1();
                Phase2 middle = new Phase2();
                Phase3 end = new Phase3();



               start.phasedeJeu(select);

                Vector joueurPhase2 = start.selectionnerJoueurs(select);
                middle.phasedeJeu(joueurPhase2);


                Vector joueurPhase3 = middle.selectionnerJoueurs(joueurPhase2);
                end.phasedeJeu(joueurPhase3);

                Vector last = end.selectionnerJoueurs(joueurPhase3);

                Joueur gagnant = (Joueur) last.elementAt(0);
                gagnant.changerEtat("gagnant");

                nouvellePartie.afficher();

            }
        }
    }
}
