import Questions.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Phase2 implements Phase {
    @Override
    public Vector selectionnerJoueurs(Vector select) {

        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);

        Joueur elimine = joueur1;

        int sc1 = joueur1.getScore();
        int sc2 = joueur2.getScore();
        int sc3 = joueur3.getScore();

        int petit = sc1;

        if (sc2 < petit){
            petit = sc2;
            elimine = joueur2;
        }
        if (sc3 < petit){
            petit = sc3;
            elimine = joueur3;
        }
        // On change l'état du joueur ayant le score le plus faible
        elimine.changerEtat("éliminé");

        System.out.println("\nLe joueur "+ elimine.getpseudo()+" a été eliminé");

        select.remove(elimine);


        return select;

    }

    @Override
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException {
        Joueur joueur1 = (Joueur) select.elementAt(0);
        Joueur joueur2 = (Joueur) select.elementAt(1);
        Joueur joueur3 = (Joueur) select.elementAt(2);

        ArrayList liste = new ArrayList();


        Themes test = new Themes(liste);
        test.initialisation();
        test.serialiserListe("Themes");

        // Générer la liste de questions
        ListeQuestions Liste = new ListeQuestions();
        List<Question> LQ = Liste.openfile();// on peut aussi faire LQ =Liste.liste;

        ArrayList liste6Themes = test.SelectionnerCinqThemes();


        System.out.println("\n C'est au tour de : ");
        joueur1.afficher();

        System.out.println("Les thèmes que vous pouvez choisir");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }
        Scanner scan = new Scanner(System.in);
        int themeselect;
        String selectTheme;
        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j1 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j1.Afficher();
        boolean reponse1 = j1.Saisir();
        if(reponse1){
            joueur1.mAJScore(2);
        }
        liste6Themes.remove(themeselect-1);



        System.out.println("\n C'est au tour de : ");
        joueur2.afficher();

        System.out.println("Les thèmes que vous pouvez choisir");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j2 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j2.Afficher();
        boolean reponse2 = j2.Saisir();
        if(reponse2){
            joueur2.mAJScore(2);
        }
        liste6Themes.remove(themeselect-1);



        System.out.println("\n C'est au tour de : ");
        joueur3.afficher();

        System.out.println("Les thèmes que vous pouvez choisir");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j3 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j3.Afficher();
        boolean reponse3 = j3.Saisir();
        if(reponse3){
            joueur3.mAJScore(2);
        }
        liste6Themes.remove(themeselect-1);



        System.out.println("\n C'est au tour de : ");
        joueur1.afficher();

        System.out.println("Les thèmes que vous pouvez choisir");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j12 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j12.Afficher();
        boolean reponse12 = j12.Saisir();
        if(reponse12){
            joueur1.mAJScore(2);
        }
        liste6Themes.remove(themeselect-1);


        System.out.println("\n C'est au tour de : ");
        joueur2.afficher();

        System.out.println("Les thèmes que vous pouvez choisir");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j22 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j22.Afficher();
        boolean reponse22 = j22.Saisir();
        if(reponse22){
            joueur2.mAJScore(2);
        }
        liste6Themes.remove(themeselect-1);



        System.out.println("\n C'est au tour de : ");
        joueur3.afficher();

        System.out.println("Les thèmes que vous pouvez choisir");

        for(int i = 1; i<=liste6Themes.size(); i++){
            System.out.println(i +") "+liste6Themes.get(i-1));
        }

        System.out.println("\nSaisir 1 ou 2 ou 3 jusqu'a 6 en fonction du thème sélectionné ");
        themeselect = scan.nextInt();

        selectTheme = (String) liste6Themes.get(themeselect-1 );


        Question j32 = Liste.selectionnerQuestion(LQ,2,selectTheme);
        j32.Afficher();
        boolean reponse32 = j32.Saisir();
        if(reponse32){
            joueur3.mAJScore(2);
        }
        liste6Themes.remove(themeselect-1);

        System.out.println("\nFin de la phase 2 !");

    }
}
