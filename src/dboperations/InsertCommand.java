package dboperations;

/**
 * The InsertCommand class handles inserting a record into a database table.
 * It supports rollback by removing the inserted record if needed.
 */
public class InsertCommand implements Command {
    private Table receiver;
    private String record;

    /**
     * Constructs an InsertCommand.
     *
     * @param receiver The table where the record will be inserted.
     * @param record The record to insert into the table.
     */
    public InsertCommand(Table receiver, String record) {
        this.receiver = receiver;
        this.record = record;
    }

    @Override
    public void execute() {
        System.out.println("Executing InsertCommand for: " + record);
        receiver.insert(record);
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back InsertCommand for: " + record);
        receiver.delete(record);
    }
}
