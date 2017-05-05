package com.jmvincenti.sample;

import android.app.Application;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import okhttp3.OkHttpClient;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initHawk();
        initPicasso();
    }

    void initHawk() {
        Hawk.init(this)
                .build();
    }

    private void initRealm() {
        Realm.init(this);
    }

    void initPicasso() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(client))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
