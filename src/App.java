
import javafx.application .Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;



public class App extends Application {
    static Random random = new Random();
    Group root = new Group();
    List<Rectangle> rectangle = new ArrayList<>();




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

        rectangle = populateList(10);

        // Set up the Layout
        root.getChildren().add(gridPane);

        for (Rectangle rectangles : rectangle){
            root.getChildren().add(rectangles);
        }

        Button randButton = createRandButton(rectangle);
        root.getChildren().add(randButton);




        Scene scene = new Scene(root, 500, 600); // Width and height of the scene
        primaryStage.setTitle("Lab 3: Constrained Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //creates button
    private Button createRandButton(List<Rectangle> rectangle) {
        Button randButton = new Button();
        randButton.setText("Random");
        randButton.setOnAction(event -> {
            onRandom();
        });

        randButton.setLayoutX(220);
        randButton.setLayoutY(550);
        return randButton;
    }

    //creates all rectangles
    private List<Rectangle> populateList(int numberItems){
        List<Rectangle> rectangleList = new ArrayList<>();

        for (int i = 0; i < numberItems; i++) {
            rectangleList.add(getRectangle());
        }
        return rectangleList;
    }

    //button reset
    void onRandom() {
        for (Rectangle changeColor: rectangle)
        {
            changeColor.setFill(Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble()));
            changeColor.setX(random.nextDouble(480));

            int startY = random.nextInt(500);
            changeColor.setY(startY);
            changeColor.setHeight(500 - startY);
        }

    }

    // IntelliJ auto into a private static func
    //creates the rectangle object
    private static Rectangle getRectangle() {

        int startY = random.nextInt(500); // Randomly select a starting Y position for the rectangle, starting point is at the top of the bar
        int endY = 500 - startY; // Ensure that the rectangle fits within the 500-pixel height of the scene

        int x = random.nextInt(480); // size 20 pixel wide, so the bound is 0 - (500-20) + 10

        Rectangle rectangle = new Rectangle(x, startY, 20, endY);

        // Code for coloring rectangle
        rectangle.setFill(Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble()));       // Interior fill color
        rectangle.setStroke(Color.BLACK);      // Border color
        rectangle.setStrokeWidth(3);              // Border width in pixels
        return rectangle;
    }


    public static void main(String[] args) {
        launch(args);
    }


}
