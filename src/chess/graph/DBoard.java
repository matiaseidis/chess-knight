package chess.graph;

/**
 * Created by meidis on 08/06/15.
 */

import java.util.stream.IntStream;

/**
 * directed board
 */
public class DBoard extends DGraph {
    public DBoard(int v, Knight knight) {
        super(v);
        // set a weight of 1 for all edges
        IntStream.range(0, v).forEach(i -> knight.adjacentTo(i).forEach(j -> this.addEdge(new DEdge(i, j, 1))));
    }
}