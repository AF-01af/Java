import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game{
     ArrayList list;
     Scanner scan;

    public Game() {
        this.list = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }

    public void displayWelcome() {
        IO.println("Welcome to Sequence Guessing Game!");
    }

    public void NumberList() {
        IO.print("How many numbers would you like to guess? ");
        int size = scan.nextInt();

        for (int i = 1; i <= size; i++) {
            IO.print("Enter number " + i + " ");
            //noinspection unchecked
            list.add(scan.nextInt());
        }
        IO.println("List you have created: " + list);
    }

    public void shuffleList() {
        Collections.shuffle(list);
    }

    public void playNumberGame() {
        shuffleList();
        IO.println("List has been shuffled! Start guessing the sequence!");
        for (int i = 0; i < list.size(); i++) {
            Integer target = (Integer) list.get(i);
            int attempts = 2;
            boolean guessedCorrect = false;
            IO.print("Guess the number at position " + (i+1) + " ");
            while (attempts > 0) {
                IO.print("in "+ attempts + " attempts\n");
                int guess = scan.nextInt();
                if (guess == (target)) {
                    IO.println("Correct! Moving to next position...\n");
                    guessedCorrect = true;
                    break;
                } else {
                    if(guess<target)
                        IO.print("Too low!");
                    else
                        IO.print("Too high!");

                    attempts--;

                    if (attempts > 0) {
                        IO.println(" Try again.");
                    }
                }
            }
            if (!guessedCorrect) {
                IO.println("Out of attempts! The number was: " + target);
                failMenu();
                return;
            }

        }
        IO.println("🎉 Congratulations! You guessed all positions correctly!");
    }

    public int showMenu() {
        IO.println("1) Reshuffle same array");
        IO.println("2) Create new array");
        IO.println("3) Quit");
        IO.print("Choose option: ");
        return scan.nextInt();
    }

    private void failMenu() {
        int choice = showMenu();

        switch (choice) {
            case 1:
                playNumberGame();
                break;
            case 2:
                list.clear();
                NumberList();
                playNumberGame();
                break;
            case 3:
                IO.println("Thanks for playing!");
                break;
            default:
                IO.println("Invalid choice. Quitting...");
        }
    }
}
