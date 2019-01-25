
/**
 * Checks if incoming train cars can be arranged to preferred outgoing order using a holding queue
 *
 * Time: 4 hours
 *
 * @author Kyle Matheney
 * @version 1.0
 */
import java.util.Queue;
import java.util.Stack;

public class MatheneyRailroad {

    private static Queue<String> incoming;
    private static Queue<String> outgoing;
    private static Stack waitingStack = new Stack();
    private static String waiting;

    public MatheneyRailroad(Queue in, Queue out) {
        incoming = in;
        outgoing = out;
    }

    /**
     * Determines if any further comparisons can be made based on the current
     * items in incoming, waitingStack, and outgoing
     *
     * @return true unless waitingStack isn't empty, the current item in
     * waitingStack doesn't match the current item in outgoing, and incoming is
     * empty
     */
    private boolean sortIsPossible() {
        boolean result = true;

        if (!waitingStack.isEmpty()) {
            waiting = waitingStack.peek().toString();
            if (!compare(waiting, outgoing.element())) {
                if (incoming.isEmpty()) {
                    result = false;
                }
            }
        }
        return result;
    }

    private boolean compare(String in, String out) {
        boolean result = false;

        if (in.equals(out)) {
            result = true;
        }
        return result;
    }

    private void move() { // moves current element in incoming to waitingStack
        waitingStack.add(incoming.element());
        incoming.remove();
    }

    /**
     * Removes the current item from outgoing and either waitingStack or
     * incoming
     *
     * @param isWaiting = true to remove item from waitingStack. false to remove
     * from incoming
     */
    private void removeMatches(boolean isWaiting) {
        System.out.println("POP GOES THE WEASEL! - " + outgoing.remove());
        if (isWaiting) {
            waitingStack.pop();
        } else {
            incoming.remove();
        }
    }

    private void checkIncoming() {
        if (compare(incoming.element(), outgoing.element())) {
            removeMatches(false);
        } else {
            move();
        }
    }

    private void checkWaiting() {
        waiting = waitingStack.peek().toString();

        System.out.println("Comparing Waiting: " + waiting + "\tto Out: " + outgoing.element()); // DELETE
        if (compare(waiting, outgoing.element())) {
            removeMatches(true);
        } else if (!incoming.isEmpty()) {
            System.out.println("checkWaiting() - Comparing Incoming: " + incoming.element() + "\tto Out: " + outgoing.element()); // DELETE
            checkIncoming();
        }
    }

    private boolean compareLists() {
        boolean result = false;

        do {
            if (!sortIsPossible()) { // strings cannot be matched if this runs
                break;
            }

            if (!waitingStack.isEmpty()) {
                checkWaiting();
            } else {
                System.out.println("compareLists() - Comparing Incoming: " + incoming.element() + "\tto Out: " + outgoing.element()); // DELETE
                checkIncoming();
            }

            System.out.println("\nIncoming: " + incoming); // DELETE
            System.out.println("Outgoing: " + outgoing); // DELETE
            System.out.println("Waiting:" + waitingStack); // DELETE

        } while (!outgoing.isEmpty());

        if (outgoing.isEmpty()) {
            result = true; // only condition to make method return true
        }
        return result;
    }

    @Override
    public String toString() {
        return compareLists()
                ? "The input was successfully matched to the output!"
                : "The input could not be successfully matched to the output!";
    }
}
