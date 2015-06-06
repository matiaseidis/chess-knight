package chess.solution.dfs;

import chess.graph.UGraph;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by meidis on 05/06/15.
 */
public class DFS {

    private final boolean[] visited;
    private final UGraph graph;

    // v -> graph size (vertex)
    // s O(v)
    // t O(v)
    public DFS(UGraph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.v()];
    }

    public Stack<Integer> traverse(int from) {
        Stack<Integer> path = new Stack<>();
        if(traverse(from, path))
            return path;
        return new Stack<>();
    }

    private boolean traverse(int v, Stack<Integer> history) {

        visit(v, history);

        if (this.allVisited(history)) {
            return true;
        }

        for(int next : unvisited(v)) {

            if(traverse(next, history)) {
                return true;
            } else {
                unvisit(history);
            }
        }
        return false;
    }

    private void unvisit(Stack<Integer> history) {
        int unvisited = history.pop();
        this.visited[unvisited] = false;
    }

    private boolean allVisited(Stack<Integer> history) {
        return history.size() == this.graph.v();
    }

    private Set<Integer> unvisited(int v) {
        return this.graph.adjacentTo(v).stream().filter(adj -> !this.visited[adj]).collect(Collectors.toSet());
    }

    public void visit(int v, Stack<Integer> history) {
        history.push(v);
        this.visited[v] = true;
    }
}
