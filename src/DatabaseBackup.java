package work7;

import java.util.Map;
import java.util.HashMap;

/**
 *  The object that stores the backup of a database
 */
public class DatabaseBackup {

    /**
     *  The backed up data of the database
     */
    private Map<String, String> data;
    
    /**
     *  The method to set backed up data
     *  @param data The database's data
     */ 
    public void remember(Map<String, String> data) {
        this.data = new HashMap<String, String>(data); // cloning the data
    }

    /**
     * A method to restore the backed up data
     * @return The remembered data
     */
    public Map<String, String> restore() {
        return data;
    }

    /**
     *  A method to free the memory of the backed up data
     */
    public void forget() {
        data = null;
    }
}
