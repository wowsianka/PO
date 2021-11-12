package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal()
    {

    }

    public String toString(){
        return this.position + ":" + this.orientation;
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> this.position = outsideMap(this.position.add(this.orientation.toUnitVector()));
            case BACKWARD -> this.position = outsideMap(this.position.substract(this.orientation.toUnitVector()));
        }
    }
    public Vector2d outsideMap(Vector2d newPosition){
        Vector2d lowerLeftCorner = new Vector2d(0,0);
        Vector2d upperRightCorner = new Vector2d(4,4);

        if(((upperRightCorner).precedes(newPosition)) && ((lowerLeftCorner).follows(newPosition)))
            return newPosition;
        else
            return this.position;
    }

}
