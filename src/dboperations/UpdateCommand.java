package dboperations;

/**
 * The UpdateCommand class handles updating a record in a database table.
 * It supports rollback by reverting the record to its previous state if needed.
 */
public class UpdateCommand implements Command {
    private Table receiver;
    private String oldRecord;
    private String newRecord;

    /**
     * Constructs an UpdateCommand.
     *
     * @param receiver The table where the record will be updated.
     * @param oldRecord The existing record to update.
     * @param newRecord The new value for the record.
     */
    public UpdateCommand(Table receiver, String oldRecord, String newRecord) {
        this.receiver = receiver;
        this.oldRecord = oldRecord;
        this.newRecord = newRecord;
    }

    @Override
    public void execute() {
        System.out.println("Executing UpdateCommand: " + oldRecord + " -> " + newRecord);
        receiver.update(oldRecord, newRecord);
    }

    @Override
    public void rollback() {
        System.out.println("Rolling back UpdateCommand: " + newRecord + " -> " + oldRecord);
        receiver.update(newRecord, oldRecord);
    }
}
