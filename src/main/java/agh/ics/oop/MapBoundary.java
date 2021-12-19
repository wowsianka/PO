package agh.ics.oop;

import java.util.*;

public class MapBoundary  implements IPositionChangeObserver{
    SortedSet<Vector2d> X = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if(o1.x == o2.x)
                return Integer.compare(o1.y, o2.y);
            return Integer.compare(o1.x, o2.x);
        }
    });

    SortedSet<Vector2d> Y = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if(o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o1.y, o2.y);
        }
    });
    public void add(IMapElement element){
        this.X.add(element.getPosition());
        this.Y.add(element.getPosition());
    }

    public void addAll(List<IMapElement> elements){
        for(IMapElement element : elements){
            this.X.add(element.getPosition());
            this.Y.add(element.getPosition());
        }
    }

    public Vector2d getLowerLeft(){
        return this.X.first().lowerLeft(this.Y.first());
    }

    public Vector2d getUpperRight(){
        return this.X.last().upperRight(this.Y.last());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.X.remove(oldPosition);
        this.Y.remove(oldPosition);
        this.X.add(newPosition);
        this.Y.add(newPosition);
    }
}

// PRZY UZYCIU COMPARATORA
//public class MapBoundary  implements IPositionChangeObserver{
//    private SortedSet<IMapElement> xObjects = new TreeSet<>(new MapElementComparator());
//    private SortedSet<IMapElement> yObjects= new TreeSet<>(new MapElementComparator());
//
//
//    @Override
//    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
////        IMapElement element = xObjects.stream().filter(m -> m.getPosition().equals(newPosition)).findFirst().orElse(null);
////        IMapElement element;
//        for (Object element : xObjects) {
//            if (element instanceof Animal) {
//                if(((Animal) element).getPosition() == oldPosition){
//                    xObjects.remove((Animal) element);
//                    yObjects.remove((Animal) element);
//                    yObjects.add((Animal) element);
//                    xObjects.add((Animal) element);
//                    break;
//                };
//            }
//        }
//
//    }
//
//    public void addElement(IMapElement element){
//        xObjects.add(element);
//        yObjects.add(element);
//    }
//
//    public void addGrass(Grass grass){
//            xObjects.add( grass);
//            yObjects.add(grass);
//
//    }
//
//    public Vector2d getLowerLeft(){
//        return yObjects.first().getPosition().lowerLeft(xObjects.first().getPosition());
//    }
//
//    public Vector2d getUpperRight(){
//        return yObjects.first().getPosition().upperRight(xObjects.first().getPosition());
//    }
//}
//

//
//
///////////////////////////
//    public class MapBoundary  implements IPositionChangeObserver{
//        private final TreeMap<Integer, Object> xObjects;
//        private final TreeMap<Integer, Object> yObjects;
//
//        public MapBoundary() {
//            xObjects = new TreeMap<>();
//            yObjects = new TreeMap<>();
//        }
//
//        @Override
//        public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
//            for (Object item : xObjects.values()) {
//                if (item instanceof Animal) {
//                    if(((Animal) item).getPosition() == oldPosition){
//                        xObjects.remove(((Animal) item).getPosition().x);
//                        xObjects.put(newPosition.x, item);
//                        break;
//                    };
//                }
//            }
//            for (Object item : yObjects.values()) {
//                if (item instanceof Animal) {
//                    if(((Animal) item).getPosition() == oldPosition){
//                        yObjects.remove(((Animal) item).getPosition().y);
//                        yObjects.put(newPosition.y, item);
//                        break;
//                    };
//                }
//            }
//        }
//
//        public void addAnimal(Animal animal){
//            xObjects.put(animal.getPosition().x, animal);
//            yObjects.put(animal.getPosition().y, animal);
//        }
//
//        public void addGrass(Grass grass){
//            xObjects.put(grass.getPosition().x, grass);
//            yObjects.put(grass.getPosition().y, grass);
//
//        }
//
//        public Vector2d getLowerLeft(){
//            return new Vector2d(xObjects.firstKey(), yObjects.firstKey());
//        }
//
//        public Vector2d getUpperRight(){
//            return new Vector2d(xObjects.lastKey(), yObjects.lastKey());
//        }
//    }





