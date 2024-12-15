package dboperations;

import java.util.ArrayList;
import java.util.List;

/**
 * The TransactionManager class handles the execution of a sequence of commands
 * as a transaction. If an error occurs, it rolls back all executed commands.
 */
public class TransactionManager {
    private List<Command> commands = new ArrayList<>();

    /**
     * Adds a command to the transaction.
     *
     * @param command The command to add.
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * Executes all commands in the transaction. If an error occurs, rolls back
     * all previously executed commands.
     */
    public void execute() {
        System.out.println("Starting transaction...");
        try {
            for (Command command : commands) {
                command.execute();
            }
            System.out.println("Transaction committed.");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            rollback();
        }
    }

    /**
     * Rolls back all commands in the transaction in reverse order.
     */
    private void rollback() {
        System.out.println("Rolling back transaction...");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).rollback();
        }
    }
}
