package agh.ics.oop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.LinkedList;
import java.util.List;

import agh.ics.oop.SimulationEngine;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.Vector2d;
import agh.ics.oop.Animal;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.RectangularMap;
public class RectangularMapTest {
    @Test
    public void animalMovementTest(){
        String[] args={"f", "b" , "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
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
    public void animalOnSamePositionTest(){
        String[] args={"f", "f" , "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Animal> animals = engine.getAnimals();
        Assertions.assertEquals(animals.get(0).getPosition(), new Vector2d(2,4));
        Assertions.assertEquals(animals.get(0).getOrientation(), MapDirection.NORTH);
    }
}