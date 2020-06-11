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
package Phases;

import java.io.IOException;
import java.util.Vector;

public interface Phase {
    public Vector selectionnerJoueurs(Vector select);
    public void phasedeJeu(Vector select) throws IOException, ClassNotFoundException;
}