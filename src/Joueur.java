import java.util.Scanner;

public class Joueur {
    int numJoueur = 0;
    String pseudo;
    int score;
    String etat;

//Création d'un joueur
    public Joueur(String pseudo){
        this.numJoueur = numJoueur++;
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

    }
    // Mise à jour du score d'un joueur
    public void mAJScore(){

    }

    // mise à jour de l'état du joueur
    public void changerEtat(String statut){
        this.etat = statut;
    }
}
