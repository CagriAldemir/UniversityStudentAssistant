package tr.com.cagrialdemir.universitystudentassistant.Core.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


@SuppressWarnings("WeakerAccess")
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mData";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SQLiteHelper.class.getSimpleName();

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseSchema.CREATE_DONEMLER);
        db.execSQL(DatabaseSchema.CREATE_DERSLER);
        db.execSQL(DatabaseSchema.CREATE_DEVAMSIZLIKLAR);
        db.execSQL(DatabaseSchema.CREATE_HATIRLATMALAR);
        db.execSQL(DatabaseSchema.CREATE_ODEVLER);
        db.execSQL(DatabaseSchema.CREATE_SINAVLAR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + DatabaseSchema.CREATE_DONEMLER);
//        db.execSQL("DROP TABLE IF EXISTS " + DatabaseSchema.CREATE_DERSLER);
//        db.execSQL("DROP TABLE IF EXISTS " + DatabaseSchema.CREATE_DEVAMSIZLIKLAR);
//        db.execSQL("DROP TABLE IF EXISTS " + DatabaseSchema.CREATE_HATIRLATMALAR);
//        db.execSQL("DROP TABLE IF EXISTS " + DatabaseSchema.CREATE_ODEVLER);
//        db.execSQL("DROP TABLE IF EXISTS " + DatabaseSchema.CREATE_SINAVLAR);

        onCreate(db);
    }
//    public boolean insert(String table, ContentValues values) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.insert(table, null, values);
//        if (result == -1) {
//            MyLog.d(TAG, "insert", "failed to save data!");
//            return false;
//        } else {
//            Log.d(TAG, "save data successful");
//            return true;
//        }
//    }
//
//    /**
//     * This method edit the user details and it return int value.
//     *
//     * @param table  this param provide table that you want to update.
//     * @param values values param provide col value.
//     * @param email  to identify the you use want to edit.
//     * @return int value.
//     **/
//    public int update(String table, ContentValues values, String email) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.update(table, values, SqliteTable.COL_USER_EMAIL + " =? ", new String[]{email});
//    }
//
//    public Cursor getData(String email) {
//        User user;
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns={
//                SqliteTable.COL_USER_ID,
//                SqliteTable.COL_USER_FNAME,
//                SqliteTable.COL_USER_LNAME,
//                SqliteTable.COL_USER_ADDRESS,
//                SqliteTable.COL_USER_PHONE,
//                SqliteTable.COL_USER_EMAIL,
//                SqliteTable.COL_USER_PASSWORD
//        };
//
//        String selection = SqliteTable.COL_USER_EMAIL + " =? " ;
//        String[] args={email};
//
//        Cursor cursor = db.query(SqliteTable.TABLE_USER, columns,
//                selection, args, null, null, null);
//
//        if (cursor != null && cursor.moveToFirst()){
//
//            user = new User();
//            user.setUser_id(cursor.getInt(0));
//            user.setUser_fname(cursor.getString(1));
//            user.setUser_lname(cursor.getString(2));
//            user.setUser_address(cursor.getString(3));
//            user.setUser_phone(cursor.getString(4));
//            user.setUser_email(cursor.getString(5));
//            user.setUser_password(cursor.getString(6));
//
//            return user;
//        }
//
//        return null;
//    }
//
//    /**
//     * This method check if the user existing or not, and it will return boolean value.
//     *
//     * @param email carrier the email of user.
//     * @param pass  carrier the pass of the user.
//     * @return true/false.
//     **/
//    public boolean check(String email, String pass) {
//
//        //columns to fetch
//        String[] columns = {
//                SqliteTable.COL_USER_ID
//        };
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        // validation
//        String selection = SqliteTable.COL_USER_EMAIL + " =? " + " AND " +
//                SqliteTable.COL_USER_PASSWORD + " =? ";
//
//        //arguments
//        String[] args = {email, pass};
//
//        //query to user table
//        Cursor cursor = db.query(SqliteTable.TABLE_USER,
//                columns, //return
//                selection, //where clause
//                args, // value of the clause
//                null,
//                null,
//                null);
//
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//        if (count > 0) {
//            Log.d(TAG, "return true");
//            return true;
//        }
//
//        return false;
//    }
//
//    /**
//     * This method delete user details permanently, and it returns boolean value.
//     *
//     * @param email param email provide email of the user that are logged in the app.
//     * @return true/false.
//     **/
//    public boolean delete(String email) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(SqliteTable.TABLE_USER, SqliteTable.COL_USER_EMAIL + " =? ",
//                new String[]{email}) > 0;
//    }

}
