package Questions;

public abstract class Question <T> {
    String[] thémes = new String[10];
    int numéro;
    int difficulté;
    T énoncé;
    public Question(){
    }
    public abstract void Afficher();
    public abstract void  Saisir();
}
