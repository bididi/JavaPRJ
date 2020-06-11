package Joueurs;

import java.util.Scanner;

public class Joueur {
    private int numJoueur;
    private String pseudo;
    private int score;
    private String etat;

    //Création d'un joueur
    public Joueur(String pseudo, int numJ){

        this.numJoueur = numJ;
        this.pseudo = pseudo;
        this.score = 0;
        this.etat = "en attente ";
    }


    //récupération d'une saisi par un joueur
    public String saisir(){
        Scanner input = new Scanner(System.in);
        String réponse = input.next();
        return réponse;
    }

    public void afficher(){
        System.out.println("nom du joueur : "+ pseudo + "  n°: "+ numJoueur + "  Score : "+ score + "  Statut : " + etat);
    }

    // Mise à jour du score d'un joueur
    public void mAJScore(int points){
        this.score = score + points;

    }

    public int getScore() {
        return score;
    }

    public String getpseudo(){
        return pseudo;
    }

    // mise à jour de l'état du joueur
    public void changerEtat(String statut){
        this.etat = statut;
    }
}
