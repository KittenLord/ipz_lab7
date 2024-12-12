package work7;

import java.util.Random;
import java.util.List;

public class InitializeTransaction implements Transaction {

    private List<String> keys;
    public InitializeTransaction(List<String> keys) {
        this.keys = keys;
    }

    public boolean Execute(Database database) {
        Random r = new Random();
        for(String key : keys) {
            int n = r.nextInt(10);
            if(!database.setValue(key, String.valueOf(n))) return false;
        }
        return true;
    }
}
