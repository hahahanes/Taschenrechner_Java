package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modell.MCalc;

public class ButtonController implements EventHandler<ActionEvent>{

	private Label screen;
	private char funktion;
	
	public ButtonController(Label screen, char funktion) {
		this.screen = screen;
		this.funktion = funktion;
		
	}

	@Override
	public void handle (ActionEvent e) {
		
		String line = MCalc.eingabe(funktion);
		screen.setText(line);
	}
}
