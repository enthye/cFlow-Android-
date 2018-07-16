package enthye.github.cflow.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import enthye.github.cflow.database.EntryContract.EntryFeed;

public class EntryDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_TITLE = "cFlow.db";

    private static final String DB_CREATE = "CREATE TABLE IF NOT EXISTS "
            + EntryFeed.TABLE_NAME + "("
            + EntryFeed.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EntryFeed.COLUMN_DATE + " TEXT NOT NULL,"
            + EntryFeed.COLUMN_TYPE + " TEXT NOT NULL,"
            + EntryFeed.COLUMN_AMOUNT + " DOUBLE NOT NULL,"
            + EntryFeed.COLUMN_DESCRIPTION + " TEXT NOT NULL);";

    private static final String DB_DELETE = "DROP TABLE IF EXISTS "
            + EntryFeed.TABLE_NAME;

    public EntryDBHelper(Context context) {
        super(context, DB_TITLE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // yet to implement properly
        db.execSQL(DB_DELETE);
        onCreate(db);
    }

    // adds data to list
    public boolean addEntryToDB(String date, String type, double amount, String description) {
        SQLiteDatabase db = getWritableDatabase();

        // get the entry values from forms and insert into db
        ContentValues entryValues = getContentValue(date, type, amount, description);

        long result = db.insert(EntryFeed.TABLE_NAME, null, entryValues);
        db.close();
        return result != -1;
    }

    public boolean updateEntry(long id, String date, String type, double amount, String description) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues entryValues = getContentValue(date, type, amount, description);

        long result = db.update(EntryFeed.TABLE_NAME, entryValues, EntryFeed.COLUMN_ID + " = ?",
                new String[]{Long.toString(id)});
        db.close();
        return result != -1;
    }

    private ContentValues getContentValue(String date, String type, double amount, String description) {
        ContentValues entryValues = new ContentValues();
        entryValues.put(EntryFeed.COLUMN_DATE, date);
        entryValues.put(EntryFeed.COLUMN_TYPE, type);
        entryValues.put(EntryFeed.COLUMN_AMOUNT, amount);
        entryValues.put(EntryFeed.COLUMN_DESCRIPTION, description);
        return entryValues;
    }

    public boolean deleteEntry(long id) {
        SQLiteDatabase db = getWritableDatabase();

        String q = "DELETING " + String.valueOf(id);
        Log.i("delete", q);
        long result = db.delete(EntryFeed.TABLE_NAME, EntryFeed.COLUMN_ID + " = ?",
                new String[]{Long.toString(id)});

        db.close();
        return result != -1;
    }

}
