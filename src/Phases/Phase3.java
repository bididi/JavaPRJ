package Phases;

import Joueurs.Joueur;
import Phases.Phase;
import Questions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Phase3 implements Phase {
    // Création du chronomètre du joueur 1
    private long chr1 = 0;
    javax.swing.Timer temps = new javax.swing.Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            chr1++;
        }
    });

    //Création du chronomètre du joueur 2
    private long chr2 = 0;
    javax.swing.Timer chronoJ2 = new javax.swing.Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            chr2++;
        }
    });

    @Override
    public Vector selectionnerJoueurs(Vector select) {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);

        Joueur elimine = joueur1;
        Joueur gagnant = joueur2;

        int sc1 = joueur1.getScore();
        int sc2 = joueur2.getScore();

        int petit = sc1;
        long chronoPetit = chr1;

        // On compare tous les score pour trouver le plus faible
        // En cas d'égalité le temps vas les départager
        if (sc2 <= petit){
            if(sc2 == petit){
                if(chr2>chronoPetit){
                    petit = sc2;
                    chronoPetit = chr2;
                    elimine = joueur2;
                }
            }else {
                petit = sc2;
                elimine = joueur2;
                chronoPetit = chr2;
            }
        }

        //On affiche tous les joueur, leurs score ainsi que leurs chronos
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ les différents scores ~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Pseudo : "+joueur1.getpseudo()+", Score : "+joueur1.getScore()+", chrono : "+ chr1);
        System.out.println("Pseudo : "+joueur2.getpseudo()+", Score : "+joueur2.getScore()+", chrono : "+ chr2);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // On change l'état du joueur ayant le score le plus faible
        elimine.changerEtat("éliminé");

        gagnant.changerEtat("gagnant");

        select.remove(elimine);

        System.out.println("\nLe joueur "+ elimine.getpseudo()+" a été eliminé");

        return select;

    }

    @Override
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException {
        System.out.println("------------------------------------------------------");
        System.out.println("--                    Phase 3                       --");
        System.out.println("------------------------------------------------------");
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
        Question j1 = Liste.selectionnerQuestion(LQ,3,theme);
        j1.Afficher();
        temps.start();
        boolean reponse = j1.Saisir();
        if(reponse){
            joueur1.mAJScore(5);
        }
        temps.stop();

        System.out.println("\n C'est au tour du : ");
        joueur2.afficher();
        Question j2 = Liste.selectionnerQuestion(LQ,3,theme);
        j2.Afficher();
        chronoJ2.start();
        boolean reponse2 = j2.Saisir();
        if(reponse2){
            joueur2.mAJScore(5);
        }
        chronoJ2.stop();

        themeFinal.remove(random);

        random = (int) (Math.random() * ((themeFinal.size()-1 ) +1));
        theme = themeFinal.get(random) ;

        System.out.println("\n C'est au tour du : ");
        joueur1.afficher();
        Question j12 = Liste.selectionnerQuestion(LQ,3,theme);
        j12.Afficher();
        temps.start();
        boolean reponse12 = j12.Saisir();
        if(reponse12){
            joueur1.mAJScore(5);
        }
        temps.stop();

        System.out.println("\n C'est au tour du : ");
        joueur2.afficher();
        Question j22 = Liste.selectionnerQuestion(LQ,3,theme);
        j22.Afficher();
        chronoJ2.start();
        boolean reponse22 = j22.Saisir();
        if(reponse22){
            joueur2.mAJScore(5);
        }
        chronoJ2.stop();

        themeFinal.remove(random);


        theme = themeFinal.get(0) ;

        System.out.println("\n C'est au tour du : ");
        joueur1.afficher();
        Question j13 = Liste.selectionnerQuestion(LQ,3,theme);
        j13.Afficher();
        temps.start();
        boolean reponse13 = j13.Saisir();
        if(reponse13){
            joueur1.mAJScore(5);
        }
        temps.stop();

        System.out.println("\n C'est au tour du : ");
        joueur2.afficher();
        Question j23 = Liste.selectionnerQuestion(LQ,3,theme);
        j23.Afficher();
        chronoJ2.start();
        boolean reponse23 = j23.Saisir();
        if(reponse23){
            joueur2.mAJScore(5);
        }
        chronoJ2.stop();

        System.out.println("La phase 3 est terminé !");

    }
}
