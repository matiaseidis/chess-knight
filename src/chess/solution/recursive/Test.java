package chess.solution.recursive;

public class Test {

	public static void main(String[] args) {
		
		int maxReached = 0;
		int boardSize = 8;
		
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<=i; j++) {
				FullPathRecursive p = new FullPathRecursive(new Position(i,j), boardSize);
				boolean result = p.solution();
				System.out.println(String.format("It is possible to cover the 64 squares with just one horse starting at [%s-%s]: %s - reached: %s", i, j, result, p.board.visitedCount()));
				maxReached = Math.max(maxReached, p.board.visitedCount());
			}
		}
		
		System.out.println("max: " + maxReached);
		
//		output:
//		It is possible to cover the 64 squares with just one horse starting at [0-0]: true - reached: 64
//		It is possible to cover the 64 squares with just one horse starting at [1-0]: true - reached: 64
//		It is possible to cover the 64 squares with just one horse starting at [1-1]: true - reached: 64
//		It is possible to cover the 64 squares with just one horse starting at [2-0]: true - reached: 64
//		It is possible to cover the 64 squares with just one horse starting at [2-1]: true - reached: 64
		
	}
}
