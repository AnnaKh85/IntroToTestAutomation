package org.gb;

import java.util.Random;

public class MontyHallGame {
    private int totalGames;
    private int switchWins;
    private int stayWins;
    private Random rand;

    public MontyHallGame(int totalGames) {
        if (totalGames <= 0) {
            throw new IllegalArgumentException("Total games must be a positive integer.");
        }

        this.totalGames = totalGames;
        this.switchWins = 0;
        this.stayWins = 0;
        this.rand = new Random();
    }

    public void simulateGames() {
        for (int i = 0; i < totalGames; i++) {
            int prizeDoor = rand.nextInt(3);
            int chosenDoor = rand.nextInt(3);

            int revealedDoor;
            do {
                revealedDoor = rand.nextInt(3);
            } while (revealedDoor == prizeDoor || revealedDoor == chosenDoor);

            boolean switchDoors = rand.nextBoolean();
            if (switchDoors) {
                chosenDoor = 3 - chosenDoor - revealedDoor;
            }

            if (chosenDoor == prizeDoor) {
                if (switchDoors) {
                    switchWins++;
                } else {
                    stayWins++;
                }
            }
        }
    }

    public int getSwitchWins() {
        return switchWins;
    }

    public int getStayWins() {
        return stayWins;
    }
}
