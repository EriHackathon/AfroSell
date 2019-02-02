package erihackton.com.aelaf.erishopclient.source.local;

import android.provider.BaseColumns;

/**
 * Created by aelaf on 1/30/19.
 */

public class EriShopLocalColumnContract {
    public EriShopLocalColumnContract() {
    }
    //https://github.com/EriHackathon/AfroSell.git

    public static abstract class DbEntry implements BaseColumns {
        public static final String USER_TABLE_NAME = "user";
        public static final String COLUMN_USER_ID = "id";
        public static final String COLUMN_USER_FIRST_NAME = "firstName";
        public static final String COLUMN_USER_LAST_NAME = "lastName";
        public static final String COLUMN_USER_EMAIL = "email";
        public static final String COLUMN_USER_PROFILE_NAME = "profileName";
        public static final String COLUMN_USER_PASSWORD = "password";
        public static final String COLUMN_USER_COUNTRY = "country";
        public static final String COLUMN_USER_BIRTH_DATE = "birthDate";
        public static final String COLUMN_USER_STATUS = "status";
        /**
         * TODO:
         * ALLOW ADDITION OF PHOTO
         */
        //ITEM CATEGORY COLUMNS
        public static final String ITEM_CATEGORY_TABLE_NAME = "item_category";
        public static final String COLUMN_CATEGORY_ID = "id";
        public static final String COLUMN_CATEGORY_NAME = "category_name";
        public static final String COLUMN_CATEGORY_DESCRIPTION = "category_description";

        //ITEM COLUMNS
        public static final String ITEM_TABLE_NAME = "item";
        public static final String COLUMN_ITEM_ID = "id";
        public static final String COLUMN_ITEM_CATEGORY_ID = "category_id";
        public static final String COLUMN_ITEM_NAME = "name";
        //public static final String COLUMN_ITEM_PRICE = price
    }

    }
