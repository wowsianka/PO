package agh.ics.oop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Direction {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public static Direction convert(String direction) {
        return switch (direction) {
            case "f" -> (Direction.FORWARD);
            case "b" -> (Direction.BACKWARD);
            case "r" -> (Direction.RIGHT);
            case "l" -> (Direction.LEFT);
            default -> throw new IllegalArgumentException();
        };
    }

    public static Direction[] convert(String[] args) {
//        return Arrays.stream(args).map(Direction::convert).toArray(Direction[]::new);

        List<Direction> direction = new LinkedList<Direction>();

        for (String arg : args) {
            try {
                direction.add(convert(arg));
            } catch (IllegalArgumentException ignored) {
            }
        }
        return direction.toArray(new Direction[0]);
    }
}
