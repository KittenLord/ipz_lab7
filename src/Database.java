package work7;

import java.util.Map;
import java.util.HashMap;

public class Database {

    private Map<String, String> data;
    private DatabaseBackup backup;

    public Database() { data = new HashMap<>(); backup = new DatabaseBackup(); }

    public String getValue(String key) {
        if(data.containsKey(key)) return data.get(key);
        return null;
    }

    public boolean setValue(String key, String value) {
        if(!validateKey(key)) return false;
        data.put(key, value);
        return true;
    }

    public boolean validateKey(String key) {
        if(key.contains(" ")) return false;
        return true;
    }

    public boolean runTransaction(Transaction transaction) {
        backup.remember(this.data);
        boolean result = transaction.Execute(this);
        if(!result) this.data = backup.restore();
        backup.forget();

        return result;
    }
}
