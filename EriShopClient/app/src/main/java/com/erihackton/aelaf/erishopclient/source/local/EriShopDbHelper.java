package erihackton.com.aelaf.erishopclient.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;

/**
 * Created by aelaf on 1/29/19.
 */

public class EriShopDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="EriShop.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";

    private static final String INT_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";
    private final String SQL_CREATE_USER_TABLE=
            "CREATE TABLE "+ EriShopLocalColumnContract.DbEntry.USER_TABLE_NAME+" ("+
                    EriShopLocalColumnContract.DbEntry._ID +INT_TYPE+ COMMA_SEP +
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_ID +INT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_FIRST_NAME +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_LAST_NAME +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_PROFILE_NAME +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_EMAIL +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_PASSWORD +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_COUNTRY +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_BIRTH_DATE +TEXT_TYPE+ COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_USER_STATUS +TEXT_TYPE+ COMMA_SEP+

                    "PRIMARY KEY(" +EriShopLocalColumnContract.DbEntry._ID+")"+
                    ")" ;
    private final String SQL_CREATE_ITEM_CATEGORY =
            "CREATE TABLE " +EriShopLocalColumnContract.DbEntry.ITEM_CATEGORY_TABLE_NAME + " ("+
                    EriShopLocalColumnContract.DbEntry._ID+ INT_TYPE + COMMA_SEP +
                    EriShopLocalColumnContract.DbEntry.COLUMN_CATEGORY_ID + INT_TYPE + COMMA_SEP +
                    EriShopLocalColumnContract.DbEntry.COLUMN_CATEGORY_NAME + TEXT_TYPE + COMMA_SEP +
                    EriShopLocalColumnContract.DbEntry.COLUMN_CATEGORY_DESCRIPTION + TEXT_TYPE + COMMA_SEP+
                    "PRIMARY KEY("+EriShopLocalColumnContract.DbEntry._ID+")"+
                    ")";
    /**
     * TODO:
     * CASCADE DELETE;... PRIMARY FOREIGN TABLE...
     */
    private static final String SQL_CREATE_ITEM =
            "CREATE TABLE "+ EriShopLocalColumnContract.DbEntry.ITEM_TABLE_NAME + " (" +
                    EriShopLocalColumnContract.DbEntry._ID + INT_TYPE + COMMA_SEP +
                    EriShopLocalColumnContract.DbEntry.COLUMN_ITEM_ID + INT_TYPE +COMMA_SEP+
                    EriShopLocalColumnContract.DbEntry.COLUMN_ITEM_CATEGORY_ID + INT_TYPE + COMMA_SEP +
                    EriShopLocalColumnContract.DbEntry.COLUMN_ITEM_NAME + TEXT_TYPE + COMMA_SEP +
                    ")";
    public EriShopDbHelper(Context context){
    super( context, DATABASE_NAME, null, DATABASE_VERSION) ;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
