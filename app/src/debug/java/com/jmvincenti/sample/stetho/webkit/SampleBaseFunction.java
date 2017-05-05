package com.jmvincenti.sample.stetho.webkit;

import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.Scriptable;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public class SampleBaseFunction extends BaseFunction {
    public static final String name = "getCake";

    @Override
    public Object call(org.mozilla.javascript.Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
        return "The cake is a lie";
    }
}
