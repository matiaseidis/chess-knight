package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by meidis on 05/06/15.
 */
class Knight {

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

    public Iterable<Integer> allowedSquaresFrom(int i, int j) {
        List<Integer> result = new ArrayList<>();
        addIfValid(result, left(i, 2), down(j, 1));
        addIfValid(result, left(i, 2), up(j, 1));
        addIfValid(result, right(i, 2), down(j, 1));
        addIfValid(result, right(i, 2), up(j, 1));
        addIfValid(result, left(i, 1), down(j, 2));
        addIfValid(result, left(i, 1), up(j, 2));
        addIfValid(result, right(i, 1), down(j, 2));
        addIfValid(result, right(i, 1), up(j, 2));
        System.out.println("allowed " + i + " " + j + " : " + result.toString());
        return result;
    }

    private void addIfValid(List<Integer> result, int x, int y) {
        if (check.apply(x, y)) {
            result.add(square.apply(x, y));
        }
    }

    int left(int i, int n) {
        return i - n;
    }

    int right(int i, int n) {
        return i + n;
    }

    int up(int i, int n) {
        return i - n;
    }

    int down(int i, int n) {
        return i + n;
    }
}
