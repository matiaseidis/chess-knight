package chess;

import java.util.Stack;

public class ChessBoard {

	int maxReached = 0;
	Stack<Position> history = new Stack<>();
	Position start;
	// v * h
	private final boolean[][] squares;
	
	public ChessBoard(Position start, int size) {
		this.start = start;
		this.squares = new boolean[size][size];
		this.visit(start);
	}
	
	public boolean visited(Position p) {
		return p.equals(start) || this.squares[p.x][p.y]; 
	}
	
	public void visit(Position p) {
		this.history.push(p);
		this.maxReached = Math.max(maxReached, history.size());
		this.squares[p.x][p.y] = true;
	}
	
	public Position stepBack() {
		Position p = history.pop();
		this.squares[p.x][p.y] = false;
		return p;
	}
	
	public int visitedCount() {
		return maxReached;
	}
	
	public boolean allVisited() {
		return this.history.size() == this.squares.length * this.squares.length;
	}

	public boolean validSquare(Position next) {
		return this.valid(next.x) && this.valid(next.y);
	}
	
	private boolean valid(int j) {
		return j>=0 && j<this.squares.length;
	}

}
