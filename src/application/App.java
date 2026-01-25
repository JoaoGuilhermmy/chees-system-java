package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import cheees.ChessExcpition;
import cheees.ChessMatch;
import cheees.ChessPiece;
import cheees.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ChessMatch cheesMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(cheesMatch.getPieces());
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
            } catch (ChessExcpition e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }

}
