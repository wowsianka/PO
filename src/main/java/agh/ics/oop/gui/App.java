package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.awt.*;
import java.io.FileNotFoundException;

public class App extends Application implements IPositionChangeObserver {
    private GrassField map;
    GridPane gridPane;
    Thread engineThread;
    Scene scene;
    Integer constraint = 35;
    private Vector2d upperRight;
    private  Vector2d lowerLeft;
    private SimulationEngine engine;
    private static final String EMPTY_CELL = " ";

    public void init(){
        this.map = new GrassField(10);;
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        this.engine = new SimulationEngine(map, positions, this);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        gridPane = new GridPane();
        Text title = new Text("Enter moves for animals:");
        title.setStyle("-fx-font: 14 arial;");
        TextField textField = new TextField();
        Button button = new Button("RUN");
        button.setPrefSize(310, 20);
        button.setStyle("-fx-font: 16 arial;");
        HBox hBoxMoves = new HBox(title, textField);
        hBoxMoves.setSpacing(5);
        VBox vBox = new VBox(hBoxMoves, button);


        HBox hbox = new HBox(vBox, gridPane);
        hbox.setSpacing(100);

        vBox.setStyle("-fx-background-color: #DCDCDC;");
        vBox.setAlignment(Pos.TOP_CENTER);
        this.updateScene();
        for (int i = 0; i < upperRight.x-lowerLeft.x +2; i++)
            gridPane.getColumnConstraints().add(new ColumnConstraints(constraint));
        for (int i = 0; i < upperRight.y-lowerLeft.y +2; i++)
            gridPane.getRowConstraints().add(new RowConstraints(constraint));


        scene = new Scene(hbox, 900, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(value ->  {
            String[] text = textField.getText().split(" ");
            MoveDirection[] directions = new OptionsParser().parse(text);

            engine.setDirections(directions);
            engineThread = new Thread(engine);
            engineThread.start();
        });


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

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() -> {
            gridPane.getChildren().clear();
            try {
                this.updateScene();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void updateScene() throws FileNotFoundException {
        gridPane.setGridLinesVisible(false);
        gridPane.setGridLinesVisible(true);
        Label headerLabel = new Label("y\\x");

        this.upperRight = map.getUpperRightCorner();
        this.lowerLeft = map.getLowerLeftCorner();


        GridPane.setHalignment(headerLabel, HPos.CENTER);
        gridPane.add(headerLabel, 0, 0, 1, 1);


        for (int i = this.upperRight.x - lowerLeft.x; i > -1; i--) {
            Label label = new Label(Integer.toString(i + lowerLeft.x));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, i + 1, 0, 1, 1);
//            gridPane.getColumnConstraints().add(new ColumnConstraints(constraint));
        }
        for (int j = 0; j <= this.upperRight.y - lowerLeft.y; j++) {
            Label label = new Label(Integer.toString(this.upperRight.y - j));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, 0, j + 1, 1, 1);
//            gridPane.getRowConstraints().add(new RowConstraints(constraint));
        }

        for (int i = this.upperRight.x - lowerLeft.x; i > -1; i--) {
            for (int j = 0; j <= this.upperRight.y - lowerLeft.y; j++) {
                Label label = new Label(drawObject(new Vector2d(i + lowerLeft.x, this.upperRight.y - j)));
//                    GridPane.setHalignment(label, HPos.CENTER);
//                    gridPane.add(label, i + 1, j + 1, 1, 1);

                IMapElement mapElement = (IMapElement) map.objectAt(new Vector2d(i + lowerLeft.x, this.upperRight.y - j));

                if (mapElement != null) {
                    VBox box = new GuiElementBox(mapElement).toBox();
                    gridPane.add(box, 1 + i,   1 + j,1,1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }else
                    gridPane.add(label, i + 1, j + 1, 1, 1);
            }
        }



    }


}
