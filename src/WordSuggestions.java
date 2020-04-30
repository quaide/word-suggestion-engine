import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads from "messages.txt" and writes to ArrayList. Each line is one unit
 * in the data structure.
 */
public class WordSuggestions {

    public ArrayList<String> currentList = new ArrayList<>();
    public File messages = new File("src/Data/messages.txt");

    public void readingFile() {
        String currentLine = null;

        try {
            Scanner readingMessages = new Scanner(messages);
            while (readingMessages.hasNextLine()) {
                String line = readingMessages.nextLine().toLowerCase();
                currentList.add(line);
            }
            readingMessages.close();
        } catch (Exception e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

    }

    /**
     * Print ArrayList
     */
    public void printList() {
        System.out.println(currentList);
    }

}