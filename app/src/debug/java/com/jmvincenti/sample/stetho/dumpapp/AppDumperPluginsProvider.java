package com.jmvincenti.sample.stetho.dumpapp;

import android.content.Context;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.util.ArrayList;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public class AppDumperPluginsProvider implements DumperPluginsProvider {
    Context context;

    public AppDumperPluginsProvider(Context context) {
        this.context = context;
    }

    @Override
    public Iterable<DumperPlugin> get() {
        // Create a list
        ArrayList<DumperPlugin> plugins = new ArrayList<>();

        // Add default plugins to retain original functionality
        for (DumperPlugin plugin : Stetho.defaultDumperPluginsProvider(context).get()) {
            plugins.add(plugin);
        }

        //Add custom plugins
        plugins.add(new SampleDumperPlugin());

        return plugins;
    }
}
