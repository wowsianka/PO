package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Vactor2dTest {
    @Test
    public void testEquals(){
       Assertions.assertTrue(new Vector2d(1,1).equals(new Vector2d(1,1)));
       Assertions.assertTrue(new Vector2d(-1,-1).equals(new Vector2d(-1,-1)));

    }

    @Test
    public void testToString(){
        Assertions.assertEquals(new Vector2d(1,1).toString(), "(1,1)");
        Assertions.assertEquals(new Vector2d(-1,-1).toString(), "(-1,-1)");
    }

    @Test
    public void testPrecedes(){
        Assertions.assertTrue(new Vector2d(1,1).precedes(new Vector2d(0,0)));
    }

    @Test
    public void testFollows(){
        Assertions.assertTrue(new Vector2d(1,1).follows(new Vector2d(2,2)));
    }

    @Test
    public void testUpperRight(){
        Assertions.assertEquals(new Vector2d(1,3).upperRight(new Vector2d(2,1)), new Vector2d(2,3));
    }

    @Test
    public void testLowerLeft(){
        Assertions.assertEquals(new Vector2d(1,3).lowerLeft(new Vector2d(2,1)), new Vector2d(1,1));
    }

    @Test
    public void testAdd(){
        Assertions.assertEquals(new Vector2d(1,-3).add(new Vector2d(2,1)), new Vector2d(3,-2));
    }

    @Test
    public void testSubstract(){
        Assertions.assertEquals(new Vector2d(1,-3).substract(new Vector2d(2,1)), new Vector2d(-1,-4));
    }

    @Test
    public void testOpposite(){
        Assertions.assertEquals(new Vector2d(1,-3).opposite(), new Vector2d(-1,3));
    }
}
