package cheees;

import boardgame.Board;
import cheees.pieces.King;
import cheees.pieces.Rook;

public class CheesMatch {
    private Board board;

    public CheesMatch() {
        board = new Board(8, 8);
        initialSetup();
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

    private void placeNewPiece(char column, int row, CheesPiece piece) {
        board.placePiece(piece, new CheesPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITHE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITHE));
    }
}
