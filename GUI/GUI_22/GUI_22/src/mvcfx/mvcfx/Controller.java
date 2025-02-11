package mvcfx.mvcfx;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Controller {

	private View view;
	private Model model;

	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void initController() {
		view.getSolveButtton().addEventHandler(
				ActionEvent.ACTION,
				(event) -> {
					model.setA(view.getTextFieldA().getText());
					model.setB(view.getTextFieldB().getText());
					model.setC(view.getTextFieldC().getText());
					int tmp = model.solve();
					if(tmp == -1){
						view.getSolveLabel().setText("Number format error!");
						view.getSolveLabel().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
					}else if(tmp == 0){
						view.getSolveLabel().setText("Not a quadratic equation!");
						view.getSolveLabel().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
					}
					else if(tmp == 1){
						view.getSolveLabel().setText("x = " + model.getX());
						view.getSolveLabel().setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
					}else{
						view.getSolveLabel().setText("x1 = " + model.getX1() + ", x2 = " + model.getX2());
						view.getSolveLabel().setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
					}
				}
		);

		view.getClearButton().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						view.getTextFieldA().setText("");
						view.getTextFieldB().setText("");
						view.getTextFieldC().setText("");
					}
				}
		);
	}
}
