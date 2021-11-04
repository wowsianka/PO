package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class MapDirectionTest {

    @Test
    public void testNext(){
        Assertions.assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        Assertions.assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        Assertions.assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        Assertions.assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }
    @Test
    public void testPrevious(){
        Assertions.assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        Assertions.assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        Assertions.assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        Assertions.assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
    }
}
