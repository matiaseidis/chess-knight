package chess.graph;

import java.util.stream.IntStream;

/**
 * Created by us on 05/06/15.
 */

/**
 * undirected board
 */
public class UBoard extends UGraph {

    public UBoard(int v, Knight knight) {
        super(v);
        IntStream.range(0, v).forEach(i -> knight.adjacentTo(i).forEach(j -> this.connect(i, j)));
    }
}
