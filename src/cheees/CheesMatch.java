package cheees;

import boardgame.Board;

public class CheesMatch {
    private Board board;

    public CheesMatch() {
        board = new Board(8, 8);
    }

    public CheesPiece[][] getPieces() {
        CheesPiece[][] mat = new CheesPiece[board.getRows()][board.getColumn()];

        for (int i = 0; i < board.getRows(); i++) {

            for (int j = 0; j < board.getColumn(); j++) {
                mat[i][j] = (CheesPiece) board.piece(i, j);
            }
        }

        return mat;
    }
}
