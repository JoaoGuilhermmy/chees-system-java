package application;

import java.util.Scanner;

import cheees.CheesMatch;
import cheees.CheesPiece;
import cheees.CheesPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        CheesMatch cheesMatch = new CheesMatch();

        while (true) {
            UI.printBoard(cheesMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            CheesPosition source = UI.readCheesPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            CheesPosition targert = UI.readCheesPosition(sc);

            CheesPiece capturedPiece = cheesMatch.perfomCheesMove(source, targert);
        }
    }

}
