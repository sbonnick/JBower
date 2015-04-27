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

import com.autoclavestudios.jbower.config.Registry;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by stewart on 2015-04-25.
 */
public class JsonRegistryTranslator implements JsonDeserializer<Registry>, JsonSerializer<Registry> {

    private final Logger logger = LoggerFactory.getLogger(JsonRegistryTranslator.class);

    @Override
    public Registry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Registry registry = new Registry();
        try {
            if (json.isJsonObject()) {
                JsonObject jsonObject = json.getAsJsonObject();
                if (jsonObject.has("search"))   registry.search(ConvertToArray(jsonObject.get("search").getAsJsonArray()));
                if (jsonObject.has("publish"))  registry.publish(ConvertToArray(jsonObject.get("publish").getAsJsonArray()));
                if (jsonObject.has("register")) registry.register(ConvertToArray(jsonObject.get("register").getAsJsonArray()));

            } else if (json.isJsonPrimitive()) {
                registry.all(json.getAsString());

            } else {
                throw new JsonParseException("Registry object is not a Json Object or Primitive");
            }
        } catch (MalformedURLException e) {
            logger.error("Malformed URL: {}", json.getAsString());
        }
        return registry;
    }

    @Override
    public JsonElement serialize(Registry src, Type typeOfSrc, JsonSerializationContext context) {
        //TODO: add serialize logic
        return null;
    }

    private String[] ConvertToArray(JsonArray jsonStringArray){
        Gson converter = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        List<String> list = converter.fromJson(jsonStringArray, type );

        return list.toArray(new String[0]);
    }
}
