import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import Interface.*;

import Joueurs.*;
import Phases.*;

public class main{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        //Interface graphique
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreIndex().setVisible(true);
            }
        });
        */


        // initialistion d'une variable qui contiendra le nombre de joueurs
        int nbrJoueurs;

        // Création de 4 variables joueurs
        Joueur joueur1;
        Joueur joueur2;
        Joueur joueur3;
        Joueur joueur4;

        // Création d'un scanner pour récupérer le nombre de joueur voulu par l'utilisateur
        Scanner scan = new Scanner(System.in);

        System.out.println("\n########## Jeu de questions / réponses ###########");
        System.out.println("\nCombien de joueur êtes-vous ?");
        nbrJoueurs = scan.nextInt();

        while (nbrJoueurs != 4 && nbrJoueurs != 8 && nbrJoueurs != 12 && nbrJoueurs !=16 && nbrJoueurs != 20){

            System.out.println("il faut un nombre de joueurs qui est un multiple de 4 !");
            System.out.println("\nCombien de joueur êtes-vous ?");
            nbrJoueurs = scan.nextInt();
        }
        EnsJoueurs nouvellePartie = new EnsJoueurs(nbrJoueurs);
        Vector select = new Vector(4);
            while (nbrJoueurs>=4) {
                System.out.println("~~~~~~~~~~~~~~ Voici les différents joueurs ~~~~~~~~~~~~~~");
                nouvellePartie.afficher();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\n");


                joueur1 = nouvellePartie.selectionnerJoueur();
                joueur2 = nouvellePartie.selectionnerJoueur();
                joueur3 = nouvellePartie.selectionnerJoueur();
                joueur4 = nouvellePartie.selectionnerJoueur();

                System.out.println("**************** Les joueurs sélectionnés *****************");
                joueur1.afficher();
                joueur2.afficher();
                joueur3.afficher();
                joueur4.afficher();

                System.out.println("***********************************************************");

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

                end.selectionnerJoueurs(joueurPhase3);

        }

            System.out.println(" La partie est fini ");
        System.out.println("~~~~~~~~~~~~~~ Voici les différents joueurs ~~~~~~~~~~~~~~");
            nouvellePartie.afficher();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
