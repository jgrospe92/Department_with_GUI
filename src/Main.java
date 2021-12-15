import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{

    // Class to test JAVAFX
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Group root = new Group();
        // Scene scene = new Scene(root, Color.BLACK); // This add BG color
        Scene scene = new Scene(root, 600,600, Color.SKYBLUE);
        Image icon = new Image("Image/programming.png"); // Image needs to be inside the src folder
        stage.getIcons().add(icon); // set it
        
        stage.setTitle("Stage demo program");
        // stage.setWidth(420); // set width
        // stage.setHeight(420);
        // stage.setResizable(false); // disable resizable
        //stage.setX(50); // set the x location of stage on the screen
        //stage.setY(50); // set the y location of stage on the screen
        //stage.setFullScreen(true); // set it to fullscreen
        //stage.setFullScreenExitHint("You cant escape unless you press q"); // change the escape message
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q")); // change the key

        // Adding text

        Text text = new Text(); // Text is a type of node
        text.setText("JavaFx is so cool"); // You can either do this or pass it to the constructor
        // Since we are using group node we have to manually assign the position
        text.setX(50);
        text.setY(50);
        // Setting the properties of the text
        text.setFont(Font.font("Verdana", 50)); // This changes the font and the size
        text.setFill(Color.LIMEGREEN); //change font color

        // adding line, line is a node
        Line line = new Line();
        line.setStartX(200); // starting line
        line.setStartY(200); 
        line.setEndX(500); // End line
        line.setEndY(200);
        line.setStrokeWidth(5); // change the stroke width
        line.setStroke(Color.RED); // change the line color
        line.setOpacity(0.5); // Change the opacity between 0 - 1
        line.setRotate(45); // rotate the line
        // This is just a few methods of Line

        // Adding Triangle
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(200.0 , 200.0, 200.0, 300.0, 200.0, 300.0); // It takes double tye, you can cast it to int
        triangle.setFill(Color.YELLOW);

        // Add a circle
        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);

        // Add an image
        Image burger = new Image("Image/hamburger.png"); // Load the image
        ImageView imageView = new ImageView(burger); // Create a ImageView object
        imageView.setX(200); // Position X
        imageView.setY(250); // Position Y then add it to the node

        // We have to add this to the root node
        root.getChildren().add(line);
        root.getChildren().add(text);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);



        stage.setScene(scene);
        stage.show(); // set it last
    }

    
}