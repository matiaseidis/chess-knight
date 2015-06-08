package chess.solution;

import chess.graph.Knight;
import chess.graph.UBoard;
import chess.graph.UGraph;
import chess.solution.bfs.BFS;

import java.util.*;

/**
 * Created by meidis on 08/06/15.
 */
public class FS {
    final UGraph g;
    final boolean[] visited;
    final int[] edgeTo;

    public FS(UGraph g) {
        this.g = g;
        this.visited = new boolean[g.v()];
        this.edgeTo = new int[g.v()];
    }

    public void fs(Queue<Integer> track, int from) {
        track.add(from);
        while(!track.isEmpty()) {
            int current = track.poll();
            for(int adj : this.g.adjacentTo(current)) {
                if(!this.visited[adj]) {
                    track.add(adj);
                    this.visited[adj] = true;
                    this.edgeTo[adj] = current;
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> result = new Stack<>();
        result.push(v);
        while(v != 0) {
            result.push(this.edgeTo[v]);
            v = this.edgeTo[v];
        }
        result.push(0);
        return result;
    }

    public static void main(String[] args) {
        int x = 8;
        int y = 8;
        Knight knight = new Knight(x, y);
        UBoard g = new UBoard(x * y, knight);

        FS fs = new FS(g);
        fs.fs(new LinkedList<>(), 0);
        System.out.println(fs.pathTo(63));

        FS fs2 = new FS(g);
        fs2.fs(new ArrayDeque<>(), 0);
        System.out.println(fs2.pathTo(63));



    }
}
