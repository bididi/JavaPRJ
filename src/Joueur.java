import java.util.Scanner;

public class Joueur implements Phase {
    int numJoueur = 100;
    String pseudo;
    int score;
    String etat;

    //Création d'un joueur
    public Joueur(String pseudo){
        this.numJoueur = numJoueur+10;
        this.pseudo = pseudo;
        this.score = 0;
        this.etat = " ";
    }
    //récupération d'une saisi par un joueur
    public String saisir(){
        Scanner input = new Scanner(System.in);
        String réponse = input.next();
        return réponse;

    }

    public void afficher(){
        System.out.println("nom du joueur :"+ this.pseudo + "numéro du joueur : "+ this.numJoueur + "Score : "+ this.score + "Statut :" + this.etat);

    }

    // Mise à jour du score d'un joueur
    public void mAJScore(){

    }

    // mise à jour de l'état du joueur
    public void changerEtat(String statut){
        this.etat = statut;
    }
}
