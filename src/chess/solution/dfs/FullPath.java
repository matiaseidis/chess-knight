package chess.solution.dfs;

import chess.graph.UBoard;
import chess.graph.Knight;

import java.util.Stack;

/**
 * Created by meidis on 05/06/15.
 */
public class FullPath {

    public static void main(String[] args) {
        test( 4, 4);
        test( 5, 5);
        test( 6, 6);
        test( 7, 7);
        test( 8, 8);
    }

    private static void test(int x, int y) {

        Knight knight = new Knight(x, y);
        UBoard g = new UBoard(x * y, knight);
        DFS dfs = new DFS(g);

        Stack<Integer> path = dfs.traverse(0);
        System.out.println(path.size());
        System.out.println("for " + x + " and " + y + ": path: " + path);

    }
}

