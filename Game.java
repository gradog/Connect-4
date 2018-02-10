package pack;


/**
 * 
 * @author Guillemro Romero Alonso
 *
 * to represent the state of a game (board, turn, etc.)
 * 
 */
public class Game {
	private Board board; 
	private Piece turn; 
	private boolean finish; 
	private Stack stack;
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	
	/**
	 * game constructor that initializes the board reseting it 
	 * set the turn to white player and initializes the stack
	 */
	public Game(){
		board = new Board (ROWS, COLUMNS);
		board.reset();
		finish = false;
		turn = Piece.WHITE;
		stack = new Stack();
	}

	
	/**
	 * Performs a move placing a piece on the board
	 * @param col column where to place the piece
	 * @return boolean that indicates whether the game has finished or not
	 */
	public boolean move (int col){
		boolean ok = board.putPiece(col, turn);
		
		// check whether there is a Connect 4
		if (ok && (checkColumns() || checkRows() || checkDiagonals())) {
			finish = true;
		}
		else if (ok){
			stack.push(col);
			changeTurn();
		}	
		
		return finish;
	}
	
	
	/**
	 * calls boards class to remove the last piece placed on the board
	 * @return true if it is successful
	 */
	public boolean removePiece(){

		if (stack.pop()){
			int col = stack.getCol();
			board.removePiece(col);
			changeTurn();
			
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * calls board class to draw the board
	 * @return string containing the board
	 */
	public String drawBoard() {

		return board.draw();	
	}
	
	
	/**
	 * change the player
	 */
	private void changeTurn(){
		if (turn == Piece.BLACK)
			turn = Piece.WHITE;
		else
			turn = Piece.BLACK;
	}	
	
	
	/**
	 * 
	 * @return the turn that plays
	 */
	public String getTurn (){
		if (turn == Piece.WHITE)
			return "Whites";
		else
			return "Blacks";
	}
	
	
	/**
	 * given the position of the last piece paced
	 * checks whether there are 4 pieces of the same player placed consecutive the same row
	 * @return if there are 4 pieces of the same player place consecutive in the same row
	 */
	private boolean checkColumns(){
		// get the position of the last piece placed
		int row = board.row();
		int col = board.col();
		int count = 0;
		
		
		// checks pieces on the same column
		while (row < ROWS-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row+1, col)){			
			count++;
			row++;
		}
	
		if (count == 3)
			return true;
		else
			return false;
	}
	
	
	/**
	 * given the position of the last piece paced
	 * checks whether there are 4 pieces of the same player placed consecutive the same column
	 * @return if there are 4 pieces of the same player place consecutive in the same column
	 */
	private boolean checkRows(){
		int row = board.row();
		int col = board.col();
		int count = 0;
		
		// checks pieces on the same row (to the right)
		while (col < COLUMNS-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row, col+1)){
			count++;
			col++;
		}

		
		row = board.row();
		col = board.col();
		// checks pieces on the same row (to the left)
		while (col > 0 && count < 3 && board.getPiece(row, col) == board.getPiece(row, col-1)){
			count++;
			col--;
		}
		
		if (count == 3)
			return true;
		else
			return false;
	}
	
	
	/**
	 * given the position of the last piece paced
	 * checks whether there are 4 pieces of the same player placed consecutive the same diagonal
	 * @return if there are 4 pieces of the same player place consecutive in the same diagonal
	 */
	private boolean checkDiagonals() {
		int row = board.row();
		int col = board.col();
		int count = 0;
		
		// check right diagonal (downwards)
		while (col > 0 && row < ROWS-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row+1, col-1)){
			count++;
			row++;
			col--;
		}	
		
		row = board.row();
		col = board.col();
		// check right diagonal (upwards)
		while (col < COLUMNS-1 && row > 0 && count < 3 && board.getPiece(row, col) == board.getPiece(row-1, col+1)){
			count++;
			row--;
			col++;
		}
		
		if (count == 3)
			return true;
		

		row = board.row();
		col = board.col();
		count = 0;
		// check left diagonal (downwards)
		while (col < COLUMNS-1 && row < ROWS-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row+1, col+1)){
			count++;
			row++;
			col++;
		}
	    
		row = board.row();
		col = board.col();
		// check left diagonal (upwards)
		while (col > 0 && row < ROWS-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row-1,col-1)){
			count++;
			row--;
			col--;
		}
		
		if (count == 3)
			return true;
		else
			return false;
	}
	

	/**
	 * restart the game
	 */
	public void reset() {
		board.reset();
		turn = Piece.WHITE;
		finish = false;
		stack = new Stack();
	}
}

