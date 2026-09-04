import java.util.Random;
import java.util.Scanner;

class RockPaperScissors {

    // Suggested method
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] moves = {"Rock", "Paper", "Scissors"};

        // Store results for summary
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        System.out.println("=== Rock-Paper-Scissors Game ===");

        for (int i = 0; i < rounds; i++) {

            // Get player's move
            System.out.print("\nRound " + (i + 1) +
                    " - Enter Rock, Paper, or Scissors: ");

            String playerMove = scanner.nextLine();

            // Validate input
            while (!playerMove.equalsIgnoreCase("Rock") &&
                   !playerMove.equalsIgnoreCase("Paper") &&
                   !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine();
            }

            // Format player's input
            playerMove = capitalize(playerMove);

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(3)];

            // Determine winner
            String result = playRound(playerMove, computerMove);

            // Store round information
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            // Update scores
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Display round result
            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
        }

        // Calculate win percentage
        double winPercentage = (double) wins / rounds * 100;

        // Final summary
        System.out.println("\n==============================================");
        System.out.println("              FINAL SUMMARY");
        System.out.println("==============================================");

        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        System.out.println("----------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-17s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("----------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win %%: %.1f%%%n", winPercentage);

        scanner.close();
    }

    // Converts input such as "rock" -> "Rock"
    public static String capitalize(String move) {
        return move.substring(0, 1).toUpperCase()
                + move.substring(1).toLowerCase();
    }
}
