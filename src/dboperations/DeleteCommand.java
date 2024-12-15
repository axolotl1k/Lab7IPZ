package dboperations;

/**
 * The DeleteCommand class handles deleting a record from a database table.
 * It supports rollback by re-inserting the deleted record if needed.
 */
public class DeleteCommand implements Command {
    private Table receiver;
    private String record;

    /**
     * Constructs a DeleteCommand.
     *
     * @param receiver The table from which the record will be deleted.
     * @param record The record to delete from the table.
     */
    public DeleteCommand(Table receiver, String record) {
        this.receiver = receiver;
        this.record = record;
    }

    @Override
    public void execute() {
        System.out.println("Executing DeleteCommand for: " + record);
        receiver.delete(record);
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back DeleteCommand for: " + record);
        receiver.insert(record);
    }
}
