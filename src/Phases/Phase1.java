package Phases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Joueurs.Joueur;
import Phases.Phase;
import Questions.*;

public class Phase1 implements Phase {
    @Override
    public Vector selectionnerJoueurs(Vector select) {
        // On crée des variables pour les différents joueur du vecteur select
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);
        Joueur joueur4 = (Joueur) select.elementAt(3);

        // initialisation d'une variable qui contiendra le joueur ayant le score le plus faible
        Joueur elimine = joueur1;

        // initialisation de 4 variable qui contiennent les scores des différents joueurs
        int sc1 = joueur1.getScore();
        int sc2 = joueur2.getScore();
        int sc3 = joueur3.getScore();
        int sc4 = joueur4.getScore();

        // initialisation d'une variable qui contiendra le plus petit score
        int petit = sc1;

        // On compare tous les score pour trouver le plus faible
        if (sc2 < petit){
            petit = sc2;
            elimine = joueur2;
        }
        if (sc3 < petit){
            petit = sc3;
            elimine = joueur3;
        }
        if (sc4 < petit){
            petit = sc4;
            elimine = joueur4;
        }

        // On change l'état du joueur ayant le score le plus faible
        elimine.changerEtat("éliminé");

        // On retire le joueur éliminé de notre vecteur select.
        select.remove(elimine);

        System.out.println("\nLe joueur "+ elimine.getpseudo()+" a été eliminé");

        // On retourne notre nouveau vecteur
        return select;
    }

    @Override
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);
        Joueur joueur4 = (Joueur) select.elementAt(3);

        ArrayList liste = new ArrayList();


        Themes test = new Themes(liste);
        test.initialisation();
        test.serialiserListe("Themes");

        // Générer la liste de questions
        ListeQuestions Liste = new ListeQuestions();
        List<Question> LQ = Liste.openfile();// on peut aussi faire LQ =Liste.liste;


        System.out.println("\n C'est au tour de : ");
        joueur1.afficher();
        String theme = test.SelectionnerTheme();
        Question j1 = Liste.selectionnerQuestion(LQ,1,theme);
        j1.Afficher();
        boolean reponse = j1.Saisir();
        if(reponse){
            joueur1.mAJScore(2);
        }

        System.out.println("\n C'est au tour de : ");
        joueur2.afficher();
        String theme2 = test.SelectionnerTheme();
        Question j2 = Liste.selectionnerQuestion(LQ,1,theme2);
        j2.Afficher();
        boolean reponse2 = j2.Saisir();
        if(reponse2){
            joueur2.mAJScore(2);
        }

        System.out.println("\n C'est au tour de : ");
        joueur3.afficher();
        String theme3 = test.SelectionnerTheme();
        Question j3 = Liste.selectionnerQuestion(LQ,1,theme3);
        j3.Afficher();
        boolean reponse3 = j3.Saisir();
        if(reponse3){
            joueur3.mAJScore(2);
        }


        System.out.println("\n C'est au tour de : ");
        joueur4.afficher();
        String theme4 = test.SelectionnerTheme();
        Question j4 = Liste.selectionnerQuestion(LQ,1,theme4);
        j4.Afficher();
        boolean reponse4 = j4.Saisir();
        if(reponse4){
            joueur4.mAJScore(2);
        }

    }
}
