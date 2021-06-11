package view;

import controller.ButtonController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Hannes Goldfuﬂ
 */


public class Taschenrechner_GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = new GridPane();
            root.setHgap(10);
            root.setVgap(10);
            root.setPadding(new Insets(10,10,10,10));
            
            Label screen = new Label("0");
            root.add(screen, 0,0,4,1);
            
            
            Button modulo = createButton("...", root, screen);
            Button clear = createButton("C", root, screen);            
            Button delete = createButton("...", root, screen);
            Button divide = createButton("/", root, screen);
            Button one = createButton("1",root, screen);
            Button two = createButton("2",root, screen);
            Button three = createButton("3",root, screen);
            Button mult = createButton("*",root, screen);
            Button four = createButton("4",root, screen);
            Button five = createButton("5",root, screen);
            Button six = createButton("6",root, screen);
            Button minus = createButton("-",root, screen);
            Button seven = createButton("7",root, screen);
            Button eight = createButton("8",root, screen);
            Button nine = createButton("9",root, screen);
            Button plus = createButton("+",root, screen);
            Button neg = createButton("...", root, screen);
            Button zero = createButton("0",root, screen);
            Button comma = createButton(",",root, screen);
            Button equals = createButton("=",root, screen);
            
            
            
            Scene scene = new Scene(root,210,290);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Taschenrechner");
            primaryStage.show();
            
        	
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    
    private static int x = 0;
    private static int y = 1;
    
    private static Button createButton(String name, GridPane root, Label screen) {
    	Button but = new Button(name);
    	but.setMinSize(40,40);
    	root.add(but,x , y);
    	if(but.getText().charAt(0) == '.')
    		but.setVisible(false);
    	but.setOnAction(new ButtonController(screen, but.getText().charAt(0)));
    	updateCoordinates();
    	return but;
    	
    }
    
    private static void updateCoordinates() {
    	if (x<3) x++;
    	else {
    		x=0;
    		y++;
    	}
    }
}