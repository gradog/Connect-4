package pack;
import java.util.Scanner;

/**
 * 
 * @author Guillermo Romero Alonso
 * 
 * controls the execution of the application, 
 * asking the user what he wants to do and updating the game according to what it indicates
 *
 */
public class Controller {
	private Game game; 
	private Scanner in;
	private int col;
	
	/**
	 * controler constructor
	 * @param game
	 * @param input
	 */
	public Controller (Game game, Scanner input){
		this.game = game;
		in = input;
	}
	
	
	/**
	 * starts the game showing an interface where the user can choose some options and start playing
	 */
	public void run(){	
		String input = "";
		boolean finish = false;
		
		System.out.println ("WELCOME TO CONECT 4\n");
	
		while (!finish){
			// Shows the board, the turn and asks the user to insert a piece
			System.out.println (game.drawBoard());
			System.out.println (game.getTurn() + " are playing. ");
			System.out.print ("Choose an option (put, undo, restart, exit): ");
			input = in.next();		
			
			switch (input){
			
			// put a piece
			case "put":	
				do{
					System.out.print ("Put in column: ");
					col = in.nextInt();
					
					if (col <= 0 || col > Game.COLUMNS) {
						System.out.println("ERROR!: the column is not valid. Try again.");
					}
					else if(game.move(col)){
						System.out.println (game.drawBoard() + "\n" + game.getTurn() + " win");
						finish = true;			
					}
					
				} while (col <= 0 || col > Game.COLUMNS);
				
				break;
				
			// undo a movement
			case "undo":
				if (!game.removePiece())
					System.out.println ("ERROR!: you can not undo more moves.");
				
				break;
			
			// restart the game
			case "restart":
				game.reset();
				
				break;
			
			// exit the game
			case "exit":
				System.out.print ("You abandoned the game. See you!");
				finish = true;
				
				break;
			
			default:
				System.out.print ("Unknown command. Try again.\n");
				
				break;
			}
		}
	}
}
