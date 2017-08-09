package test.entites;


import main.entites.Orientation;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {

    @Test
    public void testGetRight(){
        Map<Orientation, Orientation> correspondances = new HashMap<>();
        correspondances.put(Orientation.EAST, Orientation.SOUTH);
        correspondances.put(Orientation.NORTH, Orientation.EAST);
        correspondances.put(Orientation.SOUTH, Orientation.WEST);
        correspondances.put(Orientation.WEST, Orientation.NORTH);

        for(Orientation orientation : Orientation.values()){
            assertEquals(correspondances.get(orientation), orientation.getRight());
        }
    }

    @Test
    public void testGetLeft(){
        Map<Orientation, Orientation> correspondances = new HashMap<>();
        correspondances.put(Orientation.EAST, Orientation.NORTH);
        correspondances.put(Orientation.NORTH, Orientation.WEST);
        correspondances.put(Orientation.SOUTH, Orientation.EAST);
        correspondances.put(Orientation.WEST, Orientation.SOUTH);

        for(Orientation orientation : Orientation.values()){
            assertEquals(correspondances.get(orientation), orientation.getLeft());
        }
    }
}
