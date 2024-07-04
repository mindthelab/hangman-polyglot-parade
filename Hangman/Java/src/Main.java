import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Variables r = new Variables();
        Scanner scanner = new Scanner(System.in);

        int len = r.word.length();
        List<String> table = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            table.add("_");
        }

        System.out.printf("Your word has %d letters!\n", len);
        System.out.printf("You have %d lives!\n", r.life);

        while (r.game) {
            System.out.println(table);
            System.out.println("A letter: ");
            r.guess = scanner.nextLine();

            if (r.word.contains(r.guess)) {
                for (int i = 0; i < len; i++) {
                    if (r.guess.equals(String.valueOf(r.word.charAt(i)))) {
                        table.set(i, r.guess);
                    }
                }

            } else {
                r.life--;
                System.out.printf("You have %d lives remaining...\n", r.life);

            }

            if (r.life == 0) {
                r.game = false;
                System.out.printf("You lost! the word was %s!", r.word);
            }

            if (!table.contains("_")) {
                r.game = false;
                System.out.printf("You won with %d lives! the word was %s", r.life, r.word);
            }

        }

    }
}
//cant bear a language with more than 2 prints