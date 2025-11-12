package org.wildfly.doc.indexer;

import java.io.IOException;
import java.util.logging.LogManager;

import picocli.CommandLine;

public class Main {

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Indexer.class.getClassLoader().getResourceAsStream("logging.properties"));
        int exitCode = new CommandLine(new Indexer()).execute(args);
        System.exit(exitCode);
    }

}
