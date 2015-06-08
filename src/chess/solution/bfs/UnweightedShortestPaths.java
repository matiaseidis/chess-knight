package chess.solution.bfs;

import chess.graph.Knight;
import chess.graph.UBoard;

/**
 * Created by meidis on 08/06/15.
 */
public class UnweightedShortestPaths {

    public static void main(String[] args) {
        int x = 8;
        int y = 8;

        int root = 0;

        Knight knight = new Knight(x, y);
        UBoard g = new UBoard(x * y, knight);
        RootedBFS bfs = new RootedBFS(g, root);

        System.out.println(bfs.pathTo(17)); // 1
        System.out.println(bfs.pathTo(2)); // 2
        System.out.println(bfs.pathTo(19)); // 3
    }


}
