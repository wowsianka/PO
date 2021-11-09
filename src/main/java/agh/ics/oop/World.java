package agh.ics.oop;

public class World
{
    public static void main(String[] args) {
        System.out.println("start");

//        run(Direction.convert(args));
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println( MapDirection.NORTH.toUnitVector());
        System.out.println("stop");
    }

    public static void run(Direction[] array){
            for (Direction s : array)
            {
                switch (s) {
                    case FORWARD -> System.out.println("zwierz idzie do przodu");
                    case BACKWARD -> System.out.println("zwierz idzie do tylu");
                    case RIGHT -> System.out.println("zwierz idzie w prawo");
                    case LEFT -> System.out.println("zwierz idzie w lewo");
                }
            }
    }
}
