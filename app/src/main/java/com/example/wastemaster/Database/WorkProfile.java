package com.example.wastemaster.Database;

import android.provider.BaseColumns;

public final class WorkProfile {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private WorkProfile() {}

    /* Inner class that defines the table contents */
    public static class Work implements BaseColumns {
        public static final String TABLE_NAME = "workReport";
        public static final String COLUMN_1 = "date";
        public static final String COLUMN_2 = "numberofcomplaint";
        public static final String COLUMN_3 = "totalcollectioncountaners";
        public static final String COLUMN_4 = "totalfeildcountainers";
        public static final String COLUMN_5 = "pendingcustomercomplaint";
    }
}
