package enthye.github.cflow.database;

import android.provider.BaseColumns;

public final class EntryContract {

    private EntryContract() {}

    public static class EntryFeed implements BaseColumns {
        public static final String TABLE_NAME = "cFlow";

        // main columns
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_DESCRIPTION = "description";
    }
}
