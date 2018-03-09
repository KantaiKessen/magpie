import java.util.ArrayList;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 * Uses indexOf to find strings
 * </li><li>
 * Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2 {
    public boolean removed = true;
    private Scanner s = new Scanner(System.in);
    private ArrayList<String> item = new ArrayList<>();
    private ArrayList<String> information = new ArrayList<>();

    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        if (statement.contains("remember")) {
            addToMemory();
            return "Item remembered";
        }
        if (statement.contains("recall")) {
            getFromMemory();
            return "Recall Complete";
        }
        if (statement.contains("no"))
            response = "Why so negative?";
        else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother")
                || statement.contains("family")) {
            response = "Tell me more about your family.";
        }
        else if (statement.contains("Computer Science"))
            response = "Yes, it is my favorite course.";
        else if (statement.contains("yourself"))
            response = "I was created for the 2015 test.";
        else if (statement.contains("feared"))
            response = "FEARED.";
        else if (statement.contains("questions")
                && statement.contains("me"))
            response = "No, I am not interested in humans.";
        else {
            response = getRandomResponse();
        }
        return response;
    }

    private void addToMemory() {
        System.out.println("OK, what is the name of the thing you want me to remember?");
        item.add(s.nextLine());
        System.out.println("Now tell me what you want me to remember");
        information.add(s.nextLine());
    }

    private void getFromMemory() {
        System.out.println("What is the name of the thing you want me to recall");
        String inputStatement = s.nextLine();
        System.out.println(item.contains(inputStatement) ? information.get(item.indexOf(inputStatement)) : "I could not find that");
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        switch (whichResponse) {
            case 0:
                response = "Interesting, tell me more.";
                break;
            case 1:
                response = "Hmmm.";
                break;
            case 2:
                response = "Do you really think so?";
                break;
            case 3:
                response = "You don't say.";
                break;
        }
        return response;
    }
}
