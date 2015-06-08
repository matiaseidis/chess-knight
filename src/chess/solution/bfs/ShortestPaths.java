package chess.solution.bfs;

import chess.graph.DBoard;
import chess.graph.Knight;

/**
 * Created by meidis on 08/06/15.
 */
public class ShortestPaths {

    public static void main(String[] args) {

        int x = 8;
        int y = 8;

        int root = 0;

        Knight knight = new Knight(x, y);
        DBoard g = new DBoard(x * y, knight);
        Dijkstra bfs = new Dijkstra(g, root);

        System.out.println(bfs.pathTo(17)); // 1
        System.out.println(bfs.pathTo(2)); // 2
        System.out.println(bfs.pathTo(19)); // 3
    }
}
