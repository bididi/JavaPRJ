package Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ListeQuestions {


    public void afficherListe(){

    }
    public void ajouterQuestion(){

    }
    public void supprimerQustion(){

    }
    public void selectionnerQuestion(){

    }
    public List chargerListe(){

        // ouverture/lecture du fichier contenant les questions
        String fileName = "data.txt";
        Scanner inputStream = null;
        System.out.println("Le fichier " + fileName + " contiens les lignes suivantes:\n");
        try
        {
            inputStream = new Scanner(new File("data.txt"));//Le .txt est lu correctement
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Impossible de trouver " + fileName); // erreur à l'ouverture
            System.exit(0);
        }

        List<Question> questions = new ArrayList<Question>();
        int numero = 1;
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            System.out.println(line);
            String[] data = line.split(";"); // data[0] : difficulte, data[1] : theme, data[2] : type de question, data[3] : énoncé, data[4] : réponse 1
            Question question = new VF(Integer.parseInt(data[0]), data[1], data[3], Boolean.parseBoolean(data[4]), numero);
            questions.add(question);
            numero++;
        }
        return  questions;

    }
}
