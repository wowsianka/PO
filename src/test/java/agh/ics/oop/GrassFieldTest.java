package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GrassFieldTest {
    @Test
    public void animalMovementTest(){
        String[] args={"f", "b" , "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Animal> animals = engine.getAnimals();
        Assertions.assertEquals(animals.get(0).getPosition(), new Vector2d(2,3));
        Assertions.assertEquals(animals.get(1).getPosition(), new Vector2d(3,3));

        Assertions.assertEquals(animals.get(0).getOrientation(), MapDirection.EAST);
        Assertions.assertEquals(animals.get(1).getOrientation(), MapDirection.WEST);
    }

    @Test
    public void shouldnNotPlaceAnimalsOnSamePosition(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    String[] args = {"f", "f", "r", "l"};
                    MoveDirection[] directions = new OptionsParser().parse(args);
                    GrassField map = new GrassField(10);
                    Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
                    SimulationEngine engine = new SimulationEngine(directions, map, positions);
                    engine.run();
        });
        String expectedMessage = "(2,2) is occupied";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    public void checkIfAnimalWasAddedToAnimalsList(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,3));
        map.place(a);

        Assertions.assertTrue(map.getAnimals().containsValue(a));
    }

    @Test
    public void shouldBeAbleToMoveOutsideMap(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(1,1));
        map.place(a);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);
        a.move(MoveDirection.FORWARD);

        Assertions.assertEquals(a.getPosition(), new Vector2d(1,4));
    }

    @Test
    public void shouldNotMoveIfBlockedByOtherAnimal(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,3));
        Animal b = new Animal(map, new Vector2d(2,4));
        map.place(a);
        map.place(b);
        a.move(MoveDirection.FORWARD);


        Assertions.assertEquals(a.getPosition(), new Vector2d(2,3));
    }


    @Test
    public void placeAnimal(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,3));
        map.place(a);

        Assertions.assertTrue(map.getAnimals().containsValue(a));
    }
    @Test
    public void isOccupiedShouldReturnTrue(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,3));
        map.place(a);

        Assertions.assertTrue(map.isOccupied(new Vector2d(2 ,3)));
    }

    @Test
    public void isObjectAnAnimal(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,3));
        map.place(a);

        Assertions.assertEquals(a, map.objectAt(new Vector2d(2 ,3)) );
    }



}
