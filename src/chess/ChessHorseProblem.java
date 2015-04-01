package chess;

import java.util.LinkedList;
import java.util.List;

public class ChessHorseProblem {

	final public ChessBoard board;
	final private Position start;

	public ChessHorseProblem(Position start, int size) {
		this.start = start;
		this.board = new ChessBoard(start, size);
	}

	public boolean solution() {
		return nextMove(start);
	}

	private boolean nextMove(Position from) {

		if(this.board.allVisited())
			return true;
		
		for (Position p : this.availableFrom(from)) {
			this.board.visit(p);
			
			if (nextMove(p)) 
				return true;
			else 
				board.stepBack();
			
		}
		return false;
	}

	private List<Position> availableFrom(chess.Position current) {

		List<Position> result = new LinkedList<>();

		for (Position p : calculateFrom(current))
			if (this.board.validSquare(p) && !this.board.visited(p))
				result.add(p);
		return result;
	}

	private chess.Position[] calculateFrom(chess.Position current) {
		return new Position[] { 
				Position(current.x - 2, current.y + 1),
				Position(current.x - 2, current.y - 1),
				Position(current.x - 1, current.y + 2),
				Position(current.x - 1, current.y - 2),
				Position(current.x + 1, current.y + 2), 
				Position(current.x + 1, current.y - 2),
				Position(current.x + 2, current.y + 1),
				Position(current.x + 2, current.y - 1)
				};
	}

	static Position Position(int v, int h) {
		return new Position(v, h);
	}

}

class Position {
	public final int x;
	public final int y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + y;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (y != other.y)
			return false;
		if (x != other.x)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%s - %s]", x, y);
	}
}
