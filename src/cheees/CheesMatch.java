package cheees;

import boardgame.Board;
import boardgame.Position;
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

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITHE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITHE), new Position(7, 4));
    }
}
