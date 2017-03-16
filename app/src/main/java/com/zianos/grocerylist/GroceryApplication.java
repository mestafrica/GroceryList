package com.zianos.grocerylist;

import android.app.Application;
import android.util.Log;

import com.zianos.grocerylist.model.DaoMaster;
import com.zianos.grocerylist.model.DaoSession;

import org.greenrobot.greendao.database.Database;

public class GroceryApplication extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "grocery.db");

        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
