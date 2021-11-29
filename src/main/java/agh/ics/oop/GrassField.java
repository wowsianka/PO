package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class GrassField extends AbstractWorldMap{

    private final Integer numberOfGrass;
    private List<Grass> grassField = new LinkedList<>();

    private Vector2d lowerLeftCorner;
    private Vector2d upperRightCorner;

    public GrassField(int numberOfGrass){
        this.numberOfGrass  = numberOfGrass;
        for (int n=0; n < this.numberOfGrass; n++){
            Vector2d grassPosition;
            do{
                grassPosition = Vector2d.getRandomPosition(0, (int)Math.sqrt(this.numberOfGrass*10));
            }while(this.isGrassAt(grassPosition));

            Grass grass = new Grass(grassPosition);
            grassField.add(grass);
        }
        this.lowerLeftCorner = grassField.get(0).getPosition();
        this.upperRightCorner = grassField.get(0).getPosition();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = this.objectAt(position);
        return !(object instanceof Animal);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)){
            return true;
        }
        for (Grass grass : this.grassField){
            if(grass.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        // Animal has priority over the grass
        Object object =  super.objectAt(position);
        if(object instanceof Animal){
            return object;
        }
        for (Grass grass : this.grassField){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }

    @Override
    Vector2d getLowerLeftCorner() {
        for (Grass grass : this.grassField){
            this.lowerLeftCorner = grass.getPosition().lowerLeft(this.lowerLeftCorner);
        }

        for (Animal animal : this.getAnimals()){
            this.lowerLeftCorner = animal.getPosition().lowerLeft(this.lowerLeftCorner);
        }
        return this.lowerLeftCorner;
    }

    @Override
    Vector2d getUpperRightCorner() {
        for (Grass grass : this.grassField){
            this.upperRightCorner = grass.getPosition().upperRight(this.upperRightCorner);
        }

        for (Animal animal : this.getAnimals()){
            this.upperRightCorner = animal.getPosition().upperRight(this.upperRightCorner);
        }
        return this.upperRightCorner;
    }

    public boolean isGrassAt(Vector2d grassPosition){
        for (Grass grass : this.grassField){
            if(grass.getPosition().equals(grassPosition))
                return true;
        }
        return false;
    }






}
