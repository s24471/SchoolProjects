package mvcfx.mvcfx;

import javafx.application.Application;	// Application
import javafx.stage.*;					// Stage
import javafx.scene.*;					// Scene

import java.awt.*;

public class Program extends Application {
	@Override
	public void init() {
		System.out.println("init: " + Thread.currentThread().getName());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println("start begin: " + Thread.currentThread().getName());
		
		Model model = new Model();
		View view = new View();		
		Controller controller = new Controller(model, view);
		controller.initController();

		Scene scene = new Scene(view.getRootNode(), 300, 93);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratic Equation");
		primaryStage.show();

		System.out.println("start end: " + Thread.currentThread().getName());
		
	}
	
	@Override
	public void stop() {
		System.out.println("stop: " + Thread.currentThread().getName());
	}
}