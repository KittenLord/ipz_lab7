package work7;

/**
 *  An interface that describes a database transaction
 */
public interface Transaction {

    /**
     *  A method that executes the transaction on a database
     *  @param database The target database
     *  @return The result of the transaction
     */
    public boolean Execute(Database database);
}
