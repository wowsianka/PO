package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void testOrientation(){
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(testAnimal.toString(), "(2,2):Wschód");
        testAnimal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(testAnimal.toString(), "(2,2):Południe");
        testAnimal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(testAnimal.toString(), "(2,2):Zachód");
        testAnimal.move(MoveDirection.LEFT);
        Assertions.assertEquals(testAnimal.toString(), "(2,2):Południe");

    }
    @Test
    public void testPosition(){
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Północ");
        testAnimal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Wschód");
        testAnimal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(testAnimal.toString(), "(3,3):Wschód");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Wschód");
        testAnimal.move(MoveDirection.RIGHT);
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Południe");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,4):Południe");

    }

    @Test
    public void testOutsideMap(){
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Północ");
        testAnimal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,4):Północ");
        testAnimal.move(MoveDirection.FORWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,4):Północ");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,3):Północ");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,2):Północ");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,1):Północ");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,0):Północ");
        testAnimal.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(testAnimal.toString(), "(2,0):Północ");

    }


}
