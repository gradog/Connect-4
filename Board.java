package pack;

/**
 * 
 * @author Guillermo Romero Alonso
 *
 * class that stores the state of a board. 
 * The implementation will be generic, since it will allow boards of different sizes
 * 
 */
public class Board {
	private Piece [ ][ ] board; 
	private int row;
	private int col;
	
	
	/**
	 * Board constructor that creates a new type Piece
	 * @param high 
	 * @param width
	 */
	public Board (int high, int width) {
		board = new Piece[Game.ROWS][Game.COLUMNS];
	}
	
	
	/**
	 * 
	 * @return the row where the last piece placed is
	 */
	public int row (){
		
		return row;	
	}
	
	
	/**
	 * 
	 * @return the column where the last piece placed is
	 */
	public int col (){
		
		return col;
	}
	
	
	/**
	 * remove the last piece placed
	 * @param col column where from to remove the piece
	 */
	public void removePiece(int col){
		int i = 0;
		boolean stop = false;
		
		while (i < Game.ROWS && !stop){
			if (board[i][col] != Piece.EMPTY){
				board[i][col] = Piece.EMPTY;
				stop = true;
			}
			i++;
		}
	}
	
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return the piece placed at [row][col]
	 */
	public Piece getPiece(int row, int col) {
		
		return board[row][col];
	}
	
	
	/**
	 * put a piece on the board
	 * @param col column where to place the pice
	 * @param color type of piece (WHITE or BLACK)
	 * @return
	 */
	public boolean putPiece (int col, Piece color) {
		int i = Game.ROWS-1;
		this.col = col-1;
		
		// search for an empty space where to place the piece
		while (i >= 0 && board[i][this.col] != Piece.EMPTY) {
			i--;
		}
		
		if (i < 0) {
			return false;
		}
		else {
			board[i][this.col] = color;
			row = i;
			return true;
		}
	}
	
	
	/**
	 * empty the board
	 */
	public void reset () {
		for (int i = 0; i < Game.ROWS; i++){
			for (int j = 0; j < Game.COLUMNS; j++){
				board[i][j] = Piece.EMPTY;
			}
		}
	}
	
	
	/**
	 * draw the board
	 * @return a string (output) containing the board structure
	 */
	public String draw() {
		String output = "\n";
		
		for (int i = 0; i <= Game.ROWS; i++){
			for (int j = -1; j <= Game.COLUMNS; j++){
				
				// left side
				if (j == -1) {
					if (i == Game.ROWS)
						output += "+";		
					else
						output += "|";
				}
				// rigth side
				else if (j == Game.COLUMNS) { 
					if (i == Game.ROWS)
						output += "+\n";
					else
						output += "|\n";	
				}
				// floor and pieces
				if (j > -1 && j < Game.COLUMNS && i == Game.ROWS)
					output += "-";		
				else if (i < Game.ROWS && j >= 0 && j < Game.COLUMNS )
					output += board[i][j].toString();	
			}
		}
		
		output += " ";
		for (int j = 1; j <= Game.COLUMNS; j++) {
			output += j;
		}
		
		return output + "\n";
	}
}
