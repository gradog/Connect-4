package pack;

/**
 * 
 * @author Guillermo Romero Alonso
 * 
 * In order to execute the Undo command, 
 * this class also contains an integer stack with capacity for at least 10 elements
 *
 */
public class Stack {
	private int[ ] undoStack;
	private int numUndo;
	private final int MAX_STACK = 10;
	private int col;
	
	/**
	 * Constructor of the stack
	 */
	public Stack (){
		undoStack = new int[MAX_STACK];
		numUndo = 0;
		
		for (int i = 0; i < MAX_STACK; i++)
			undoStack[i] = 0;
	}
	
	
	/**
	 * push a new piece in the stack
	 * @param col column where the pice is placed
	 */
	public void push(int col){
		
		if (numUndo < MAX_STACK){
			undoStack[numUndo] = col;
			numUndo++;
		}
		else{	
			for (int i = 1; i < MAX_STACK; i++)
				undoStack[i-1] = undoStack[i];
			
			undoStack[MAX_STACK-1] = col;
		}
	}
	
	
	/**
	 * removes a new piece from the stack
	 * @return if the pop() operation is successful
	 */
	public boolean pop (){
		int count = 0;
		
		for (int i = 0; i <  MAX_STACK; i++){
			if (undoStack[i] == 0){
				count++;
			}
		}
	
		if (count < MAX_STACK){
			numUndo--;
			col = undoStack[numUndo];
			undoStack[numUndo] = 0;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @return the column of a piece
	 */
	public int getCol (){
		
		return col-1;
	}

}
