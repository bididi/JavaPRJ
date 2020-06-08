package Questions;

import javax.swing.*;

public class QCM extends Question {
    //Attributs d'un QCM
    public String texte;
    String repPropose1;
    String repPropose2;
    String repPropose3;
    String bonneRep;



    //Affichage de la question
    public void Afficher(){
        JFrame frame = new JFrame("Question");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel énoncé = new JLabel(texte);
        frame.add(énoncé);

    };
    //Traitement de la réponse
    public void  Saisir(){

    };


}
