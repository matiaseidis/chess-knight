package chess;

import chess.graph.DFS;
import chess.graph.UGraph;

import java.util.function.BiFunction;

/**
 * Created by meidis on 05/06/15.
 */
public class ChessKnightDFS {

    public static void main(String[] args) {
        test(8, 8);
    }

    private static void test(int x, int y) {
        BiFunction<Integer, Integer, Boolean> check = (i, j) -> (i >= 0 && i < x) && (j >= 0 && j < y);
        BiFunction<Integer, Integer, Integer> square = (i, j) -> j > 0 ? j * y + i : i;

        UGraph g = new UGraph(x * y);
        Knight knight = new Knight(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for(int next : knight.allowedSquaresFrom(i, j)) {
                    System.out.println("connect " + i + " " + j + " : " + knight.square.apply(i, j));
                    g.connect(knight.square.apply(i, j), next);
                }
            }
        }

        DFS dfs = new DFS(g, 0);
        System.out.println(dfs.hasPathTo(63));
        System.out.println(dfs.pathTo(63));
    }
}

