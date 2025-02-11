package mvcfx.mvcfx;

import javafx.scene.control.*;			// Button, Label
import javafx.scene.layout.*;			// Pane, GridPane
import javafx.geometry.*;				// Pos

public class View {
	
	private GridPane rootNode;
	private TextField textFieldA;
	private TextField textFieldB;
	private TextField textFieldC;
	private Button solveButtton, clearButton;
	private Label solveLabel;

	public View() {

		solveLabel = new Label("");
		solveLabel.setMinWidth(300);
		solveLabel.setAlignment(Pos.CENTER);

		textFieldA = new TextField();
		textFieldA.setAlignment(Pos.CENTER_LEFT);
		textFieldA.setTooltip(new Tooltip("Enter a"));

		textFieldB = new TextField();
		textFieldB.setAlignment(Pos.CENTER_LEFT);
		textFieldB.setTooltip(new Tooltip("Enter b"));

		textFieldC = new TextField();
		textFieldC.setAlignment(Pos.CENTER_LEFT);
		textFieldC.setTooltip(new Tooltip("Enter c"));

		solveButtton = new Button("_Solve");
		solveButtton.setMnemonicParsing(true);
		solveButtton.setMinWidth(300);


		clearButton = new Button("_Clear");
		solveButtton.setMnemonicParsing(true);
		clearButton.setMinWidth(300);

		rootNode = new GridPane();

		rootNode.add(solveLabel, 0, 0, 3, 1);
		rootNode.addRow(1, textFieldA, textFieldB, textFieldC);

		rootNode.add(solveButtton, 0, 2, 3, 1);
		rootNode.add(clearButton, 0, 3, 3, 1);
	}

	public GridPane getRootNode() {
		return rootNode;
	}


	public TextField getTextFieldA() {
		return textFieldA;
	}

	public TextField getTextFieldB() {
		return textFieldB;
	}

	public TextField getTextFieldC() {
		return textFieldC;
	}

	public Button getSolveButtton() {
		return solveButtton;
	}

	public Button getClearButton() {
		return clearButton;
	}

	public Label getSolveLabel() {
		return solveLabel;
	}
}