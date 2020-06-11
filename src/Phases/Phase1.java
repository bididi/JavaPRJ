package Phases;

import Joueurs.Joueur;
import Questions.ListeQuestions;
import Questions.Question;
import Questions.Themes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Phase1 implements Phase {
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

    //Création du chronomètre du joueur 3
    private long chr3 = 0;
    javax.swing.Timer chronoJ3 = new javax.swing.Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            chr3++;
        }
    });

    //Création du chronomètre du joueur 4
    private long chr4 = 0;
    javax.swing.Timer chronoJ4 = new javax.swing.Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            chr4++;
        }
    });

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
        if (sc3 <= petit){
            if (sc3 == petit){
                if (chr3> chronoPetit){
                    petit = sc3;
                    chronoPetit = chr3;
                    elimine = joueur3;
                }
            }else {
                petit = sc3;
                elimine = joueur3;
                chronoPetit = chr3;
            }
        }
        if (sc4 <= petit){
            if(sc4 == petit){
                if (chr4 > chronoPetit){
                    petit = sc4;
                    elimine = joueur4;
                    chronoPetit = chr4;
                }
            }else {
                petit = sc4;
                elimine = joueur4;
                chronoPetit = chr4;
            }
        }

        //On affiche tous les joueur, leurs score ainsi que leurs chronos
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ les différents scores ~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Pseudo : "+joueur1.getpseudo()+", Score : "+joueur1.getScore()+", chrono : "+ chr1);
        System.out.println("Pseudo : "+joueur2.getpseudo()+", Score : "+joueur2.getScore()+", chrono : "+ chr2);
        System.out.println("Pseudo : "+joueur3.getpseudo()+", Score : "+joueur3.getScore()+", chrono : "+ chr3);
        System.out.println("Pseudo : "+joueur4.getpseudo()+", Score : "+joueur4.getScore()+", chrono : "+ chr4);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

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
        System.out.println("\n");

        System.out.println("██████╗ ██╗  ██╗ █████╗ ███████╗███████╗     ██╗\n" +
                "██╔══██╗██║  ██║██╔══██╗██╔════╝██╔════╝    ███║\n" +
                "██████╔╝███████║███████║███████╗█████╗      ╚██║\n" +
                "██╔═══╝ ██╔══██║██╔══██║╚════██║██╔══╝       ██║\n" +
                "██║     ██║  ██║██║  ██║███████║███████╗     ██║\n" +
                "╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝     ╚═╝\n" +
                "                                                ");

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


        //
        System.out.println("\n C'est au tour de : ");
        joueur1.afficher();
        String theme = test.SelectionnerTheme();
        Question j1 = Liste.selectionnerQuestion(LQ,1,theme);
        j1.Afficher();
        temps.start();

        boolean reponse = j1.Saisir();
        if(reponse){
            joueur1.mAJScore(2);
        }
        temps.stop();


        System.out.println("\n C'est au tour de : ");
        joueur2.afficher();
        String theme2 = test.SelectionnerTheme();
        Question j2 = Liste.selectionnerQuestion(LQ,1,theme2);
        j2.Afficher();
        chronoJ2.start();
        boolean reponse2 = j2.Saisir();
        if(reponse2){
            joueur2.mAJScore(2);
        }
        chronoJ2.stop();


        System.out.println("\n C'est au tour de : ");
        joueur3.afficher();
        String theme3 = test.SelectionnerTheme();
        Question j3 = Liste.selectionnerQuestion(LQ,1,theme3);
        j3.Afficher();
        chronoJ3.start();
        boolean reponse3 = j3.Saisir();
        if(reponse3){
            joueur3.mAJScore(2);
        }
        chronoJ3.stop();



        System.out.println("\n C'est au tour de : ");
        joueur4.afficher();
        String theme4 = test.SelectionnerTheme();
        Question j4 = Liste.selectionnerQuestion(LQ,1,theme4);
        j4.Afficher();
        chronoJ4.start();
        boolean reponse4 = j4.Saisir();
        if(reponse4){
            joueur4.mAJScore(2);
        }
        chronoJ4.stop();


    }
}
