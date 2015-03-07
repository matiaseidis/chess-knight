package chess;

public class Test {

	public static void main(String[] args) {
		
		int maxReached = 0;
		
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<=i; j++) {
				ChessHorseProblem p = new ChessHorseProblem(new Position(i,j));
				boolean result = p.solution();
				System.out.println(String.format("It is possible to cover the 64 squares with just one horse starting at [%s-%s]: %s - reached: %s", i, j, result, p.board.visitedCount()));
				maxReached = Math.max(maxReached, p.board.visitedCount());
			}
		}
		System.out.println("max: " + maxReached);
//		output:
//		It is possible to cover the 64 squares with just one horse starting at [0-0]: false - reached: 23
//		It is possible to cover the 64 squares with just one horse starting at [1-0]: false - reached: 34
//		It is possible to cover the 64 squares with just one horse starting at [1-1]: false - reached: 31
//		It is possible to cover the 64 squares with just one horse starting at [2-0]: false - reached: 52
//		It is possible to cover the 64 squares with just one horse starting at [2-1]: false - reached: 22
//		It is possible to cover the 64 squares with just one horse starting at [2-2]: false - reached: 14
//		It is possible to cover the 64 squares with just one horse starting at [3-0]: false - reached: 32
//		It is possible to cover the 64 squares with just one horse starting at [3-1]: false - reached: 18
//		It is possible to cover the 64 squares with just one horse starting at [3-2]: false - reached: 53
//		It is possible to cover the 64 squares with just one horse starting at [3-3]: false - reached: 42
//		max: 53
		
	}
}
