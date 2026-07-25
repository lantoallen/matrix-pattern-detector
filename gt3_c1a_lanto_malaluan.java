import java.util.*;

public class gt3_c1a_lanto_malaluan {

    static boolean PatternSequence(int[][] numbers) {
        int size = numbers.length;
        boolean anyPatternFound = false;

        for (int step = 1; step <= 3; step++) {
            for (int i = 0; i < size; i++) {
                boolean found = false;
                for (int j = 0; j <= size - 3; j++) {
                    if (numbers[i][j + 1] == numbers[i][j] + step &&
                            numbers[i][j + 2] == numbers[i][j + 1] + step) {
                        System.out.println("Pattern found in Row " + i + " (step +" + step + "): [ " + numbers[i][j] + " " + numbers[i][j + 1] + " " + numbers[i][j + 2] + " ]");
                        found = true;
                        anyPatternFound = true;
                        break;
                    }
                }
            }
        }

        for (int step = 1; step <= 3; step++) {
            for (int j = 0; j < size; j++) {
                boolean found = false;
                for (int i = 0; i <= size - 3; i++) {
                    if (numbers[i + 1][j] == numbers[i][j] + step &&
                            numbers[i + 2][j] == numbers[i + 1][j] + step) {
                        System.out.println("Pattern found in Column " + j + " (step +" + step + "): [ " + numbers[i][j] + " " + numbers[i + 1][j] + " " + numbers[i + 2][j] + " ]");
                        found = true;
                        anyPatternFound = true;
                        break;
                    }
                }
            }
        }

        return anyPatternFound;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] numbers = new int[5][5];

        System.out.println("Enter 25 integers for a 5x5 array:");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                while (true) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    try {
                        if (sc.hasNextInt()) {
                            int value = sc.nextInt();
                            numbers[i][j] = value;
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter an integer.");
                            sc.next();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter an integer.");
                        sc.next();
                    }
                }
            }
        }

        System.out.println("\nMatrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nDetected Patterns:");
        boolean patternsFound = PatternSequence(numbers);
        if (!patternsFound) {
            System.out.println("No patterns found.");
        }

        sc.close();
    }
}