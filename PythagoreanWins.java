import java.text.DecimalFormat;
import java.util.Scanner;

public class PythagoreanWins {
    private static final double EXPONENT = 2.37;
    private static final DecimalFormat df = new DecimalFormat("#.#");
    public static void main(String[] args) {
        pythagoreanWinLossService();
    }
    public static void pythagoreanWinLossService() {
        System.out.println("| Predicted win/loss calculator |");
        try (Scanner input = new Scanner(System.in)) {
            final double POINTS_FOR = PromptUtils.pointsFor(input);
            final double POINTS_AGAINST = PromptUtils.pointsAgainst(input);
            final double GAMES_PLAYED = PromptUtils.gamesPlayed(input);
            final double PYTHAGOREAN_WINS = pythagoreanWins(POINTS_FOR, POINTS_AGAINST, GAMES_PLAYED);
            final double PYTHAGOREAN_LOSSES = pythagoreanLosses(POINTS_FOR, POINTS_AGAINST, GAMES_PLAYED);
            System.out.println("Expected win/loss record for the season: " + df.format(PYTHAGOREAN_WINS) + "-" + df.format(PYTHAGOREAN_LOSSES));
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public static double pythagoreanWins(double pointsFor, double pointsAgainst, double gamesPlayed) {
        double numerator = Math.pow(pointsFor, EXPONENT);
        double denominator = numerator + Math.pow(pointsAgainst, EXPONENT);
        return (numerator/denominator) * gamesPlayed;
    }
    public static double pythagoreanLosses(double pointsFor, double pointsAgainst, double gamesPlayed) {
        return gamesPlayed - pythagoreanWins(pointsFor, pointsAgainst, gamesPlayed);
    }
}