package dboperations;

/**
 * The Command interface defines the structure for commands that operate
 * on a database table. Each command must provide logic for execution
 * and rollback in case of errors.
 */
public interface Command {
    /**
     * Executes the command.
     */
    void execute();

    /**
     * Rolls back the command.
     */
    void rollback();
}
