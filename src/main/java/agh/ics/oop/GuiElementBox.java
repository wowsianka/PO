package agh.ics.oop;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    Image image;
    ImageView imageView;
    Label label;

    public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {

        image = new Image(new FileInputStream(mapElement.getImage()));

        imageView = new ImageView(image);

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        label = new Label(mapElement.toString());

    }

    public VBox toBox() {

        VBox box = new VBox(imageView, label);
        box.setAlignment(Pos.CENTER);
        return box;
    }
}
