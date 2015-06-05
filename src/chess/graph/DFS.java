package chess.graph;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by meidis on 05/06/15.
 */
public class DFS {

    private final boolean[] visited;
    private final int[] edgeTo;
    private final UGraph graph;
    private final int root;

    // v -> graph size (vertex)
    // s O(v)
    // t O(v)
    public DFS(UGraph graph, int root) {
        this.graph = graph;
        this.visited = new boolean[graph.v()];
        this.edgeTo = new int[graph.v()];
        this.root = root;
        this.dfs(root);
    }

    // t O(v)
    private void dfs(int v) {
        this.visited[v] = true;
        for(int w : this.graph.adjacentTo(v)) {
            if(!this.visited[w]) {
                dfs(w);
                edgeTo[w] = v;
            }
        }
    }

    // t O(v)
    public boolean hasPathTo(int v) {
        System.out.println(Arrays.toString(edgeTo));
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!this.hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = v; i != root; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(root);
        return stack;
    }


}
