package chess.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by meidis on 05/06/15.
 */
public class UGraph {

    protected final Set<Integer>[] v;

    public UGraph(int v) {
        this.v = new Set[v];
        IntStream.range(0, v).forEach(i -> this.v[i] = new HashSet<>());
    }

    public void connect(int a, int b) {
        this.v[a].add(b);
    }

    public boolean isConnected(int a, int b) {
        return this.v[a].contains(b);
    }

    public Set<Integer> adjacentTo(int a) {
        return this.v[a];
    }

    public int v() {
        return this.v.length;
    }
}
