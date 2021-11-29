package agh.ics.oop;

import java.util.*;

public class RectangularMap  extends AbstractWorldMap{
    private Vector2d upperRightCorner;
    private Vector2d lowerLeftCorner;

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
    Vector2d getLowerLeftCorner() {
        return this.lowerLeftCorner;
    }

    @Override
    Vector2d getUpperRightCorner() {
        return this.upperRightCorner;
    }
}
