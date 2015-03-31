package com.autoclavestudios.jbower.console.parameters;

import com.beust.jcommander.Parameter;

/**
 * Created by stewart on 2015-03-30.
 */
public class Global {

    @Parameter(names = { "-f", "--force" }, description = "Makes various commands more forceful")
    private boolean force = false;

    @Parameter(names = { "-j", "--json" }, description = "Output consumable JSON")
    private boolean json = false;

    @Parameter(names = { "-l", "--log-level" }, description = "What level of logs to report")
    private int logLevel = 3;

    @Parameter(names = { "-o", "--offline" }, description = "Do not hit the network")
    private boolean offline = false;

    @Parameter(names = { "-q", "--quiet" }, description = "Only output important information")
    private boolean quiet = false;

    @Parameter(names = { "-s", "--silent" }, description = "Do not output anything, besides errors")
    private boolean silent = false;

    @Parameter(names = { "-v", "--verbose" }, description = "Makes output more verbose")
    private boolean verbose = false;

    @Parameter(names = "--version", description = "Output JBower version")
    private boolean version = false;
}
