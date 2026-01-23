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
}
