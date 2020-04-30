import java.util.ArrayList;
import java.util.Map;

/**
 * Splits hashmap into three separate ArrayList. Split by first word, second word, and frequency of pair.
 * "Support" is determined by user input. Words with 65 percent or higher "support" are suggested to
 * user.
 */
public class AffinityAnalysis {

    ArrayList<String> firstWord = new ArrayList<>();
    ArrayList<String> lastWord = new ArrayList<>();
    ArrayList<Integer> occurrence = new ArrayList<>();

    /**
     * @param map word pairs and frequency
     */
    public void wordSupport(Map<ArrayList<String>, Integer> map) {
        map.forEach((key, value) -> firstWord.add(new ArrayList<>(key).get(0)));
        map.forEach((key, value) -> lastWord.add(new ArrayList<>(key).get(1)));
        map.forEach((key, value) -> occurrence.add(value));
    }

    /**
     * @param word user input
     */
    public void Suggestion(String word) {
        ArrayList<Integer> indexForSecondWord = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < firstWord.size(); i++) {
            if (word.equals(firstWord.get(i))) {
                total += occurrence.get(i);
                indexForSecondWord.add(i);
            }
        }
        for (Integer integer : indexForSecondWord) {
            double percent = (occurrence.get(integer) / (double) total) * 100;
        }
        for (Integer integer : indexForSecondWord) {
            if (((occurrence.get(integer) / (double) total) * 100 > 65)) {
                System.out.println("\n" +
                        "Your next word might be: " + "\"" + lastWord
                        .get(integer) + "\"");
                return;
            }
        }
        System.out.println(
                "Your next word might be: " + "\"the\", \"this\" , \"of\"");
    }
}