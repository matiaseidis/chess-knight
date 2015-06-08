package chess.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by meidis on 08/06/15.
 */
public class DGraph {

    final Set<DEdge>[] edges;
    Set<Integer> v;

    public DGraph(int v) {
        this.edges = new Set[v];
        IntStream.range(0, v).forEach(i -> this.edges[i] = new HashSet<DEdge>());
    }

    public void addEdge(DEdge e) {
        this.edges[e.from].add(e);
    }

    public int v() {
        return this.edges.length;
    }

    public Set<DEdge> adjFrom(int v) {
        return this.edges[v];
    }
}
