package com.example.ktran.pa04;

public class Coordinates {
	/*
	 * row: a row location col: a column location toString(): returns a string
	 * representation of a Coordinate, i.e. (0, 0)
	 */

	public int row;
	public int col;

	public Coordinates(int _row, int _col) {
		this.row = _row;
		this.col = _col;
	}

	public String toString() {
		return String.valueOf(this.row) + ", " + String.valueOf(this.col);
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

}
