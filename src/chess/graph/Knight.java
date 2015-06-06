package chess.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by meidis on 05/06/15.
 */
public class Knight {

    final int x;
    final int y;
    final BiFunction<Integer, Integer, Boolean> check;
    final BiFunction<Integer, Integer, Integer> square;

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
        check = (i, j) -> (i >= 0 && i < x) && (j >= 0 && j < y);
        square = (i, j) -> (j > 0) ? j * y + i : i;
    }

    public int square(int p) {
        int i = p%x;
        int j = p/y;
        return this.square.apply(i, j);
    }

    public Collection<Integer> adjacentTo(int p) {
        int i = p%x;
        int j = p/y;
        return adjacentTo(i, j);
    }

    public Collection<Integer> adjacentTo(int i, int j) {
        List<Integer> result = new ArrayList<>();
        addIfValid(result, i, 2, j, 1);
        addIfValid(result, i, 2, j, -1);
        addIfValid(result, i, -2, j, 1);
        addIfValid(result, i, -2, j, -1);
        addIfValid(result, i, 1, j, 2);
        addIfValid(result, i, 1, j, -2);
        addIfValid(result, i, -1, j, 2);
        addIfValid(result, i, -1, j, -2);
        return result;
    }

    private void addIfValid(List<Integer> result, int x, int xOp, int y, int yOp) {
        int xCandidate = x+xOp;
        int yCandidate = y+yOp;
        if (check.apply(xCandidate, yCandidate)) {
            result.add(square.apply(xCandidate, yCandidate));
        }
    }
}
