package pack;
import java.util.Scanner;

/**
 * 
 * @author Guillermo Romero Alonso
 * 
 * It is the class that contains the main method of the application. 
 * In this case the main method simply creates an empty game, 
 * creates a controller with that game, and invokes the controller's run method.
 *
 */
public class Main {

	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		
		Game partida = new Game();
		Scanner entrada = new Scanner(System.in);
		Controller controlador = new Controller (partida, entrada);
		
		controlador.run();
		entrada.close();
	}
}
