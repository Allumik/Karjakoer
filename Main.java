package application;
	
import java.awt.AWTException;
import java.awt.Robot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	public int winx = 500;
	public int winy = 500;
	
	public int wincenterx;
	public int wincentery;
	
	public int targetx = 75;
	public int targety = 75;
	
	public Karjakoer player = new Karjakoer(250, 400);
	public Circle playerbox = new Circle(5, Color.BROWN);

	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Karjakoer"); 
			Group root = new Group();
			
			Scene scene = new Scene(root,winx,winy,Color.DARKGREEN);
			
			this.winx = (int)Math.round(scene.getHeight());
			this.winy = (int)Math.round(scene.getWidth());
			
			Rectangle r = new Rectangle(targetx, targety, Color.GREENYELLOW);
			r.setX((int)Math.round(winx/2-targetx/2));
			r.setY((int)Math.round(winy/2-targety/2));
			
			playerbox.setCenterX(player.getX());
			playerbox.setCenterY(player.getY());
			
		    scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {    	
		    	public void handle(MouseEvent me) {
		    		scene.setCursor(Cursor.NONE);
		    		
		    		
		    		while (player.getX() != me.getX() && player.getY() != me.getY()) {
		    			int mousex = (int)me.getX();
		    			int mousey = (int)me.getY();
		    			if (player.getX() < mousex) {
		    				player.setX(player.getX()+1);
		    				playerbox.setCenterX(player.getX());
		    				
		    			}
		    			//player.setX((int)me.getX());
		    			//player.setY((int)me.getY());
		    			//playerbox.setCenterX(player.getX());
		    			//playerbox.setCenterY(player.getY());

		    		}
		    	}
 		    });
			root.getChildren().add(r);
			root.getChildren().add(playerbox);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
