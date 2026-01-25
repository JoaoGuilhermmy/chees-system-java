package cheees.pieces;

import boardgame.Board;
import cheees.CheesPiece;
import cheees.Color;

public class King extends CheesPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumn()];
        return mat;
    }
}
