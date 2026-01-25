package cheees;

import boardgame.Board;
import boardgame.Piece;

public abstract class CheesPiece extends Piece {

    private Color color;

    public CheesPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
