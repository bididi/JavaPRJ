import java.util.Scanner;

public class Joueur {
    int numJoueur = 0;
    String pseudo;
    int score;
    String etat;


    public Joueur(String pseudo){
        this.numJoueur = numJoueur++;
        this.pseudo = pseudo;
        this.score = 0;
        this.etat = " ";
    }
    public String saisir(){
        Scanner input = new Scanner(System.in);
        String réponse = input.next();
        return réponse;

    }
    public void afficher(){

    }
    public void mAJScore(){
        this.score =

    }
    public void changerEtat(){

    }
}
