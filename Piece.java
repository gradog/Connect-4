package pack;

/**
 * 
 * @author Guillermo Romero Alonso
 * 
 * enumerated that represents a tab color. It contains the EMPTY, WHITE and BLACK enumeration constants.
 *
 */
public enum Piece {EMPTY, WHITE, BLACK;

	/**
	 * receive a piece and transforms it to a character
	 */
	public String toString(){	
		String piece = "";
		
		switch (this){
			case EMPTY:
				piece = " ";
				break;
			
			case WHITE:
				piece = "O";
				break;
			
			case BLACK:
				piece = "X";
				break;
		}
		return piece;
	}
}
