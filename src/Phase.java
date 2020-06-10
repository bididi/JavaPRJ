import java.io.IOException;
import java.util.Vector;

public interface Phase {
    public Vector selectionnerJoueurs(Vector select);
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException;
}