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
}
