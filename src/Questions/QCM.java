package Questions;

import javax.swing.*;

public class QCM extends Question {
    String texte;
    String repPropose1;
    String repPropose2;
    String repPropose3;
    String bonneRep;


    public void Afficher(){
        JFrame frame = new JFrame("Question");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel énoncé = new JLabel(texte);
        frame.add(énoncé);

    };
    public void  Saisir(){

    };

    public static void main(String[] args){
        System.out.println("test");
        QCM A = new QCM();
        A.texte="aaa";
        A.Afficher();

    }
}
