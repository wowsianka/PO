package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements  IEngine,Runnable{
    private MoveDirection[] directions;
    private  IWorldMap map;
    private List<Animal> animals = new LinkedList<>();
    private Integer lastStep = 0;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPositions, App app){
        this.directions = directions;
        this.map = map;

        for(Vector2d position : initialPositions){
            Animal animal = new Animal(this.map, position);
            animal.addObserver(app);
            if(this.map.place(animal)){
                animals.add(animal);
            }
        }
    }
    public SimulationEngine( IWorldMap map, Vector2d[] initialPositions, App app){
        this.map = map;

        for(Vector2d position : initialPositions){
            Animal animal = new Animal(this.map, position);
            animal.addObserver(app);
            if(this.map.place(animal)){
                animals.add(animal);
            }
        }
    }
    public List<Animal>  getAnimals(){
        return this.animals;
    }

    public Boolean step() {
        if(this.lastStep >= 0 && this.lastStep < directions.length){
            animals.get(this.lastStep % animals.size()).move(directions[this.lastStep]);
            this.lastStep++;
            System.out.println(map);
            return true;
        }
        return false;
    }
    public void setDirections(MoveDirection[] directions){
        this.directions = directions;
    }

    @Override
    public void run() {
        for(int i =0; i< directions.length; i++){
            animals.get(i % animals.size()).move(directions[i]);

//            System.out.println(map);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
