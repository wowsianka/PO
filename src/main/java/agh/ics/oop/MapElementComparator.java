package agh.ics.oop;

import java.util.Comparator;

public class MapElementComparator implements Comparator<IMapElement> {
    @Override
    public int compare(IMapElement first, IMapElement second){
        Vector2d firstPosition = first.getPosition();
        Vector2d secondPosition = second.getPosition();

        int result = Integer.compare(firstPosition.x, secondPosition.x);

        if(result != 0){
            return result;
        }
        result = Integer.compare(firstPosition.y, secondPosition.y);
        if(result != 0){
            return result;
        }
        if(first instanceof Animal && second instanceof Grass)
            return  -1;
        else if(first instanceof Grass && second instanceof  Animal)
            return 1;
        else
            return 0;
    }
}
