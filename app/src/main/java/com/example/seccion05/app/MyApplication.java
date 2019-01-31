package com.example.seccion05.app;

import android.app.Application;

import com.example.seccion05.models.Board;
import com.example.seccion05.models.Note;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {

    public static AtomicInteger BoardID = new AtomicInteger();
    public static AtomicInteger NoteID = new AtomicInteger();

    @Override
    public void onCreate() {

        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        BoardID = getIdByTable(realm, Board.class);
        NoteID = getIdByTable(realm, Note.class);
        realm.close();
    }

    private void setUpRealmConfig(){

        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> result = realm.where(anyClass).findAll();
        return  (result.size() > 0) ?  new AtomicInteger(result.max("id").intValue()):new AtomicInteger();
    }
}


