package chess.solution;

import chess.graph.UBoard;
import chess.graph.UGraph;

import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

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
}
