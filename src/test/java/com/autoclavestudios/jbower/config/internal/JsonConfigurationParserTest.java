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
public class JsonConfigurationParserTest {


    /*

    String jsonObject;

    jsonObject = "{\n" +
                "  \"directory\": \"app/components/\",\n" +
                "  \"analytics\": false,\n" +
                "  \"timeout\": 120000,\n" +
                "  \"registry\": {\n" +
                "    \"search\": [\n" +
                "      \"http://localhost:8000\",\n" +
                "      \"https://bower.herokuapp.com\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";

    @Test
    public void createConfigurationUsingJSON() {

        try {
            configuration = new Configuration().fromJson(jsonObject);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assertEquals("app/components/", configuration.directory());
        assertEquals((long) 120000, (long) configuration.timeout());
        assertThat(configuration.registry().toSearch(), is(registryURL));
    }

     */
}
