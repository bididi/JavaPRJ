package Questions;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Themes {
    // Initialisation des listes
    ArrayList<String>liste;
    ArrayList<String>ThemeSelect = new ArrayList();
    ArrayList<String>ThemeSelectnow = new ArrayList();
    ArrayList<String>ThemeSixSelect = new ArrayList();

    public Themes(ArrayList<String>liste) {
        this.liste = liste ;
    }



    public void serialiserListe(String name_File) throws IOException
    {
        // ecriture d'une copie dans un fichier .txt
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(name_File + ".txt")) ;

    output.writeObject(this.liste);

    output.close();
}


// Créer la liste des 10 thèmes et créer la copie.txt

    public void initialisation() throws IOException, ClassNotFoundException
    {
        // On vide les liste pour $etre sur de n'avoir que les 10 Thèmes souhaiter
        this.ThemeSelect.clear();
        this.ThemeSelectnow.clear();
        this.liste.clear();

        // Ajout des thèmes
        liste.add("Geographie");
        liste.add("Science");
        liste.add("Sport");
        liste.add("Art");
        liste.add("CINEMA");
        liste.add("HISTOIRE");
        liste.add("LANGUE");
        liste.add("LES REPTILES");
        liste.add("LES VACCINS");
        liste.add("INFORMATIQUE");
        // permet de créer une copie de la liste des thèmes avec pour paramètre le nom
        serialiserListe("Themes");
    }

public void deserialiserListe(String name_File) throws IOException, ClassNotFoundException
{

    ObjectInputStream in = new ObjectInputStream(new FileInputStream(name_File + ".txt"));

    this.liste = (ArrayList<String>) in.readObject();

    in.close();
}





// Permet de modifier un theme dans la liste

public void ModifierTheme(int emplacement, String newTheme) throws IOException
{
    this.liste.set(emplacement,newTheme);

    serialiserListe("Themes");
}

    int index = 0 ;
// Selectionne aléatoirement un thème dans la liste

public String SelectionnerTheme() throws IOException, ClassNotFoundException {
    String theme = null;
// Si 10 thèmes selectionnés la liste des thèmes selectionnés est remise à 0
    if (index == 10)
    {
        Afficher();
        initialisation();
        index = 0 ;
        SelectionnerTheme();
    }

    else{
    // Selection aléatoire des thèmes

    ThemeSelectnow.clear();

    int nbrAle = (int) (Math.random() * ((liste.size()-1 ) +1));
    ThemeSelect.add(liste.get(nbrAle));
    theme = liste.get(nbrAle);
    // Ajout à la liste qui permet de connaitre le thèmes selctionner en dernier
    ThemeSelectnow.add(liste.get(nbrAle));
    liste.remove((nbrAle));
    index++;
    }
    return theme;

}

// selectionne aléatoirement 5 thèmes différents dans la liste

public ArrayList<String> SelectionnerCinqThemes() throws IOException, ClassNotFoundException {

   // On vide la liste pour obtenir seulement le dernier thème selectionné
    ThemeSelectnow.clear();
    // Boucle qui permet de selectionnés 6Thèmes aleatoirement
    for (int i = 0; i<6 ; i++)
    {
        // Selection aléatoire dans la liste
        int nbrAle = (int) (Math.random() * ((liste.size()-1 ) +1));
        ThemeSelect.add(liste.get(nbrAle));
        // Liste du thèmes selectionné en dernier
        ThemeSelectnow.add(liste.get(nbrAle));
        ThemeSixSelect.add(liste.get(nbrAle));
        liste.remove((nbrAle));
        index++;
    }

    return ThemeSixSelect ;

}

// affiche la liste des thèmes choisi et les thèmes restant si l'on veut re-selectionner
public void Afficher(){

    int j=0;
// Boucle pour afficher tous les éléments de la liste
    while(j<liste.size())
    {
        System.out.println(liste.get(j));
        j++;


    }
    //Affichage des thèmes disponible et des thèmes déja selectionnés
    System.out.println("les thèmes déja sélectionés sont" + ThemeSelect);
    System.out.println("le thèmes choisi est" + ThemeSelectnow);

}



    }
