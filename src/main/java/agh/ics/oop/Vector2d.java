package agh.ics.oop;
import java.util.Vector;

import static java.lang.StrictMath.max;
import static java.lang.Integer.min;

public class Vector2d {
    public final int x;
    public final int y;


    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }



    public String toString(){
        return '(' +  Integer.toString(this.x) + ',' + Integer.toString(this.y) + ')' ;
    }

    //other jest przed this
    public boolean precedes(Vector2d other) {
        return other.x <= this.x && other.y <= this.y;
    }

    //other  po this 
    public boolean follows(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public Vector2d upperRight( Vector2d other){

        int x = max(this.x, other.x);
        int y = max(this.y , other.y);
        Vector2d rightCorner = new Vector2d(x, y);
        return rightCorner;
    }
    public Vector2d lowerLeft( Vector2d other){

        int x = min(this.x, other.x);
        int y = min(this.y , other.y);
        Vector2d leftCorner = new Vector2d(x, y);
        return leftCorner;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        // tutaj przeprowadzane jest faktyczne porównanie
        return this.x == that.x && this.y == that.y;
    }

    public Vector2d opposite(){

        return new Vector2d((-1)*this.x, (-1)*this.y);
    }

}
