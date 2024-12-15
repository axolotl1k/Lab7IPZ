package dboperations;

import java.util.ArrayList;
import java.util.List;

/**
 * The Table class represents a simple database table that can store, delete,
 * and update records.
 */
public class Table {
    private List<String> data = new ArrayList<>();

    /**
     * Inserts a record into the table.
     *
     * @param record The record to insert.
     */
    public void insert(String record) {
        data.add(record);
        System.out.println("Inserted: " + record);
    }

    /**
     * Deletes a record from the table.
     *
     * @param record The record to delete.
     */
    public void delete(String record) {
        data.remove(record);
        System.out.println("Deleted: " + record);
    }

    /**
     * Updates an existing record in the table.
     *
     * @param oldRecord The record to update.
     * @param newRecord The new value of the record.
     */
    public void update(String oldRecord, String newRecord) {
        int index = data.indexOf(oldRecord);
        if (index != -1) {
            data.set(index, newRecord);
            System.out.println("Updated: " + oldRecord + " -> " + newRecord);
        }
    }

    /**
     * Displays all records in the table.
     */
    public void showData() {
        System.out.println("Current Table Data: " + data);
    }
}
