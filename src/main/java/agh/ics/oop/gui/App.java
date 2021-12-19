package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class App extends Application {
    private GrassField map;
    private Vector2d upperRight;
    private  Vector2d lowerLeft;
    private SimulationEngine engine;
    private static final String EMPTY_CELL = " ";

    public void init(){
        String[] args = new String[getParameters().getRaw().size()];
        args = getParameters().getRaw().toArray(args);
        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        IWorldMap map = new GrassField(10);
        this.map = new GrassField(10);;
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        this.engine = new SimulationEngine(directions, map, positions);
        this.engine.run();

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//        while(this.engine.step())
//        {
            Label headerLabel = new Label("y\\x");
            GridPane gridPane = new GridPane();
            this.upperRight = map.getUpperRightCorner();
            this.lowerLeft = map.getLowerLeftCorner();
            Integer constraint = 35;

            GridPane.setHalignment(headerLabel, HPos.CENTER);
            gridPane.add(headerLabel, 0, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(constraint));
            gridPane.getRowConstraints().add(new RowConstraints(constraint));

            for (int i = this.upperRight.x - lowerLeft.x; i > -1; i--) {
                Label label = new Label(Integer.toString(i + lowerLeft.x));
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, i + 1, 0, 1, 1);
                gridPane.getColumnConstraints().add(new ColumnConstraints(constraint));
            }
            for (int j = 0; j <= this.upperRight.y - lowerLeft.y; j++) {
                Label label = new Label(Integer.toString(this.upperRight.y - j));
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, 0, j + 1, 1, 1);
                gridPane.getRowConstraints().add(new RowConstraints(constraint));
            }

            for (int i = this.upperRight.x - lowerLeft.x; i > -1; i--) {
                for (int j = 0; j <= this.upperRight.y - lowerLeft.y; j++) {
                    Label label = new Label(drawObject(new Vector2d(i + lowerLeft.x, this.upperRight.y - j)));
                    GridPane.setHalignment(label, HPos.CENTER);
                    gridPane.add(label, i + 1, j + 1, 1, 1);

                }
            }

            gridPane.setGridLinesVisible(true);
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("Loop");

//        }
    }
    private String drawObject(Vector2d currentPosition) {
        String result = null;
        if (this.map.isOccupied(currentPosition)) {
            Object object = this.map.objectAt(currentPosition);
            if (object != null) {
                result = object.toString();
            } else {
                result = EMPTY_CELL;
            }
        } else {
            result = EMPTY_CELL;
        }
        return result;
    }



}
