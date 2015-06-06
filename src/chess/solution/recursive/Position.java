package chess.solution.recursive;

/**
 * Created by us on 05/06/15.
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + y;
        result = prime * result + x;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (y != other.y)
            return false;
        if (x != other.x)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("[%s - %s]", x, y);
    }
}

