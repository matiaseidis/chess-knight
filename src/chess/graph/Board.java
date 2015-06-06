package chess.graph;

import java.util.stream.IntStream;

/**
 * Created by us on 05/06/15.
 */
public class Board extends UGraph {

    public Board(int v, Knight knight) {
        super(v);
        IntStream.range(0, v).forEach(i -> knight.adjacentTo(i).forEach(j -> this.connect(i, j)));
    }
}
