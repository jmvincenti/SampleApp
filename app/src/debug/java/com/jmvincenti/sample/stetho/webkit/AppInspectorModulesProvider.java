package com.jmvincenti.sample.stetho.webkit;

import android.content.Context;

import com.facebook.stetho.InspectorModulesProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.rhino.BuildConfig;
import com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder;

import java.util.Locale;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public class AppInspectorModulesProvider implements InspectorModulesProvider {
    private Context context;
    private static final String APP_VERSION = "version";
    private static final String APP_VERSION_NAME = "versionName";
    private static final String APP_VERSION_CODE = "versionCode";

    public AppInspectorModulesProvider(Context context) {
        this.context = context;
    }

    @Override
    public Iterable<ChromeDevtoolsDomain> get() {
        return new Stetho.DefaultInspectorModulesBuilder(context).runtimeRepl(
                new JsRuntimeReplFactoryBuilder(context)
                        .addVariable(APP_VERSION_NAME, BuildConfig.VERSION_NAME)
                        .addVariable(APP_VERSION_CODE, BuildConfig.VERSION_CODE)
                        .addVariable(APP_VERSION, String.format(Locale.ENGLISH, "%s(%d)", BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE))
                        .addFunction(SampleBaseFunction.name, new SampleBaseFunction())
//                        .addFunction(SetUrlFunction.name, new SetUrlFunction())
//                        .addFunction(PrefFunction.name, new PrefFunction())
//                        .importClass(PrefHelper.class)
                        .build()
        ).finish();
    }
}
