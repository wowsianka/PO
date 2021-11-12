package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public MoveDirection[] parse(String[] array){

        ArrayList<MoveDirection> strlist = new ArrayList<MoveDirection>();
        for (String ar: array){
            switch (ar) {
                case "f", "forward" -> {
                    strlist.add(MoveDirection.FORWARD);
                }
                case "b", "backward" -> {
                    strlist.add(MoveDirection.BACKWARD);
                }
                case "fl", "left" -> {
                    strlist.add(MoveDirection.LEFT);
                }
                case "r", "right" -> {
                    strlist.add(MoveDirection.RIGHT);
                }
            }
        }
        return  strlist.toArray(new MoveDirection[0]);


    }
}
