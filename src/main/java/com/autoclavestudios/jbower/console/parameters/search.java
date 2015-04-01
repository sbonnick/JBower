/**
 *    Copyright (C) 2015 Autoclave Studios <stewart.bonnick@autoclavestudios.com>
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
