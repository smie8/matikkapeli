import java.util.Scanner;

public class GameEngine {

    private final Scanner scanner;
    private int score;
    private boolean quitGame = false;

    public GameEngine() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        printIntro();
        runGameLoop();
    }

    private static void printIntro() {
        System.out.println("Tervetula pelaamaan Matikkapeliä!");
        System.out.println("Kirjoita \"lopeta\" ja paina enter, jos haluat poistua pelistä.");
        System.out.println();
    }

    private void runGameLoop() {
        while (true) {
            CalculationCreator calculationCreator = new CalculationCreator();
            int correctAnswer = calculationCreator.createCalculation();

            handleInput(correctAnswer);

            if (quitGame) {
                System.out.println("Kiitos kun pelasit!");
                break;
            }

            System.out.println("Pisteet: " + score + "\n");
        }
    }

    private void handleInput(int correctAnswer) {
        while (true) {
            try {
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("lopeta")) {
                    quitGame = true;
                    break;
                }

                if (correctAnswer == Integer.parseInt(input)) {
                    System.out.println("Oikein!");
                    score++;
                } else {
                    System.out.println("Väärin! Oikea vastaus oli " + correctAnswer + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Virhe! Syötä vain numeroita.");
            }
        }
    }
}
