package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessExcpition;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ChessMatch cheesMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!cheesMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(cheesMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readCheesPosition(sc);

                boolean[][] possibleMoves = cheesMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(cheesMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition targert = UI.readCheesPosition(sc);

                ChessPiece capturedPiece = cheesMatch.perfomCheesMove(source, targert);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
            } catch (ChessExcpition e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(cheesMatch, captured);
    }

}
