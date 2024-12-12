package work7;

import java.util.Random;
import java.util.List;

/**
 *  The class that describes a trasaction that tries to initialize the keys with random values
 */
public class InitializeTransaction implements Transaction {

    /**
     *  The keys that need to be initialized
     */
    private List<String> keys;

    /**
     *  The constructor for the transaction
     *  @param keys The keys to be initialized
     */
    public InitializeTransaction(List<String> keys) {
        this.keys = keys;
    }

    /**
     *  The method that tries to initialize the specified keys with random values
     *  @param database The target database
     *  @return The result of the transaction
     */
    public boolean Execute(Database database) {
        Random r = new Random();
        for(String key : keys) {
            int n = r.nextInt(10);
            if(!database.setValue(key, String.valueOf(n))) return false;
        }
        return true;
    }
}
