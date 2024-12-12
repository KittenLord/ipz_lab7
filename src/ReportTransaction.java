package work7;

import java.util.List;

public class ReportTransaction implements Transaction {

    private List<String> keys;
    public ReportTransaction(List<String> keys) {
        this.keys = keys;
    }

    public boolean Execute(Database database) {
        for(String key : keys) {
            String value = database.getValue(key);
            if(value == null) System.out.println("Couldn't find key " + key);
            else System.out.println("The value at the key " + key + " is " + value);
        }
        return true;
    }
}
