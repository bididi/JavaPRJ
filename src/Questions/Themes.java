package Questions;
import java.io.*;
import java.util.ArrayList;

public class Themes
{

ArrayList<String>liste;
ArrayList<String>ThemeSelect = new ArrayList();
ArrayList<String>ThemeSelectnow = new ArrayList();

public Themes(ArrayList<String>liste)
{

    this.liste = liste ;
}



    public void serialiserListe(String name_File) throws IOException
    {

    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(name_File + ".txt")) ;

    output.writeObject(this.liste);

    output.close();
}


// Créer la liste des 10 thèmes et créer la copie.txt

    public void initialisation() throws IOException, ClassNotFoundException
    {
        this.ThemeSelect.clear();
        this.ThemeSelectnow.clear();
        this.liste.clear();

        liste.add("Géographie");
        liste.add("Science");
        liste.add("Sport");
        liste.add("Art");
        liste.add("Cinema");
        liste.add("Histoire");
        liste.add("Langues");
        liste.add("Les reptiles");
        liste.add("Vaccins");
        liste.add("Informatiques");

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

public void SelectionnerTheme() throws IOException, ClassNotFoundException {

    if (index == 10)
    {
        Afficher();
        initialisation();
        index = 0 ;
        SelectionnerTheme();
    }

    else{

    ThemeSelectnow.clear();

    int nbrAle = (int) (Math.random() * ((liste.size()-1 ) +1));
    ThemeSelect.add(liste.get(nbrAle));
    ThemeSelectnow.add(liste.get(nbrAle));
    liste.remove((nbrAle));
    index++;
    }

}
// selectionne aléatoirement 5 thèmes différents dans la liste

public void SelectionnerCinqThemes() throws IOException, ClassNotFoundException {
    for (int i = 0; i<5 ; i++)
    {


        int nbrAle = (int) (Math.random() * ((liste.size()-1 ) +1));
        ThemeSelect.add(liste.get(nbrAle));
        ThemeSelectnow.add(liste.get(nbrAle));
        liste.remove((nbrAle));
        index++;
    }
}

// affiche la liste des thèmes choisi et les thèmes restant si l'on veut re-selectionner
public void Afficher(){

    int j=0;

    while(j<liste.size())
    {
        System.out.println(liste.get(j));
        j++;


    }
    System.out.println("les thèmes déja sélectionés sont" + ThemeSelect);
    System.out.println("le thèmes choisi au tirage" + ThemeSelectnow);
}



    }
