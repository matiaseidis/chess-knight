package chess.solution.recursive;

import java.util.LinkedList;
import java.util.List;

public class FullPathRecursive {

	final public ChessBoard board;
	final private Position start;

	public FullPathRecursive(Position start, int size) {
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

	private List<Position> availableFrom(Position current) {

		List<Position> result = new LinkedList<>();

		for (Position p : calculateFrom(current))
			if (this.board.validSquare(p) && !this.board.visited(p))
				result.add(p);
		return result;
	}

	private Position[] calculateFrom(Position current) {
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