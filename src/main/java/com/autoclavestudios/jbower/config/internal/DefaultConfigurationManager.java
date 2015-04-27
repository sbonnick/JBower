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
package com.autoclavestudios.jbower.config.internal;

import com.autoclavestudios.jbower.config.Configuration;
import com.autoclavestudios.jbower.config.ConfigurationManager;
import com.autoclavestudios.jbower.config.Registry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by stewart on 2015-04-26.
 */
public class DefaultConfigurationManager implements ConfigurationManager {

    private static Gson gson = null;

    private final Logger logger = LoggerFactory.getLogger(DefaultConfigurationManager.class);

    DefaultConfigurationManager() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Registry.class, new JsonRegistryTranslator());
        gson = builder.create();
    }

    public Configuration parse(String data) {

        return gson.fromJson(data, Configuration.class);
    }

}
