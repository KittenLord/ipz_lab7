package work7;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  The main class of the program
 */
public class Main {

    /**
     *  The entry point of the program
     *  @param args The arguments of the program
     */
    public static void main(String[] args) {

        List<String> abc = Arrays.asList("a", "b", "c");
        List<String> ab = Arrays.asList("a", "b");
        List<String> c = Arrays.asList("c");

        Database database = new Database();
        Transaction transaction;
        boolean result;

        // Initialize a b
        transaction = new InitializeTransaction(ab);
        result = database.runTransaction(transaction);
        System.out.println("\n");

        // Report all
        transaction = new ReportTransaction(abc);
        result = database.runTransaction(transaction);
        System.out.println("\n");

        // Increment all
        transaction = new IncrementTransaction(abc);
        result = database.runTransaction(transaction);
        System.out.println("\n");

        // Report all
        transaction = new ReportTransaction(abc);
        result = database.runTransaction(transaction);
        System.out.println("\n");

        // Intitialize c
        transaction = new InitializeTransaction(c);
        result = database.runTransaction(transaction);
        System.out.println("\n");

        // Increment all
        transaction = new IncrementTransaction(abc);
        result = database.runTransaction(transaction);
        System.out.println("\n");

        // Report all
        transaction = new ReportTransaction(abc);
        result = database.runTransaction(transaction);
        System.out.println("\n");
    }
}
