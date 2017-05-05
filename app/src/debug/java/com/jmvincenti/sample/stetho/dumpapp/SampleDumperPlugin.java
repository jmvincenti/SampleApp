package com.jmvincenti.sample.stetho.dumpapp;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public class SampleDumperPlugin implements DumperPlugin {
    private static final String name = "cake";
    private static final String commandCake = "get";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void dump(DumperContext dumpContext) throws DumpException {
        final PrintStream out = dumpContext.getStdout();
        List<String> commands = dumpContext.getArgsAsList();
        if (commands == null || commands.isEmpty()) {
            out.printf("Usage: dumpapp %s %s", getName(), commandCake);
        } else {
            out.println("The cake is a lie");
        }
    }
}
