package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private List<IPositionChangeObserver> observers = new ArrayList<>();

//    public Animal()
//    {
//    }

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position =  initialPosition;
    }

    public Animal(Vector2d position, MapDirection orientation)
    {   this.position =  position;
        this.orientation = orientation;
    }

    public String toString(){
        return this.orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> this.position =  outsideMap(this.position.add(this.orientation.toUnitVector()));
            case BACKWARD -> this.position = outsideMap(this.position.substract(this.orientation.toUnitVector()));
        }


    }
    public Vector2d outsideMap(Vector2d newPosition){
        if(this.map.canMoveTo(newPosition))
        {
            this.positionChanged(this.position, newPosition);
            return newPosition;
        }
        else
            return this.position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    //addobserver- ktora przyjmuje obserwatpr i ich zapisuje i jak cos sie zmieni to biore
    // tych wszytskich obserwator obserwator..positionchanged

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}
