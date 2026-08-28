import java.util.Random;
import java.util.Scanner;

public class Main {
    final static String[] sonnet = {
        "Shall", "I", "compare", "thee", "to", "a", "summer’s", "day?", "\n",
        "Thou", "art", "more", "lovely", "and", "more", "temperate:", "\n",
        "Rough", "winds", "do", "shake", "the", "darling", "buds", "of", "May,", "\n",
        "And", "summer’s", "lease", "hath", "all", "too", "short", "a", "date;", "\n",
        "Sometime", "too", "hot", "the", "eye", "of", "heaven", "shines,", "\n",
        "And", "often", "is", "his", "gold", "complexion", "dimm’d;", "\n",
        "And", "every", "fair", "from", "fair", "sometime", "declines,", "\n",
        "By", "chance", "or", "nature’s", "changing", "course", "untrimm'd;", "\n",
        "But", "thy", "eternal", "summer", "shall", "not", "fade,", "\n",
        "Nor", "lose", "possession", "of", "that", "fair", "thou", "ow’st;", "\n",
        "Nor", "shall", "death", "brag", "thou", "wander’st", "in", "his", "shade,", "\n",
        "When", "in", "eternal", "lines", "to", "time", "thou", "grow’st:", "\n",
        "\t", "So", "long", "as", "men", "can", "breathe", "or", "eyes", "can", "see,", "\n",
        "\t", "So", "long", "lives", "this,", "and", "this", "gives", "life", "to", "thee.", "\n",
    };

    public static void main (String[] args) {
        Random rand = new Random();

        boolean debug = false;
        for (int argNum = 0; argNum < args.length; argNum++) {
            if (args[argNum].equals("--debug")) {
                debug = true;
            }
            else if ((args[argNum].equals("--seed") || args[argNum].equals("-s")) && args.length > argNum + 1) {
                long seed = Long.parseLong(args[argNum + 1]);
                rand.setSeed(seed);
                System.out.println("[DEBUG] Seed = " + seed);
            }
        }

        Scanner scanner = new Scanner(System.in);

        int numCorrect = 0;
        int numIncorrect = 0;
        while (numCorrect < 3 && numIncorrect < 3) {
            int wordToStop = rand.nextInt(0, sonnet.length);
            if (debug) System.out.println("[DEBUG] Word to Stop: " + wordToStop);
            for (int wordNum = 0; wordNum < wordToStop; wordNum++) {
                String word = sonnet[wordNum];
                System.out.print(sonnet[wordNum]);
                if (!word.contains("\n") && !word.contains("\t")) System.out.print(" ");
            }
            System.out.println("_____ ");
            System.out.print("Enter the next word: ");
            String userWord = scanner.nextLine();
            if (userWord.equals(sonnet[wordToStop].replaceAll("[;:]$", ""))) {
                System.out.println("Correct!");
                numCorrect++;
            }
            else {
                System.out.println("Incorrect!");
                numIncorrect++;
            }
            System.out.println("-------------------------------------------------------------");
        }
        if (numCorrect >= 3) System.out.println("Congratulations! You Win!");
        else System.out.println("Sorry! You Lose!");
    }
}
