package Questions;

import com.sun.javaws.exceptions.ExitException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListeQuestions {



    public void afficherListe(List<Question> listeQuestions){
        Question question = null;
        System.out.println("Numéro   Thème   Type   Texte   Réponse   Autre proposition(si QCM)   Autre proposition(si QCM)   Autre proposition(si QCM)");
        for(int i = 0 ; i < listeQuestions.size(); i++){
            question = listeQuestions.get(i);
            question.AffichageListe();
        }


    }
    public void ajouterQuestion(List listeQuestions)throws IOException{
        int difficulte;
        String theme;
        String type;
        String texte;
        String reponse;
        String autreProp1="";
        String autreProp2="";
        String autreProp3="";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Quel type de question voulez vous ajoutez (QCM,VF,RC) ?");
        type = keyboard.nextLine();
        if (type != "QCM" && type != "VF" && type != "RC" ) {
            System.out.println("Type de question inexistant");
            System.exit(1);
        }
        System.out.println("Quel difficulte ?");
        difficulte = keyboard.nextInt();
        System.out.println("Quel est le theme ?");
        theme = keyboard.nextLine();
        System.out.println("Quel est l'énoncé ?");
        texte = keyboard.nextLine();
        System.out.println("Quel est la réponse ?");
        reponse = keyboard.nextLine();
        if (type=="QCM"){
            System.out.println("Autre proposition :");
            autreProp1 = keyboard.nextLine();
            System.out.println("Autre proposition :");
            autreProp2 = keyboard.nextLine();
            System.out.println("Autre proposition :");
            autreProp3 = keyboard.nextLine();
        }


        Writer outpout;
        outpout = new BufferedWriter(new FileWriter("src/Questions/questions.txt",true));
        outpout.append(difficulte+";"+theme+";"+type+";"+texte+";"+reponse+";"+autreProp1+";"+autreProp2+";"+autreProp3);

    }
    public void supprimerQustion(Question question)throws IOException{

        File inputFile = new File("src/Questions/questions.txt");
        File tempFile = new File("src/Questions/temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = question.GenererTxtString();
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // ligne à sauter
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
    }
    public void selectionnerQuestion(List listeQuestions){

    }
    public List openfile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/Questions/questions.txt"));
        String line = "";

        List<Question> questions = new ArrayList<Question>(); // création d'une liste de questions
        int numero = 1; // initialisation du numéro de question


        while ((line = in.readLine()) != null) {
            // Afficher le contenu du fichier
            //System.out.println(line); // test de lecture
            String[] data = line.split(";"); // data[0] : difficulte, data[1] : theme, data[2] : type de question, data[3] : énoncé, data[4] : réponse 1
            String type = data[2];
           // System.out.println(type); //test type
            if(type.equals("VF")){
                Question newVF = new VF(Integer.parseInt(data[0]), data[1], data[3], Boolean.parseBoolean(data[4]), numero); // Création d'un objet question
                questions.add(newVF); // Ajout de l'objet question à la liste des questions
            }else if(type.equals("RC")){
                Question newRC = new RC(Integer.parseInt(data[0]), data[1], data[3], data[4], numero); // Création d'un objet question
                questions.add(newRC); // Ajout de l'objet question à la liste des questions
            }else if(type.equals("QCM")){
                Question newQCM = new QCM(Integer.parseInt(data[0]), data[1], data[3], data[4], data[5], data[6], data[7], numero); // Création d'un objet question
                questions.add(newQCM); // Ajout de l'objet question à la liste des questions
            }

            numero++; // incrément du numéro de question
        }
        System.out.println("\n\n");
        //System.out.println(questions.get(3).texte); // test attribut d'un objet
        in.close();
        return  questions;


    }

}
