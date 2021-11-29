package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap  implements IWorldMap{
    private List<Animal> animals = new LinkedList<>();
    private MapVisualizer mapVisual = new MapVisualizer(this);


    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : this.animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
    public List<Animal>  getAnimals(){
        return this.animals;
    }

    abstract Vector2d getLowerLeftCorner();
    abstract Vector2d getUpperRightCorner();
    public String toString(){

        return mapVisual.draw(getLowerLeftCorner(), getUpperRightCorner());
    }

}
