package org.openjfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Random;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true); // Makes the grid lines visible

        // Define a constraint that makes each column 50 pixels in width
        ColumnConstraints colConst = new ColumnConstraints(50);

        // Define a constraint that makes each row 50 pixels in height
        RowConstraints rowConst = new RowConstraints(50);

        // Apply the constraints to all 10 columns and 10 rows
        for (int i = 0; i < 10; i++) {
            gridPane.getColumnConstraints().add(colConst);
            gridPane.getRowConstraints().add(rowConst);
        }

        Random rand = new Random();
        int startY = rand.nextInt(500); // Randomly select a starting Y position for the rectangle
        int endY = 500 - startY; // Ensure that the rectangle fits within the 500-pixel height of the scene

        Rectangle rectangle = new Rectangle(0, startY, 50, endY); // x, y, width, height

        // Code for creating a colored rectangle
        rectangle.setFill(Color.LIGHTBLUE);       // Interior fill color
        rectangle.setStroke(Color.DARKBLUE);      // Border color
        rectangle.setStrokeWidth(3);              // Border width in pixels

        // Set up the Layout
        Group root = new Group(gridPane, rectangle);

        Scene scene = new Scene(root, 500, 600); // Width and height of the scene
        primaryStage.setTitle("Lab 3: Constrained Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}