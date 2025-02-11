package mvcfx;

import javafx.application.Application;	// Application
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;					// Stage
import javafx.scene.*;					// Scene

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program extends Application {
	@Override
	public void init() {
		System.out.println("init: " + Thread.currentThread().getName());
	}

	Random rand = new Random();

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start begin: " + Thread.currentThread().getName());

		ArrayList<String> arr = new ArrayList<>();
		File file = new File("dane.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			arr.add(scan.nextLine());
		}
		ArrayList<Rectangle> rect = new ArrayList<>();
		ArrayList<Circle> circle = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
		/*	int tmp = 0;
			Pattern pattern = Pattern.compile("\\S+");
			Matcher matcher = pattern.matcher(arr.get(i));
			while (matcher.find()) {
				tmp++;
			}*/
			int num = 0;
			Pattern pattern2 = Pattern.compile("\\d+");
			Matcher matcher2 = pattern2.matcher(arr.get(i));
			while (matcher2.find()) {
				num++;
			}

			if(num==arr.get(i).split(" ").length){
				if(num == 3) {
					circle.add(addCircle(Integer.valueOf(arr.get(i).split(" ")[0]), Integer.valueOf(arr.get(i).split(" ")[1]), Integer.valueOf(arr.get(i).split(" ")[2])));
				}else if (num == 4) {
					rect.add(addRect(Integer.valueOf(arr.get(i).split(" ")[0]), Integer.valueOf(arr.get(i).split(" ")[1]), Integer.valueOf(arr.get(i).split(" ")[2]), Integer.valueOf(arr.get(i).split(" ")[3])));
				}
			}
		}

		View view = new View(rect, circle);
		Scene scene = new Scene(view.getRootNode());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Figurki");
		primaryStage.show();
		System.out.println("start end: " + Thread.currentThread().getName());
		
	}
	public Rectangle addRect(int x1, int y1, int x2, int y2){
		int l1 = x1<x2?x1:x2, l2 = y1<y2?y1:y2;
		int a = x1<x2?x2-x1:x1-x2;
		int b = y1<y2?y2-y1:y1-y2;
		Rectangle rectangle = new Rectangle(l1,  l2,  a, b);
		rectangle.setFill(Color.TRANSPARENT);
		rectangle.setStroke(los());
		//rectangle.setFill(los());
		return rectangle;
	}
	public Circle addCircle(int x, int y, int r){
		Circle circle= new Circle(x, y, r, Color.TRANSPARENT);
		circle.setStroke(los());
		//circle.setFill(los());
		return circle;
	}

	public Color los(){
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		Color tmp = Color.rgb(r, g, b, .99);
		return tmp;
	}
	@Override
	public void stop() {
		System.out.println("stop: " + Thread.currentThread().getName());
	}
}