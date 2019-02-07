package com.erihackton.shopping.source.local;

import android.provider.BaseColumns;

/**
 * Created by aelaf on 2/5/19.
 */

public class AfroSellLocalColumnContract {
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
        //PRODUCT CATEGORY COLUMNS
        public static final String PRODUCT_CATEGORY_TABLE_NAME = "product_category";
        public static final String COLUMN_CATEGORY_ID = "id";
        public static final String COLUMN_CATEGORY_NAME = "category_name";
        public static final String COLUMN_CATEGORY_DESCRIPTION = "category_description";

        //PRODUCT COLUMNS
        public static final String PRODUCT_TABLE_NAME = "product";
        public static final String COLUMN_PRODUCT_ID = "product_id";
        public static final String COLUMN_PRODUCT_CATEGORY = "product_category";
        public static final String COLUMN_PRODUCT_NAME = "product_name";
        public static final String COLUMN_PRODUCT_TYPE = "product_type";
        public static final String COLUMN_PRODUCT_PRICE = "product_price";
        public static final String COLUMN_PRODUCT_IMAGE = "product_image";
        public static final String COLUMN_PRODUCT_DESCRIPTION = "product_description";
        public static final String COLUMN_PRODUCT_DATE_CREATED ="date_created";
        public static final String COLUMN_PRODUCT_DATE_DELETED = "date_deleted";
    }

}
