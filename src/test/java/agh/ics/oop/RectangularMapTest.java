//package agh.ics.oop;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
//import java.util.LinkedList;
//import java.util.List;
//
//import agh.ics.oop.SimulationEngine;
//import agh.ics.oop.MoveDirection;
//import agh.ics.oop.Vector2d;
//import agh.ics.oop.Animal;
//import agh.ics.oop.OptionsParser;
//import agh.ics.oop.RectangularMap;
//
//
//
//public class RectangularMapTest {
//    @Test
//    public void animalMovementTest(){
//        String[] args={"f", "b" , "r", "l"};
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        RectangularMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        SimulationEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//
//        List<Animal> animals = engine.getAnimals();
//        Assertions.assertEquals(animals.get(0).getPosition(), new Vector2d(2,3));
//        Assertions.assertEquals(animals.get(1).getPosition(), new Vector2d(3,3));
//
//        Assertions.assertEquals(animals.get(0).getOrientation(), MapDirection.EAST);
//        Assertions.assertEquals(animals.get(1).getOrientation(), MapDirection.WEST);
//    }
//
//    @Test
//    public void shouldnNotPlaceAnimalsOnSamePosition(){
//        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            String[] args = {"f", "f", "r", "l"};
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            RectangularMap map = new RectangularMap(10, 5);
//            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 2)};
//            SimulationEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//        });
//        String expectedMessage = "(2,2) is occupied";
//        String actualMessage = exception.getMessage();
//
//        Assertions.assertTrue(actualMessage.contains(expectedMessage));
//
//    }
//
//
//    @Test
//    public void checkIfAnimalWasAddedToAnimalsList(){
//        RectangularMap map = new RectangularMap(10, 5);
//        Animal a = new Animal(map, new Vector2d(2,3));
//        map.place(a);
//
//        Assertions.assertTrue(map.getAnimals().containsValue(a));
//    }
//    @Test
//    public void shouldNotBeAbleToMoveOutsideMap(){
//        RectangularMap map = new RectangularMap(2, 2);
//        Animal a = new Animal(map, new Vector2d(1,1));
//        map.place(a);
//        a.move(MoveDirection.FORWARD);
//        a.move(MoveDirection.FORWARD);
//        a.move(MoveDirection.FORWARD);
//
//        Assertions.assertEquals(a.getPosition(), new Vector2d(1,2));
//    }
//
//    @Test
//    public void shouldNotMoveIfBlockedByOtherAnimal(){
//        RectangularMap map = new RectangularMap(10, 5);
//        Animal a = new Animal(map, new Vector2d(2,3));
//        Animal b = new Animal(map, new Vector2d(2,4));
//        map.place(a);
//        map.place(b);
//        a.move(MoveDirection.FORWARD);
//
//
//        Assertions.assertEquals(a.getPosition(), new Vector2d(2,3));
//    }
//
//
//    @Test
//    public void placeAnimal(){
//        String[] args={"r", "f" , "l"};
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        RectangularMap map = new RectangularMap(10, 5);
//        Animal a = new Animal(map, new Vector2d(2,3));
//        map.place(a);
//
//        Assertions.assertTrue(map.getAnimals().containsValue(a));
//    }
//    @Test
//    public void isOccupiedShouldReturnTrue(){
//        RectangularMap map = new RectangularMap(10, 5);
//        Animal a = new Animal(map, new Vector2d(2,3));
//        map.place(a);
//
//        Assertions.assertTrue(map.isOccupied(new Vector2d(2 ,3)));
//    }
//
//    @Test
//    public void isObjectAnAnimal(){
//        RectangularMap map = new RectangularMap(10, 5);
//        Animal a = new Animal(map, new Vector2d(2,3));
//        map.place(a);
//
//        Assertions.assertEquals(a, map.objectAt(new Vector2d(2 ,3)) );
//    }
//
//
//
//}