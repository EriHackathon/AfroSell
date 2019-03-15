package com.erihackton.shopping.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aelaf on 2/5/19.
 */

public class AfroSellDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Afrosell.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";

    private static final String INT_TYPE = " INTEGER";
    private static final String UNIQUE = " ";

    private static final String REAL_TYPE = " REAL";

    private static final String COMMA_SEP = ",";
    private final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE " + AfroSellLocalColumnContract.DbEntry.USER_TABLE_NAME + " (" +
                    AfroSellLocalColumnContract.DbEntry._ID + INT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_ID + INT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_LAST_NAME + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_PROFILE_NAME + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_EMAIL + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_COUNTRY + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_BIRTH_DATE + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_USER_STATUS + TEXT_TYPE + COMMA_SEP +

                    "PRIMARY KEY(" + AfroSellLocalColumnContract.DbEntry._ID + ")" +
                    ")";
    private final String SQL_CREATE_PRODUCT_CATEGORY =
            "CREATE TABLE " + AfroSellLocalColumnContract.DbEntry.PRODUCT_CATEGORY_TABLE_NAME + " (" +
                    AfroSellLocalColumnContract.DbEntry._ID + INT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_CATEGORY_ID + INT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_CATEGORY_NAME + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_CATEGORY_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    "PRIMARY KEY(" + AfroSellLocalColumnContract.DbEntry._ID + ")" +
                    ")";
    /**
     * TODO:
     * CASCADE DELETE;... PRIMARY FOREIGN TABLE...
     * A NEW PRODUCT CATEGORY TABLE?!
     */
    private static final String SQL_CREATE_PRODUCT =
            "CREATE TABLE " + AfroSellLocalColumnContract.DbEntry.PRODUCT_TABLE_NAME + " (" +
                    AfroSellLocalColumnContract.DbEntry._ID + INT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_ID + INT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_CATEGORY + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_NAME + TEXT_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_PRICE + REAL_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_TYPE + REAL_TYPE + COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_IMAGE + TEXT_TYPE +COMMA_SEP +
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DESCRIPTION + TEXT_TYPE + COMMA_SEP+
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_CREATED + TEXT_TYPE + COMMA_SEP+
                    AfroSellLocalColumnContract.DbEntry.COLUMN_PRODUCT_DATE_DELETED + TEXT_TYPE + COMMA_SEP+
                    "PRIMARY KEY(" + AfroSellLocalColumnContract.DbEntry._ID+")" +

                    ")";

    public AfroSellDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PRODUCT_CATEGORY);
        sqLiteDatabase.execSQL(SQL_CREATE_PRODUCT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}