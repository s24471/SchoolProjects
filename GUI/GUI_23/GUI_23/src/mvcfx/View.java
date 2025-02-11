package mvcfx;
import javafx.scene.layout.*;			// Pane, GridPane
import javafx.scene.shape.*;			// Circle, Rectangle
import java.util.ArrayList;

public class View {
	
	private Pane rootNode;


	public Pane getRootNode() {
		return rootNode;
	}


	public View(ArrayList<Rectangle> rect, ArrayList<Circle> circle) {
		rootNode = new Pane();
		rootNode.getChildren().addAll(rect);
		rootNode.getChildren().addAll(circle);
	}
}