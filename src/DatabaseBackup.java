package work7;

import java.util.Map;
import java.util.HashMap;

public class DatabaseBackup {
    private Map<String, String> data;
    
    public void remember(Map<String, String> data) {
        this.data = new HashMap<String, String>(data); // cloning the data
    }

    public Map<String, String> restore() {
        return data;
    }

    public void forget() {
        data = null;
    }
}
