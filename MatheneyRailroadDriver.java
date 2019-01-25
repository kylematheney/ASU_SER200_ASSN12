
/**
 * Driver for MatheneyRailroad.java; Takes in input from user and ensures at least one car is provided.
 *
 * Time: 4 hours
 *
 * @author Kyle Matheney
 * @version 1.0
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MatheneyRailroadDriver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<String> orderIn = new LinkedList<>();
        Queue<String> orderOut = new LinkedList<>();
        MatheneyRailroad railroad;
        String input;

        System.out.println("Please type in the order of incoming cars. Type "
                + "DONE to stop");
        do {
            input = in.nextLine().toUpperCase(); // Used for readability

            if (!"DONE".equals(input)) {
                orderIn.add(input);
            }

            if (orderIn.isEmpty()) {
                System.out.println("You must enter at least one car.");
            }
        } while (!"DONE".equals(input) || orderIn.isEmpty());

        System.out.println("Please provide the desired output order. You must "
                + "provide as many outgoing as you did incoming.");
        for (int i = 0; i < orderIn.size(); i++) {
            orderOut.add(in.nextLine().toUpperCase());
        }

        railroad = new MatheneyRailroad(orderIn, orderOut);
        System.out.println(railroad.toString());
    }
}
