package chess.solution.bfs;

import chess.graph.UBoard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Created by meidis on 08/06/15.
 */
public class RootedBFS {

    final boolean[] visited;
    final int[] edgeTo;
    final int[] pathTo;
    final UBoard board;
    final int root;

    public RootedBFS(UBoard g, int root) {
        this.board = g;
        this.visited = new boolean[g.v()];
        this.edgeTo = new int[g.v()];
        this.pathTo = new int[g.v()];
        this.root = root;
        this.bfs();
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(!visited[current]) {
                this.visited[current] = true;
                for(int v : this.board.adjacentTo(current)) {
                    if(!visited[v]) {
                        queue.add(v);
                        edgeTo[v] = current;
                    }
                }
            }
        }

        IntStream.range(0, this.board.v()).forEach(i -> this.pathTo[i] = this.computePathTo(i));
    }

    private int computePathTo(int v) {
        int result = 0;
        while(v != 0) {
            result++;
            v = this.edgeTo[v];
        }
        return result;
    }

    public int pathTo(int v){
        return  this.pathTo[v];
    }
}
