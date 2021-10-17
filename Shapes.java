import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.Background; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage; 
import javafx.geometry.Pos;

public class Shapes extends Application {
	
	// Method producing an error message
	public static void noShapeError(Label textDisplayIn) {
		textDisplayIn.setText("Please draw a shape first");
		textDisplayIn.setTextFill(Color.RED);
	}
	
	// Method drawing a clear polygon
	public static void drawClearPolygon(Polygon polygonIn) {
		polygonIn.setFill(Color.WHITE);
		polygonIn.setStroke(Color.BLACK);
	}
	
	@Override
	public void start(Stage stage) {
		
		// Label asking the user to input the name of a shape
		Label requestShape= new Label();
		requestShape.setText("Enter the name of a shape:\ntriangle, rectangle or hexagon");
		requestShape.setTextFill(Color.BLACK);         
		requestShape.setFont(Font.font("Calibri", 20));
		requestShape.setTextAlignment(TextAlignment.CENTER);
		 
		// Text field for user entry
		TextField textFieldShape = new TextField();
		textFieldShape.setMaxWidth(250);
		
		// Draw button:
		Button drawButton = new Button("Draw");
		
		// Box for text field & draw button
		HBox shapeBox = new HBox(10);
		shapeBox.setAlignment(Pos.CENTER);
		
		shapeBox.getChildren().addAll(textFieldShape, drawButton);
		
		// Drawing area
		Rectangle drawingArea = new Rectangle (200, 200);
		drawingArea.setFill(Color.WHITE);
		drawingArea.setStroke(Color.WHITE); 		 
		
		// Group for the drawing area and shapes
		Group drawing = new Group(drawingArea);
		
		// Label asking the user to select the colour of a shape
		Label requestColor= new Label();
		requestColor.setText("Choose a colour:");
		requestColor.setTextFill(Color.BLACK);
		requestColor.setFont(Font.font("Calibri", 20)); 
		
		// 3 colour buttons:
		Button redButton = new Button();
		redButton.setText("Red");
		
		Button greenButton = new Button();
		greenButton.setText("Green");
		
		Button greyButton = new Button();
		greyButton.setText("Grey");
		
		// Button box
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		
		buttonBox.getChildren().addAll(redButton, greenButton, greyButton);
		
		// A label to display actions and errors
		Label textDisplay= new Label();
		textDisplay.setTextFill(Color.RED);
		textDisplay.setFont(Font.font("Calibri", 16));
	
		// Three shapes
		// Triangle:
		Polygon triangle = new Polygon (100, 40, 48, 130, 152, 130);
		drawClearPolygon(triangle);
		
		// Rectangle:
		Polygon rectangle = new Polygon (142, 58, 58, 58, 58, 142, 142, 142);
		drawClearPolygon(rectangle);
		
		// Hexagon:
		Polygon hexagon = new Polygon (130, 48, 70, 48, 40, 100, 70, 152, 130, 152, 160, 100);
		drawClearPolygon(hexagon); 

		// VBox - root
		VBox root = new VBox(15); 
		root.setBackground(Background.EMPTY);
		root.setAlignment(Pos.CENTER); 

		root.getChildren().addAll(requestShape, shapeBox, drawing, requestColor, buttonBox, textDisplay);
		 
		// Scene
		Scene scene = new Scene(root, 400, 500, Color.IVORY);
		 
		// The code that is executed when the draw button is pressed  
		drawButton.setOnAction( e ->  {
			if (textFieldShape.getText().equalsIgnoreCase("triangle")) {
				drawing.getChildren().removeAll(triangle, rectangle, hexagon);
				drawing.getChildren().add(triangle);
				drawClearPolygon(triangle);
				
				textDisplay.setText("Drawing a triangle");
				textDisplay.setTextFill(Color.BLACK);
				
			} else if (textFieldShape.getText().equalsIgnoreCase("rectangle")) {
				drawing.getChildren().removeAll(triangle, rectangle, hexagon);
				drawing.getChildren().add(rectangle);
				drawClearPolygon(rectangle);
				
				textDisplay.setText("Drawing a rectangle");
				textDisplay.setTextFill(Color.BLACK);
				
			} else if (textFieldShape.getText().equalsIgnoreCase("hexagon")) {
				drawing.getChildren().removeAll(triangle, rectangle, hexagon);
				drawing.getChildren().add(hexagon);
				drawClearPolygon(hexagon); 
				
				textDisplay.setText("Drawing a hexagon");
				textDisplay.setTextFill(Color.BLACK);
			} else {
				drawing.getChildren().removeAll(triangle, rectangle, hexagon);
				
				textDisplay.setText("Please enter a valid shape name");
				textDisplay.setTextFill(Color.RED);
			}
		} );  

		// The code that is executed when the colour buttons are pressed  
		redButton.setOnAction(e -> {
			if ( drawing.getChildren().contains(triangle) || drawing.getChildren().contains(rectangle) || drawing.getChildren().contains(hexagon) ) {
				triangle.setFill(Color.RED);
				rectangle.setFill(Color.RED); 
				hexagon.setFill(Color.RED);
				
				textDisplay.setText("Painting the shape red");
				textDisplay.setTextFill(Color.BLACK);
			} else {
				noShapeError(textDisplay);
			}
		} );
		
		greenButton.setOnAction(e -> {
			if ( drawing.getChildren().contains(triangle) || drawing.getChildren().contains(rectangle) || drawing.getChildren().contains(hexagon) ) {
				triangle.setFill(Color.GREEN);
				rectangle.setFill(Color.GREEN); 
				hexagon.setFill(Color.GREEN);
				
				textDisplay.setText("Painting the shape green");
				textDisplay.setTextFill(Color.BLACK);
			} else {
				noShapeError(textDisplay);
			}
		} );

		greyButton.setOnAction(e -> {
			if ( drawing.getChildren().contains(triangle) || drawing.getChildren().contains(rectangle) || drawing.getChildren().contains(hexagon) ) {
				triangle.setFill(Color.GREY);
				rectangle.setFill(Color.GREY); 
				hexagon.setFill(Color.GREY);
				
				textDisplay.setText("Painting the shape grey");
				textDisplay.setTextFill(Color.BLACK);
			} else {
				noShapeError(textDisplay);
			}
		} );

		// Adding the scene to the stage, setting the title
		stage.setScene(scene);
		stage.setTitle("Shapes");
		 
		// Showing the stage
		stage.show();
	}

	public static void main(String[] args) {
		 launch(args);
	}
}