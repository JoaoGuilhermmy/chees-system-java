package application;

import cheees.CheesMatch;

public class App {
    public static void main(String[] args) throws Exception {
        CheesMatch cheesMatch = new CheesMatch();
        UI.printBoard(cheesMatch.getPieces());
    }
}
