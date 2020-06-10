package Questions;

import java.util.Scanner;

public class VF extends Question {

    boolean bonneRep;


    public  VF(int difficulte_, String theme_, String texte_, boolean bonneRep_, int numero_) {
        super();
        this.thémes = theme_;
        this.numéro = numero_;
        this.difficulté = difficulte_;
        this.texte = texte_;
        this.bonneRep = bonneRep_;
        this.type = "VF";

    }
    public void AffichageListe(){ // méthode utliser pour afficher la question dans la liste des questions
        System.out.println(this.numéro+ "   " + this.thémes + "   " + this.type+ "   " + this.texte+ "   " + this.bonneRep);
    }

    public void Afficher(){
        System.out.println("Question :");
        System.out.println(texte);
    };
    public boolean  Saisir(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Veuillez entrer vrai si la réponse est vrai et faux si la réponse est faux :");
        String saisie = keyboard.nextLine();
        boolean rep;
        if (!saisie.equals("vrai") && !saisie.equals("faux")  ) {
            while (!saisie.equals("vrai") && !saisie.equals("faux")){
                System.out.println("veuillez répondre par vrai ou faux :");
                saisie = keyboard.nextLine();
            }

        }
        if(saisie.equals("vrai")){ rep = true ;}
        else {rep = false;}
        if (rep == this.bonneRep) return true;
        return false;


    };
    public String GenererTxtString(){
        return (this.difficulté+";"+this.thémes+";"+this.type+";"+this.texte+";"+this.bonneRep+";"+";"+";");
    }

}
