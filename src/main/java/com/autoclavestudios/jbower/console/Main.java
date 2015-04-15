/**
 *    Copyright (C) 2015 Stewart Bonnick (stewart.bonnick@autoclavestudios.com)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.autoclavestudios.jbower.console;

import com.autoclavestudios.jbower.console.parameters.HelpParameters;
import com.autoclavestudios.jbower.console.parameters.SearchParameters;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * Created by stewart on 2015-03-30.
 */
public class Main {

    public static void main(String[] args) {

        HelpParameters helpParameters = new HelpParameters();
        SearchParameters searchParameters = new SearchParameters();
        JCommander jc = new JCommander(helpParameters);
        jc.setProgramName("JBower");
        jc.addCommand("search", searchParameters);

        try {
            jc.parse(args);

            if (searchParameters.delegate.help || helpParameters.help) {
                printHelp(jc);
            }

        } catch (ParameterException ex) {
            System.out.println();
            System.out.println(ex.getMessage());
            printHelp(jc);
        }


        // Call search function
    }


    private static void printHelp(JCommander jc) {
        System.out.println();
        if(jc.getParsedCommand() != null) {
            jc.usage(jc.getParsedCommand());
        } else {
            jc.usage();
        }
    }
}
