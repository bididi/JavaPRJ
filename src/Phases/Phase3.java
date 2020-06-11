package Phases;

import Joueurs.Joueur;
import Phases.Phase;
import Questions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Phase3 implements Phase {
    @Override
    public Vector selectionnerJoueurs(Vector select) {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);

        Joueur elimine = joueur1;

        int sc1 = joueur1.getScore();
        int sc2 = joueur2.getScore();

        int petit = sc1;

        if (sc2 < petit){
            petit = sc2;
            elimine = joueur2;
        }

        // On change l'état du joueur ayant le score le plus faible
        elimine.changerEtat("éliminé");

        select.remove(elimine);

        System.out.println("\nLe joueur "+ elimine.getpseudo()+" a été eliminé");

        return select;

    }

    @Override
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);

        ArrayList liste = new ArrayList();


        Themes test = new Themes(liste);
        test.initialisation();
        test.serialiserListe("Themes");

        // Générer la liste de questions
        ListeQuestions Liste = new ListeQuestions();
        List<Question> LQ = Liste.openfile();// on peut aussi faire LQ =Liste.liste;

        // On crée une liste avec 3 thèmes
        ArrayList<String> themeFinal = new ArrayList<>();
        themeFinal.add(test.SelectionnerTheme());
        themeFinal.add(test.SelectionnerTheme());
        themeFinal.add(test.SelectionnerTheme());

        int random = (int) (Math.random() * ((themeFinal.size()-1 ) +1));
        String theme = themeFinal.get(random) ;

        System.out.println("\n C'est au tour du : ");
        joueur1.afficher();
        Question j1 = Liste.selectionnerQuestion(LQ,1,theme);
        j1.Afficher();
        boolean reponse = j1.Saisir();
        if(reponse){
            joueur1.mAJScore(5);
        }

        System.out.println("\n C'est au tour du : ");
        joueur2.afficher();
        Question j2 = Liste.selectionnerQuestion(LQ,1,theme);
        j2.Afficher();
        boolean reponse2 = j2.Saisir();
        if(reponse2){
            joueur2.mAJScore(5);
        }

        themeFinal.remove(random);

        random = (int) (Math.random() * ((themeFinal.size()-1 ) +1));
        theme = themeFinal.get(random) ;

        System.out.println("\n C'est au tour du : ");
        joueur1.afficher();
        Question j12 = Liste.selectionnerQuestion(LQ,1,theme);
        j12.Afficher();
        boolean reponse12 = j12.Saisir();
        if(reponse12){
            joueur1.mAJScore(5);
        }

        System.out.println("\n C'est au tour du : ");
        joueur2.afficher();
        Question j22 = Liste.selectionnerQuestion(LQ,1,theme);
        j22.Afficher();
        boolean reponse22 = j22.Saisir();
        if(reponse22){
            joueur2.mAJScore(5);
        }

        themeFinal.remove(random);


        theme = themeFinal.get(0) ;

        System.out.println("\n C'est au tour du : ");
        joueur1.afficher();
        Question j13 = Liste.selectionnerQuestion(LQ,1,theme);
        j13.Afficher();
        boolean reponse13 = j13.Saisir();
        if(reponse13){
            joueur1.mAJScore(5);
        }

        System.out.println("\n C'est au tour du : ");
        joueur2.afficher();
        Question j23 = Liste.selectionnerQuestion(LQ,1,theme);
        j23.Afficher();
        boolean reponse23 = j23.Saisir();
        if(reponse23){
            joueur2.mAJScore(5);
        }

        System.out.println("La phase 3 est terminé !");

    }
}
