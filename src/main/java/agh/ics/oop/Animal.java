package agh.ics.oop;

public class Animal {
    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

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
            return newPosition;
        else
            return this.position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getOrientation(){return this.orientation;
    }


}
