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

public abstract class Question <T> {
    // Attributs d'une question
    String thémes ;
    int numéro;
    int difficulté;
    String type;
    String texte;
    T énoncé;

    //Constructeur par défault
    public Question() {};

    // Méthodes abstraite
    public abstract void Afficher();
    public abstract boolean  Saisir();
    public abstract void AffichageListe();
    public  abstract  String GenererTxtString(); // permet de générer une ligne à ajouter ou supprimer dans le fichier de sauvegarde en .txt




}
