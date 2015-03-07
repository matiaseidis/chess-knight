package chess;

import java.util.Stack;

public class ChessBoard {

	int maxReached = 0;
	Stack<Position> history = new Stack<>();
	Position start;
	// v * h
	private boolean[][] squares = new boolean[8][8];
	
	public ChessBoard(Position start) {
		this.start = start;
		this.visit(start);
	}
	
	
	public boolean visited(Position p) {
		return p.equals(start) || this.squares[p.x][p.y]; 
	}
	
	public void visit(Position p) {
		history.push(p);
		maxReached = Math.max(maxReached, history.size());
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
		return this.history.size() == (this.squares.length * this.squares[0].length)+1;
	}

	public boolean validSquare(Position next) {
		return valid(next.x) && valid(next.y);
	}
	
	private boolean valid(int j) {
		return j>=0 && j<this.squares.length;
	}

}
