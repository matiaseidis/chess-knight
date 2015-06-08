package chess.graph;

/**
 * Created by meidis on 08/06/15.
 */
public class DEdge {

    public final int from;
    public final int to;
    public final double weight;

    public DEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
