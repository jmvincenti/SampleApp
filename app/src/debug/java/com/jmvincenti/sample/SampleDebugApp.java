package com.jmvincenti.sample;

import android.util.Log;

import com.jmvincenti.sample.stetho.dumpapp.AppDumperPluginsProvider;
import com.jmvincenti.sample.stetho.webkit.AppInspectorModulesProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.LogInterceptor;
import com.orhanobut.hawk.NoEncryption;
import com.squareup.picasso.Picasso;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import okhttp3.OkHttpClient;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public class SampleDebugApp extends SampleApp {

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(SampleDebugApp.this)
                .enableWebKitInspector(new AppInspectorModulesProvider(SampleDebugApp.this))
                .enableDumpapp(new AppDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build());
    }

    void initHawk() {
        Hawk.init(this)
                .setEncryption(new NoEncryption())
                .setLogInterceptor(new LogInterceptor() {
                    @Override
                    public void onLog(String message) {
                        Log.d("Hawk", message);
                    }
                })
                .build();
    }

    void initPicasso() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(client))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
