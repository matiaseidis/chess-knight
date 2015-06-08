package chess.solution.bfs;

import chess.graph.UBoard;
import chess.graph.Knight;

import java.util.Arrays;

/**
 * Created by us on 06/06/15.
 */
public class ShortestPath {

    public static void main(String[] args) {
        test(4, 4, 3, 4);
        test(4, 4, 9, 15);
        test(5, 5, 3, 4);
        test(5, 5, 11, 8);
        test(5, 5, 0, 8);
        test(6, 6, 3, 4);
        test(7, 7, 3, 4);
        test(8, 8, 3, 4);
    }

    private static void test(int x, int y, int from, int to) {

        Knight knight = new Knight(x, y);
        UBoard g = new UBoard(x * y, knight);
        BFS bfs = new BFS(g);

        int[] path = bfs.shortestPath(from, to);
        System.out.println("board size: " + x * y + ". from " + from + " to " + to + ": path: " + Arrays.toString(path));
    }
}
