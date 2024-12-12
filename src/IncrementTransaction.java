package work7;

import java.util.List;

/**
 *  The transaction that increments all specified keys
 */
public class IncrementTransaction implements Transaction {

    /**
     *  The keys to be used
     */
    private List<String> keys;

    /**
     *  The constructor for the IncrementTransaction
     *  @param keys The keys to be incremented
     */
    public IncrementTransaction(List<String> keys) {
        this.keys = keys;
    }

    /**
     *  The method that increments all specified keys
     *  @param database The target database
     *  @return The result of the transaction
     */
    public boolean Execute(Database database) {
        for(String key : keys) {
            String amountStr = database.getValue(key);
            if(amountStr == null) return false;

            int amount;
            try {
                amount = Integer.parseInt(amountStr);
            }
            catch(NumberFormatException e) { return false; }

            amount++;
            if(!database.setValue(key, String.valueOf(amount))) return false;
        }
        return true;
    }
}
