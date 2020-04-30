import java.util.Scanner;

/**
 * Serves as the driver class where all other classes and their methods are called. The program
 * accepts single worded answers and based on prior messages it suggests a next word.
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