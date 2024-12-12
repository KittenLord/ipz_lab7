package work7;

import java.util.List;

public class IncrementTransaction implements Transaction {

    private List<String> keys;
    public IncrementTransaction(List<String> keys) {
        this.keys = keys;
    }

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
