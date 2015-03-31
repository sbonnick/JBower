package com.autoclavestudios.jbower.console.parameters;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stewart on 2015-03-30.
 */
public class Search {

    @Parameter(names = { "-h", "--help" }, description = "Show this help message", help = true)
    private boolean help;

    @Parameter(description = "name")
    private List<String> name = new ArrayList<String>();

    @ParametersDelegate
    private Global delegate = new Global();

}
