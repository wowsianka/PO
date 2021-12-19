package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World
{
    public static void main(String[] args) {
        try{
            System.out.println("start");
//            MoveDirection[] directions = new OptionsParser().parse(args);
////        IWorldMap map = new RectangularMap(10, 5);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//        System.out.println(map);
            Application.launch(App.class, args);
            System.out.println("stop");
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }

}
