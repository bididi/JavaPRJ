/**
 *-----Headers-----
 *Projet java-L3
 *
 *GABROT Jules
 *GUEURET Elodie
 *EXCOFFIER Serge
 *GONNOT Vianney
 *GAILHAC Louis
 */
package Joueurs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class EnsJoueurs {
    Vector joueurs;
    Joueur joueuraffiche;

    ArrayList<String> jpseudo = new ArrayList<>();
    ArrayList<Integer> dejaJoue = new ArrayList<>();


    //constructeur du vecteur qui va contenir tous les joueur
    public EnsJoueurs(int nb){
        //initialisation de notre vecteur
         joueurs = new Vector(20);

         // maintenant nous allons créer tous les joueurs demandé.
         creer(nb);

    }


    // Création des joueurs
    public void creer(int nb){
        // Création d'une liste qui vas contenir tous les pseudo de A à Z
        char alpha;
        for(alpha = 'A'; alpha <= 'Z'; alpha++)
        {
            jpseudo.add(String.valueOf(alpha));
        }
        // Fin de la création des pseudo


        int fin=nb;
        //Création d'une liste qui contiendra tous les joueurs
        Joueur[] j = new Joueur[fin];
        // initialisation du numéro de joueur
        int numJ = 100;

        //
        for(int i=0; i< fin; i++){
            j[i] = new Joueur(jpseudo.get(i),numJ );
            joueurs.addElement(j[i]);
            numJ= numJ+10;
        }

    }


    public void afficher(){
        // Affichage de tous les joueurs du vecteur
        for(int i =0; i<joueurs.size(); i++){
            joueuraffiche = (Joueur) joueurs.elementAt(i);
            joueuraffiche.afficher();
        }

    }



    // Sélection d'un joueur au hasard dans le vecteur
    public Joueur selectionnerJoueur(){

        // On crée une liste qui contient tous les indexs, qui indique des joueurs n'ayant pas joué, dans notre vecteur
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i< joueurs.size(); i++){
           if(!dejaJoue.contains(i)) {
               index.add(i);
           }
        }

        // Sélection d'un premier Joueurs.Joueur//

        //On prendre un nombre au hasard entre 0 et la taille de notre liste index
        int random = (int)(Math.random() * ((index.size()-1) + 1));

        // Le joueur 1 devient le joueur qui à pour index le nombre "random"
        Joueur joueur1 = (Joueur) joueurs.elementAt(index.get(random));

        // ON ajoute l'index sélectionné dans la liste dejajoue
        dejaJoue.add(index.get(random));

        //On retire l'index déjà utilisé de la liste index
        index.remove(random);

        //On change l'état du joueur de en attente à sélectionné
        joueur1.changerEtat("sélectionné");

        return joueur1;
    }
}
