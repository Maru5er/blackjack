import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Play Blackjack. Input deck in shoe and bet count (<deck in shoe> <count>) ");
        String[] input = scanner.nextLine().split(" ");
        int deckInShoe = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        cardCounter game = new cardCounter(deckInShoe, count);
        String cardInput = "";
        while (!cardInput.equals("quit")) {
            System.out.print("cards: ");
            cardInput = scanner.nextLine();
            game.computeRunningCount(cardInput);
            System.out.println("card left: " + game.cardLeftToString());
            System.out.println("running count: " + game.runningCountToString());
            System.out.println("true count: " + game.trueCountToString());
            System.out.println("bet: " + game.computeBet());
            System.out.println("--------------------");
        }
    }
}
