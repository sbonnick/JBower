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
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by stewart on 2015-04-26.
 */
public class DefaultConfigurationManagerTest {

    List<URL> empty = Collections.<URL>emptyList();

    @Test
    public void createConfigurationUsingJSON() throws MalformedURLException {

        String JsonString = "{\n" +
                "  \"directory\": \"app/components/\",\n" +
                "  \"analytics\": false,\n" +
                "  \"timeout\": 120000,\n" +
                "  \"registry\": {\n" +
                "    \"search\": [\n" +
                "      \"http://localhost:8000\",\n" +
                "      \"https://bower.herokuapp.com\"\n" +
                "    ],\n" +
                "    \"publish\": [\n" +
                "      \"http://localhost:8000\",\n" +
                "      \"https://bower.herokuapp.com\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        List<URL> expected = Arrays.asList(
                new URL("http://localhost:8000"),
                new URL("https://bower.herokuapp.com")
        );

        ConfigurationManager configurationManager = new DefaultConfigurationManager();
        Configuration configuration = configurationManager.parse(JsonString);

        assertEquals("app/components/", configuration.directory());
        assertEquals((long) 120000, (long) configuration.timeout());
        assertThat(configuration.registry().search(), is(expected));
        assertThat(configuration.registry().publish(), is(expected));
        assertThat(configuration.registry().register(), is(empty));

    }

    @Test
    public void createConfigurationUsingSimpleJSON() throws MalformedURLException {

        String JsonString = "{ \"registry\": \"https://bower.herokuapp.com\" }";
        List<URL> expected = Arrays.asList(new URL("https://bower.herokuapp.com"));

        ConfigurationManager configurationManager = new DefaultConfigurationManager();
        Configuration configuration = configurationManager.parse(JsonString);

        assertThat(configuration.registry().search(), is(expected));
        assertThat(configuration.registry().publish(), is(expected));
        assertThat(configuration.registry().register(), is(expected));
        assertEquals((long) ConfigDefaults.TIMEOUT, (long) configuration.timeout());
    }

    @Test
    public void serializeConfigurationToJSON() throws MalformedURLException {

        Configuration configuration = new Configuration()
            .directory("app/components")
            .timeout((long) 120000)
            .registry(new Registry()
                .search("http://localhost:8000", "https://bower.herokuapp.com")
                .publish("http://localhost:8000", "https://bower.herokuapp.com")
            );
        String expected = "{\n" +
                "  \"directory\": \"app/components\",\n" +
                "  \"timeout\": 120000,\n" +
                "  \"registry\": {\n" +
                "    \"register\": [],\n" +
                "    \"search\": [\n" +
                "      \"http://localhost:8000\",\n" +
                "      \"https://bower.herokuapp.com\"\n" +
                "    ],\n" +
                "    \"publish\": [\n" +
                "      \"http://localhost:8000\",\n" +
                "      \"https://bower.herokuapp.com\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        ConfigurationManager configurationManager = new DefaultConfigurationManager();
        String JsonString = configurationManager.parse(configuration);

        assertEquals(expected, JsonString);
    }
}
