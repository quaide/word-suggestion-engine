import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Creates a hashmap of the "messages.txt" file to be used for the word suggestion engine.
 * A standard BiGram algorithm is applied to contribute to word suggestion, using
 * affinity analysis.
 */
public class BiGram {

    public Map<ArrayList<String>, Integer> map = new HashMap<>();

    /**
     * Frequency of pairs of words from each line.
     *
     * @param currentList lines from messages.txt
     */
    public void treeMap(ArrayList<String> currentList) {

        for (String s : currentList) {
            String[] list = s.split("\\s");
            for (int j = 1; j < list.length; j++) {
                map.merge(new ArrayList<>(Arrays.asList(list[j - 1], list[j])), 1, Integer::sum);
            }
        }

    }

    /**
     * Print hashmap.
     */
    public void printWordsByValue() {
        map.forEach((key, value) -> System.out.println(key + "," + value));

    }

}