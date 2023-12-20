package Assignment3.copy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Snakes and Ladders game!");

        // Specify the number of players
        int numPlayers = 4;

        // Create an instance of SnakesAndLadders game
        SnakesAndLadders game = new SnakesAndLadders(numPlayers);

        // Start playing the game
        game.play();
    }
}

