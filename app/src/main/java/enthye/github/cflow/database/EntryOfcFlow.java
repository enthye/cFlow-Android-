package enthye.github.cflow.database;

public class EntryOfcFlow {
    private long id;
    private String date;
    private String type;
    private double amount;
    private String description;

    public EntryOfcFlow(long id, String date, String type, double amount, String description) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public long getID() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return String.valueOf(getID());
    }
}