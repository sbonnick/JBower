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
package com.autoclavestudios.jbower.console.parameters;

import com.beust.jcommander.Parameter;

/**
 * Created by stewart on 2015-03-30.
 */
public class GlobalParameters {

    @Parameter(names = { "-h", "--help" }, description = "Show this help message", help = true)
    public boolean help;

    @Parameter(names = { "-f", "--force" }, description = "Makes various commands more forceful")
    public boolean force = false;

    @Parameter(names = { "-j", "--json" }, description = "Output consumable JSON")
    public boolean json = false;

    @Parameter(names = { "-l", "--log-level" }, description = "What level of logs to report")
    public int logLevel = 3;

    @Parameter(names = { "-o", "--offline" }, description = "Do not hit the network")
    public boolean offline = false;

    @Parameter(names = { "-q", "--quiet" }, description = "Only output important information")
    public boolean quiet = false;

    @Parameter(names = { "-s", "--silent" }, description = "Do not output anything, besides errors")
    public boolean silent = false;

    @Parameter(names = { "-v", "--verbose" }, description = "Makes output more verbose")
    public boolean verbose = false;

    @Parameter(names = "--version", description = "Output JBower version")
    public boolean version = false;
}
