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
package Questions;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class QCM extends Question {
    //Attributs d'un QCM

    String bonneRep;
    String autreRep1;
    String autreRep2;
    String autreRep3;

    public  QCM(int difficulte_, String theme_, String texte_, String bonneRep_, String rep1, String rep2, String rep3, int numero_) {
        super();
        this.thémes = theme_;
        this.numéro = numero_;
        this.difficulté = difficulte_;
        this.texte = texte_;
        this.bonneRep = bonneRep_;
        this.type = "QCM";
        this.autreRep1=rep1;
        this.autreRep2=rep2;
        this.autreRep3=rep3;

    }

    public void AffichageListe(){ // méthode utliser pour afficher la question dans la liste des questions
        System.out.println(this.numéro+ "   " + this.thémes + "   " + this.type+ "   " + this.texte + "   " + this.bonneRep + "   " + this.autreRep1 + "   " + this.autreRep2 + "   " + this.autreRep3);
    }
    //Affichage de la question
    public void Afficher(){
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(4) + 1;
        System.out.println("Question :");
        System.out.println(texte);

    };
    //Traitement de la réponse
    public boolean  Saisir(){
        System.out.println("Propositions :");
        System.out.println("a." + bonneRep);
        System.out.println("b." + autreRep3);
        System.out.println("c." + autreRep1);
        System.out.println("d." + autreRep2);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Veuillez entrer a, b, c ou d :");
        String saisie = keyboard.nextLine();
        String rep="";
        if (!saisie.equals("a") && !saisie.equals("b") && !saisie.equals("c") && !saisie.equals("d")  ) {
            while (!saisie.equals("a") && !saisie.equals("b") && !saisie.equals("c") && !saisie.equals("d") ){
                System.out.println("veuillez répondre par a, b, c ou d :");
                saisie = keyboard.nextLine();
            }

        }
        if(saisie.equals("a")){ rep = bonneRep ;}
        if(saisie.equals("b")){ rep = autreRep3 ;}
        if(saisie.equals("c")){ rep = autreRep1 ;}
        if(saisie.equals("d")){ rep = autreRep2 ;}
        if (rep.equals(this.bonneRep)) return true;
        return false;
    };

    public String GenererTxtString(){
        return (this.difficulté+";"+this.thémes+";"+this.type+";"+this.texte+";"+this.bonneRep+";"+this.autreRep1+";"+this.autreRep2+";"+this.autreRep3);
    }
}
