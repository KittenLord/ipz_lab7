package work7;

import java.util.List;

/**
 *  The transaction that gets all specified keys' values and prints their values
 */
public class ReportTransaction implements Transaction {

    /**
     *  The keys to be retrieved
     */
    private List<String> keys;

    /**
     *  The constructor for ReportTransaction
     *  @param keys The keys to be retrieved
     */
    public ReportTransaction(List<String> keys) {
        this.keys = keys;
    }

    /**
     *  The method to retrieve and print all specified keys
     *  @param database The target database
     *  @return Always true
     */
    public boolean Execute(Database database) {
        for(String key : keys) {
            String value = database.getValue(key);
            if(value == null) System.out.println("Couldn't find key " + key);
            else System.out.println("The value at the key " + key + " is " + value);
        }
        return true;
    }
}
