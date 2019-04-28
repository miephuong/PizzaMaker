package com.example.pizzamaker.UserRegistration;


import android.provider.BaseColumns;

public class UserContract {
    private UserContract(){}

    public class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "user_table";
        public static final String ID = BaseColumns._ID;
        public static final String COL_USER_NAME = "user_name";
        public static final String COL_USER_MAIL = "user_email";
        public static final String COL_USER_PHONE = "user_phone";
        public static final String COL_USER_CITY = "user_city";

    }

}
