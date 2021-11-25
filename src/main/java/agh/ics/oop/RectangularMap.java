package agh.ics.oop;

import java.util.*;

public class RectangularMap  implements  IWorldMap{
    private Vector2d upperRightCorner;
    private Vector2d lowerLeftCorner;
    private List<Animal> animals = new LinkedList<>();
    private MapVisualizer mapVisual = new MapVisualizer(this);
//    private Map<Vector2d, Animal> positionToAnimal = new HashMap<>();

    public RectangularMap(int width, int height){
        this.upperRightCorner = new Vector2d(width, height);
        this.lowerLeftCorner = new Vector2d(0, 0);

    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return upperRightCorner.precedes(position) && lowerLeftCorner.follows(position)
                && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : this.animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
    public String toString(){
        return mapVisual.draw(lowerLeftCorner, upperRightCorner);
    }

    public Animal getAnimal(){
        return animals.get(0);
    }
}
