/**
 *    Copyright (C) 2016 Stewart Bonnick (stewart.bonnick@autoclavestudios.com)
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
package com.autoclavestudios.jbower.config.internal;

import java.io.File;

/**
 * Created by stewart on 2015-04-19.
 */
public final class ConfigDefaults {

    private ConfigDefaults() {}

    private static final String USER_HOME           = System.getProperty("user.home");

    public static final String DIRECTORY            = "bower_components";
    public static final String CWD                  = System.getProperty("user.dir");
    public static final Long   TIMEOUT              = (long)60000;
    public static final String TMP                  = System.getProperty("java.io.tmpdir");
    public static final String SHORTHAND_RESOLVER   = "git://github.com/{{owner}}/{{package}}.git";

    public static final String REGISTRY             = "https://bower.herokuapp.com";

    public static final String STORAGE_CACHE        = USER_HOME + File.separator + ".bower" + File.separator + "packages";
    public static final String STORAGE_REGISTRY     = USER_HOME + File.separator + ".bower" + File.separator + "registry";
    public static final String STORAGE_LINKS        = USER_HOME + File.separator + ".bower" + File.separator + "links";
    public static final String STORAGE_COMPLETION   = USER_HOME + File.separator + ".bower" + File.separator + "completion";
}
