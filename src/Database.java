package work7;

import java.util.Map;
import java.util.HashMap;

/**
 *  The class that describes a database that has a state that can be memento'ed
 */
public class Database {

    /**
     *  The internal state
     */
    private Map<String, String> data;

    /**
     *  The object that stores the internal state
     */
    private DatabaseBackup backup;

    /**
     *  The constructor that generates an empty database
     */
    public Database() { data = new HashMap<>(); backup = new DatabaseBackup(); }

    /**
     *  A method that returns a value associated with the key
     *  @param key The key
     *  @return The value at the key (null if doesn't exist)
     */
    public String getValue(String key) {
        if(data.containsKey(key)) return data.get(key);
        return null;
    }

    /**
     *  A method that sets the value at key to value
     *  @param key The key
     *  @param value The value
     *  @return true if success
     */
    public boolean setValue(String key, String value) {
        if(!validateKey(key)) return false;
        data.put(key, value);
        return true;
    }

    /**
     *  The method to validate a key
     *  @return True if key is valid
     */
    public boolean validateKey(String key) {
        if(key.contains(" ")) return false;
        return true;
    }

    /**
     *  A method to run a transaction
     *  @param transaction The transaction to be run
     *  @return The result of the transaction
     */
    public boolean runTransaction(Transaction transaction) {
        backup.remember(this.data);
        boolean result = transaction.Execute(this);
        if(!result) this.data = backup.restore();
        backup.forget();

        return result;
    }
}
