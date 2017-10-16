package com.example.ktran.pa04;

import java.util.Arrays;

public class Board {

	int spaceFilled;
	int dim;
	Cell[][] grid;

	public Board(int _dim) {
		spaceFilled = 0;
		this.dim = _dim;
		this.grid = new Cell[dim][dim];
		for (int row = 0; row < dim; row++)
			for (int col = 0; col < dim; col++)
				grid[row][col] = new Cell(new Coordinates(row, col), ' ');
	}
	
	/**
	*Prints the 2d array from
	*@source https://stackoverflow.com/questions/19648240/java-best-way-to-print-2d-array
	* @return 2d array in String
	*/

	public String toString() {
		return Arrays.deepToString(grid).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
	}
	
	/**
	* Checks if it is a valid move
	*
	* @return true if it is valid move
	*/
	public boolean isValidMove(Coordinates coord) {
		return grid[coord.row][coord.col].getPlayerSym() == ' ';
	}
	
	/**
	* Adds cell to the Grid
	*
	* @return true if successful
	*/
	public boolean makeMove(Coordinates coord, char p_sym) {
		if (isValidMove(coord)) {
			grid[coord.row][coord.col] = new Cell(coord, p_sym);
			this.spaceFilled++;
			return true;
		} else
			System.out.println("Make valid move.");
		return false;
	}
	
	/**
	* Checks if there is a winner in the tic tac toe game, or draw
	*
	* @return true if there is a winner or draw game
	*/
	public boolean isWinner(char p_sym) {
		int count = 0;
		int regDag = 0;
		int opDag = 0;

		for (int i = 0; i < dim; i++) { // Row check, diag, reverse diag
			for (int j = 0; j < dim; j++) { // col
				if (i == j && grid[i][j].getPlayerSym() == p_sym)
					regDag++;
				if (i + j == (dim - 1) && grid[i][j].getPlayerSym() == p_sym)
					opDag++;
				if (grid[i][j].getPlayerSym() == p_sym)
					count++;
				if (count == dim || regDag == dim || opDag == dim)
					return true;
			}
			count = 0;
		}

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (grid[j][i].getPlayerSym() == p_sym)
					count++;
				if (count == dim || regDag == dim || opDag == dim)
					return true;
			}
			count = 0;
		}

		if (this.spaceFilled == (dim * dim)) {
			System.out.println("draw game");
			return true;
		}

		return false;
	}

	public int getScratch() {
		return this.spaceFilled;
	}

}
