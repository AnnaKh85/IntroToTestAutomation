package org.gb;

public class Main {
    public static void main(String[] args) {
        int totalGames = 1000;

        MontyHallGame game = new MontyHallGame(totalGames);
        game.simulateGames();

        System.out.println("Monty Hall Simulation Results (Total Games: " + totalGames + ")");
        System.out.println("Switching doors wins: " + game.getSwitchWins() + " times.");
        System.out.println("Staying with original choice wins: " + game.getStayWins() + " times.");
    }
}