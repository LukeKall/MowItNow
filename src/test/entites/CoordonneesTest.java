package test.entites;

import main.entites.Coordonnees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordonneesTest {

    @Test
    public void testEquals(){
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Coordonnees coordonnees2 = new Coordonnees(1, 2);

        assertFalse(coordonnees.equals(null));
        assertFalse(coordonnees.equals("test"));
        assertTrue(coordonnees.equals(coordonnees2));
        assertTrue(coordonnees2.equals(coordonnees));

        coordonnees2.setX(2);
        assertFalse(coordonnees2.equals(coordonnees));
        coordonnees2.setX(1);
        coordonnees2.setY(3);
        assertFalse(coordonnees2.equals(coordonnees));
    }
}
