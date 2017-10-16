package com.example.ktran.pa04;

public class Cell {
	Coordinates coord;
	char symbol;

	public Cell(Coordinates c, char sym) {

		coord = c;
		symbol = sym;

	}

	public String toString() {
		return String.valueOf(this.symbol);
	}

	public Coordinates getCoord() {
		return this.coord;
	}

	public char getPlayerSym() {
		return this.symbol;
	}

}
