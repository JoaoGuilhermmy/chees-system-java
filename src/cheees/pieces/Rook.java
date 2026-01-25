package cheees.pieces;

import boardgame.Board;
import cheees.CheesPiece;
import cheees.Color;

public class Rook extends CheesPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumn()];
        return mat;
    }
}
