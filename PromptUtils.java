import java.util.Scanner;

public class PromptUtils {
    public static double pointsFor(Scanner input) {
        System.out.print("Enter points scored in a season: ");
        return Double.parseDouble(input.nextLine());
    }
    public static double pointsAgainst(Scanner input) {
        System.out.print("Enter points allowed in a season: ");
        return Double.parseDouble(input.nextLine());
    }
    public static double gamesPlayed(Scanner input) {
        System.out.print("Enter games played in a season: ");
        return Double.parseDouble(input.nextLine());
    }
}