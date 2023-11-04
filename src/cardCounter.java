import java.util.*;
public class cardCounter {
    private int runningCount;
    private double trueCount;
    private int deckInShoe;
    private int cardLeft;
    private int count;

    public cardCounter(int deck, int count) {
        deckInShoe = deck;
        runningCount = 0;
        trueCount = 0;
        cardLeft = deckInShoe * 52;
        this.count = count;
    }

    public void computeRunningCount(String cards) {
        char[] cardsArray = cards.toCharArray();
        for (char c : cardsArray) {
            String low = "123456";
            String high = "ajqk0";
            if (low.contains(""+c)) {
                runningCount++;
            } else if (high.contains(""+c)) {
                    runningCount--;
                }
        }
        cardLeft -= cardsArray.length;
        computeTrueCount();
    }

    public void computeTrueCount() {
        trueCount = runningCount / (double)((cardLeft / 13) / 4);
    }

    public double computeBet() {
        if (trueCount < 0) return count;
        return count + count * trueCount;
    }

    public String trueCountToString() {
        return "" + trueCount;
    }

    public String runningCountToString() {
        return "" + runningCount;
    }

    public String cardLeftToString(){
        return "" + cardLeft;
    }
}
