package modell;


/**
*
* @author Hannes Goldfuß, Julia Schöpp
*/

public class MCalc {
	
	private static double x = 0; //linke Zahl
	private static double y = 0; //rechte Zahl
	private static char currentMethod = '0'; // aktuelle Rechenart
	private static int kommaCounter = 0;	// Anzahl Nachkommastellen
	
	public static String eingabe(char funktion) {
		
		switch (funktion) {
		case 'C': 
			x = 0;
			y = 0;
			currentMethod = '0';
			kommaCounter = 0;
			return ""+y;
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case '0':
			//Zahl hinzufügen ohne Komma
			if(kommaCounter ==0) {
				y = y*10 + Character.getNumericValue(funktion);
			}
			
			//Zahl hinzufügen falls Komma vorhanden
			else {
				y = y + Character.getNumericValue(funktion)*Math.pow(10,-kommaCounter);
				kommaCounter++;
			}
			return buildString();
		case '/':
		case '*':
		case '+':
		case '-':
			xBerechnen();
			
			currentMethod=funktion;
			kommaCounter = 0;
			return buildString();
			
			
		case '=':
			xBerechnen();
			currentMethod ='0';
			kommaCounter = 0;
			return ""+roundNumber(x);
			
		case ',':
			if ( kommaCounter == 0 && y != 0) {
			  kommaCounter++;
			  return buildString() + ",";
			}
			return buildString();
			
		
			
		}
		return " "+funktion;
		
	}


	private static void xBerechnen() {
			switch (currentMethod) {
			case '/':
				x /= y;
				break;
			case '*':
				x *= y;
				break;
			case '+':
				x += y;
				break;
			case '-':
				x -= y;
				break;
			case '0':
				x=y;
				break;
			}
			y=0;
	}


	private static String buildString() {
		
		
		
		return (x==0 ? "":roundNumber(x) + " ") + (currentMethod == '0' ? "":currentMethod) + " " + roundNumber(y);
	}
	
	private static String roundNumber(double num) {
		
		int ret;
		
		if((num*10)%10==0) {
			ret = (int) num;
			return ""+ret;
		}
		return ""+num;
		
	}

}
