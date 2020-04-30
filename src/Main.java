import java.util.Scanner;

/**
 * Quaide Tranter
 * April 27, 2020
 * Intro to Data Engineering
 * Professor Greenwell
 *
 * Link to complete project on GitHub: https://github.com/quaide/word-suggestion-engine
 *
 * Drives the final coding assignment.
 */
public class Main {


    /**
     * Main method, initiates the program and allows testing
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        WordSuggestions wordEngine = new WordSuggestions();
        wordEngine.readingFile();

        BiGram bigram = new BiGram();
        bigram.treeMap(wordEngine.currentList);

        AffinityAnalysis analysis = new AffinityAnalysis();
        analysis.wordSupport(bigram.map);

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = userInput.nextLine().toLowerCase();
        analysis.Suggestion(word);

    }
}