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

/**
 * Created by stewart on 2015-04-19.
 */
public class JsonConfigurationParser {

    /*
            ObjectMapper mapper = new ObjectMapper();

        public Configuration fromJson(String json) throws MalformedURLException {

        try {
            JsonNode root = mapper.readTree(json);

            directory = root.path("directory").asText(directory);
            cwd = root.path("cwd").asText(cwd);
            timeout = root.path("timeout").asLong(timeout);
            tmp = root.path("cwd").asText(cwd);
            storageCache = root.path("storageCache").asText(storageCache);
            storageRegistry = root.path("storageRegistry").asText(storageRegistry);
            storageLinks = root.path("storageLinks").asText(storageLinks);
            storageCompletion = root.path("storageCompletion").asText(storageCompletion);
            shorthandResolver = root.path("shorthandResolver").asText(shorthandResolver);

            JsonNode subNode;
            JsonNode registryNode = root.path("registry");
            if (!registryNode.isMissingNode()) {
                if (registryNode.isValueNode()) {
                    registries.toAll(registryNode.asText());
                } else {

                    // search
                    subNode = registryNode.path("search");
                    if (!subNode.isMissingNode()) {
                        if (subNode.isArray()) {

                            // TODO: should be casted to array first for error checking I think. perhaps jasckson can do this?
                            for (JsonNode jn : subNode) {
                                registries.toSearch(jn.asText());
                            }

                        } else if (subNode.isValueNode()) {
                            registries.toSearch(subNode.asText());
                        } else {
                            //error
                        }
                    } else {
                        // search not found
                    }
                }
            }
        } catch (MalformedURLException e) {
            logger.error("Malformed URL");
        } catch (JsonProcessingException e) {
            logger.error("could not parse JSON");
        } catch (IOException e) {
            logger.error("IO ERROR");
        } catch (NullPointerException e) {
            logger.error("NULL POINTER",e);
        }

        return this;
    }

     */

}
