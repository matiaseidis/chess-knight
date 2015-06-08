package chess.solution.bfs;

import chess.graph.UBoard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by us on 06/06/15.
 */
public class BFS {
    final boolean[] visited;
    final int[] edgeTo;
    final UBoard board;

    public BFS(UBoard g) {
        this.board = g;
        this.visited = new boolean[g.v()];
        this.edgeTo = new int[g.v()];
    }

    public int[] shortestPath(int from, int to) {

        Queue<Integer> queue = new LinkedList<>();

        if(to == from) {
            return new int[0];
        }

        int level = 1;
        int current = from;
        while(current != to) {
            level++;
            for (int next : this.unvisited(current)) {
                this.visit(current, next, queue);
                if(next == to) {
                    return result(to, level);
                }
            }
            current = queue.poll();
        }

        return new int[0];
    }

    private int[] result(int to, int level) {
        int[] result = new int[level];
        for(int i = 0; i<level; i++, to = this.edgeTo[to]) {
            result[i] = to;
        }
        return result;
    }

    private void visit(int current, int next, Queue<Integer> queue) {
        this.edgeTo[next] = current;
        this.visited[next] = true;
        queue.offer(next);
    }

    public Set<Integer> unvisited(int v) {
        return this.board.adjacentTo(v).stream().filter(p -> !this.visited[p]).collect(Collectors.toSet());
    }
}
