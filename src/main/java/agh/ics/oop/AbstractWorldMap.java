package agh.ics.oop;

import java.util.*;

abstract class AbstractWorldMap  implements IWorldMap, IPositionChangeObserver {
//    private List<Animal> animals = new LinkedList<>();
    private MapVisualizer mapVisual = new MapVisualizer(this);
    private Map<Vector2d, Animal> animals = new HashMap<>();
//    private Set<Vector2d> keys = this.animals.keySet();


    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        if(this.animals.containsKey(position))
            return true;
        return false;
    }

    public Object objectAt(Vector2d position) {
        if(this.animals.containsKey(position))
            return this.animals.get(position);

        return null;
    }
    public  Map<Vector2d, Animal>  getAnimals(){
        return this.animals;
    }

    abstract Vector2d getLowerLeftCorner();
    abstract Vector2d getUpperRightCorner();
    public String toString(){

        return mapVisual.draw(getLowerLeftCorner(), getUpperRightCorner());
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

}
