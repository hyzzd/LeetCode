import java.util.*;

class Main {
    public enum Type {
        K(0), P(1), N(2), Q(3), R(4), B(5)
    }

    class Piece {
        Type t;
        Location l;

        public Piece(Type typ, Location loc) {
            t = typ;
            l = loc;
        }
    }

    class Location {
        int x;
        int y;

        public Location(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public List<Piece> readBoard(char[][] matrix) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char c = matrix[i][j];
                if (c == '.') {
                    continue;
                }

                Type pt = Type(c);
                Location loc = new Location(x, y);
                Piece piece = new Piece(pt, loc);
                if (pt == Type.K) {
                    pieces.add(0, piece);
                } else {
                    pieces.add(piece);
                }
            }
        }

        return pieces;
    }

    public boolean isCheckByPiece(Location kl, Piece p) {
        boolean straightAttack = p.l.x == kl.x || p.l.y == kl.y;
        int dx = Math.abs(p.l.x - kl.x);
        int dy = Math.abs(p.l.y - kl.y);
        boolean diagonalAttack = dx == dy;
        boolean knightAttack = dx * dy == 2;
        boolean pawnAttack = (p.l.y == kl.x - 1 || p.l.y == kl.x + 1) && p.l.x == kl.x + 1;

        if (p.t == Type.p) {
            return pawnAttack;
        } else if (p.t == Type.N) {
            return knightAttack;
        } else if (p.t == Type.R) {
            return straightAttack;
        } else if (p.t == Type.B) {
            return diagonalAttack;
        } else if (p.t == Type.Q) {
            return diagonalAttack || straightAttack;
        }

        return false;
    }

    public boolean inCheck(char[][] matrix) {
        List<Piece> pieces = readBoard(matrix);
        Piece king = pieces.get(0);
        for (int i = 1; i < pieces.size(); i++) {
            if (isCheckByPiece(king.l, pieces.get(i))) {
                return true;
            }
        }

        return false;
    }
}