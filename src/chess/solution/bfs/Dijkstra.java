package chess.solution.bfs;

import chess.graph.DBoard;
import chess.graph.DEdge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Created by meidis on 08/06/15.
 */
public class Dijkstra {

    final double[] pathTo;
    final boolean[] visited;
    final int[] edgeTo;
    final DBoard board;
    final int root;

    public Dijkstra(DBoard g, int root) {
        this.board = g;
        this.edgeTo = new int[g.v()];
        // initialize the path to root to zero and the path to every other node to int.MAX
        this.pathTo = new double[g.v()];
        this.visited = new boolean[g.v()];
        IntStream.range(0, g.v()).forEach(i -> this.pathTo[i] = Integer.MAX_VALUE);
        this.pathTo[root] = 0;
        this.root = root;
        this.bfs();
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(DEdge e : this.board.adjFrom(current)) {
                if(!this.visited[e.to]) {
                    queue.add(e.to);
                    this.visited[e.to] = true;
                    this.relax(e);
                }
            }
        }
    }

    private void relax(DEdge e) {
        if(this.pathTo[e.to] > e.weight + this.pathTo[e.from]) {
            this.pathTo[e.to] = e.weight + this.pathTo[e.from];
            this.edgeTo[e.to] = e.from;
        }
    }

    public double pathTo(int to) {
        return this.pathTo[to];
    }
}
