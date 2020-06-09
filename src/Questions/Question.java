package Questions;

public abstract class Question <T> {
    // Attributs d'une question
    String thémes ;
    int numéro;
    int difficulté;
    T énoncé;

    //Constructeur par défault
    public Question() {};

    // Méthodes abstraite
    public abstract void Afficher();
    public abstract void  Saisir();


    // Méthodes

}
