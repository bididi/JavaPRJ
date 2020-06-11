package Phases;

import Joueurs.Joueur;
import Phases.Phase;
import Questions.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Phase2 implements Phase {
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

    @Override
    public Vector selectionnerJoueurs(Vector select) {

        // On crée des variables pour les différents joueur du vecteur select
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);

        // initialisation d'une variable qui contiendra le joueur ayant le score le plus faible
        Joueur elimine = joueur1;

        int sc1 = joueur1.getScore();
        int sc2 = joueur2.getScore();
        int sc3 = joueur3.getScore();

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

        //On affiche tous les joueur, leurs score ainsi que leurs chronos
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ les différents scores ~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Pseudo : "+joueur1.getpseudo()+", Score : "+joueur1.getScore()+", chrono : "+ chr1);
        System.out.println("Pseudo : "+joueur2.getpseudo()+", Score : "+joueur2.getScore()+", chrono : "+ chr2);
        System.out.println("Pseudo : "+joueur3.getpseudo()+", Score : "+joueur3.getScore()+", chrono : "+ chr3);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // On change l'état du joueur ayant le score le plus faible
        elimine.changerEtat("éliminé");

        System.out.println("\nLe joueur "+ elimine.getpseudo()+" a été eliminé\n");

        select.remove(elimine);


        return select;

    }

    @Override
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException {
        // Création des différents joueurs présents dans notre vecteur select
        System.out.println("\n");
        System.out.println("██████╗ ██╗  ██╗ █████╗ ███████╗███████╗    ██████╗ \n" +
                "██╔══██╗██║  ██║██╔══██╗██╔════╝██╔════╝    ╚════██╗\n" +
                "██████╔╝███████║███████║███████╗█████╗       █████╔╝\n" +
                "██╔═══╝ ██╔══██║██╔══██║╚════██║██╔══╝      ██╔═══╝ \n" +
                "██║     ██║  ██║██║  ██║███████║███████╗    ███████╗\n" +
                "╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝    ╚══════╝\n" +
                "                                                    ");

        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);

        // Initialisation d'une liste
        ArrayList liste = new ArrayList();

        //Création de notre objet thème
        Themes test = new Themes(liste);
        // Initialisation de tous les thème
        test.initialisation();
        test.serialiserListe("Themes");

        // Générer la liste de questions
        ListeQuestions Liste = new ListeQuestions();
        List<Question> LQ = Liste.openfile();// on peut aussi faire LQ =Liste.liste;

        // Initialisation d'une liste qui contiendra nos 6 thèmes selectionné pour cette phase
        ArrayList liste6Themes = test.SelectionnerCinqThemes();


        // //////////////////////////C'est au tour du premier joueur/////////////////////////

        System.out.println("\n C'est au tour de : ");
        joueur1.afficher();

        // Affichage des diffèrents thèmes
        System.out.println("\n~~~~~~ Les thèmes que vous pouvez choisir ~~~~~~");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // On demande au joueur de choisir un des thèmes disponibles
        Scanner scan = new Scanner(System.in);
        int themeselect;
        String selectTheme;
        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();
        selectTheme = (String) liste6Themes.get(themeselect-1 );

        // On vas chercher une qustion correspondant au thème choisi
        Question j1 = Liste.selectionnerQuestion(LQ,2,selectTheme);

        //On affiche cette question
        j1.Afficher();

        // On lance le chrono du joueur 1
        temps.start();

        // Vérification de la réponse et implémentation du score en fonction.
        boolean reponse1 = j1.Saisir();
        if(reponse1){
            joueur1.mAJScore(3);
        }
        // Arret du chrono du joueur 1
        temps.stop();

        //On retire le thème de la liste
        liste6Themes.remove(themeselect-1);




        // //////////////////////////C'est au tour du deuxième joueur/////////////////////////
        //On fait la même chose que pour le premier joueur
        System.out.println("\n C'est au tour de : ");
        joueur2.afficher();

        System.out.println("\n~~~~~~ Les thèmes que vous pouvez choisir ~~~~~~");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j2 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j2.Afficher();
        chronoJ2.start();
        boolean reponse2 = j2.Saisir();
        if(reponse2){
            joueur2.mAJScore(3);
        }
        chronoJ2.stop();
        liste6Themes.remove(themeselect-1);



        // //////////////////////////C'est au tour du troisième joueur/////////////////////////

        System.out.println("\n C'est au tour de : ");
        joueur3.afficher();

        System.out.println("\n~~~~~~ Les thèmes que vous pouvez choisir ~~~~~~");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j3 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j3.Afficher();
        chronoJ3.start();
        boolean reponse3 = j3.Saisir();
        if(reponse3){
            joueur3.mAJScore(3);
        }
        chronoJ3.stop();
        liste6Themes.remove(themeselect-1);



        // //////////////////////////C'est au tour du premier joueur/////////////////////////

        System.out.println("\n C'est au tour de : ");
        joueur1.afficher();

        System.out.println("\n~~~~~~ Les thèmes que vous pouvez choisir ~~~~~~");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j12 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j12.Afficher();
        temps.start();
        boolean reponse12 = j12.Saisir();
        if(reponse12){
            joueur1.mAJScore(3);
        }
        temps.stop();
        liste6Themes.remove(themeselect-1);


        // //////////////////////////C'est au tour du deuxième joueur/////////////////////////

        System.out.println("\n C'est au tour de : ");
        joueur2.afficher();

        System.out.println("\n~~~~~~ Les thèmes que vous pouvez choisir ~~~~~~");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j22 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j22.Afficher();
        chronoJ2.start();
        boolean reponse22 = j22.Saisir();
        if(reponse22){
            joueur2.mAJScore(3);
        }
        chronoJ2.stop();
        liste6Themes.remove(themeselect-1);


        // //////////////////////////C'est au tour du troisième joueur/////////////////////////

        System.out.println("\n C'est au tour de : ");
        joueur3.afficher();

        System.out.println("\n~~~~~~ Les thèmes que vous pouvez choisir ~~~~~~");

        for(int i = 1; i<=liste6Themes.size(); i++) {
            System.out.println(i + ") " + liste6Themes.get(i - 1));
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j32 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j32.Afficher();
        chronoJ3.start();
        boolean reponse32 = j32.Saisir();
        if(reponse32){
            joueur3.mAJScore(3);
        }
        chronoJ3.stop();
        liste6Themes.remove(themeselect-1);

        System.out.println("\nFin de la phase 2 !");

    }
}
