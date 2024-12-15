import dboperations.*;

/**
 * The Main class demonstrates the usage of the Command pattern
 * for performing database table operations with transactional support.
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        TransactionManager transactionManager = new TransactionManager();

        // Create commands
        Command insert1 = new InsertCommand(table, "Record1");
        Command insert2 = new InsertCommand(table, "Record2");
        Command insert3 = new InsertCommand(table, "Record3");
        Command delete1 = new DeleteCommand(table, "Record1");
        Command update1 = new UpdateCommand(table, "Record2", "UpdatedRecord2");

        // Add commands to transaction
        transactionManager.addCommand(insert1);
        transactionManager.addCommand(insert2);
        transactionManager.addCommand(insert3);
        transactionManager.addCommand(delete1);
        transactionManager.addCommand(update1);

        // Execute transaction
        transactionManager.execute();

        // Display final table state
        table.showData();
    }
}
