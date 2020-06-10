package Questions ;

import java.util.Scanner;

public class RC extends Question {

    String bonneRep;



    public  RC(int difficulte_, String theme_, String texte_, String bonneRep_, int numero_) {
        super();
        this.thémes = theme_;
        this.numéro = numero_;
        this.difficulté = difficulte_;
        this.texte = texte_;
        this.bonneRep = bonneRep_;
        this.type = "RC";

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
        System.out.println("Veuillez entrer la réponse :");
        String saisie = keyboard.nextLine();

        if (saisie.equals(this.bonneRep)) return true;
        return false;


    };
    public String GenererTxtString(){
        return (this.difficulté+";"+this.thémes+";"+this.type+";"+this.texte+";"+this.bonneRep+";"+";"+";");
    }
}
