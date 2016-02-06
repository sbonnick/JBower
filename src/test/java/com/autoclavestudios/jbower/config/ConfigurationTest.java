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
package com.autoclavestudios.jbower.config;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stewart on 2015-04-11.
 */
public class ConfigurationTest {

    Configuration configuration;
    List<URL> registryURL;

    @Before
    public void setUp() {
        registryURL = new ArrayList<>();
        try {
            registryURL.add(new URL("http://localhost:8000"));
            registryURL.add(new URL("https://bower.herokuapp.com"));

        } catch (MalformedURLException e) {
            System.out.println("Could not cast URL");
        }
    }

    @Test
    public void createComplexConfiguration() {

        try {
            configuration = new Configuration()
                .cwd(".")
                .directory(".")
                .shorthandResolver("git://example.com/{{shorthand}}.git")
                .storageCache("/cache")
                .storageCompletion("/completion")
                .storageLinks("/links")
                .storageRegistry("/registry")
                .timeout((long) 12000)
                .tmp(".")
                .registry("http://localhost:8000");

            configuration.registry().publish("https://bower.herokuapp.com");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assertEquals(".", configuration.cwd());
        assertEquals(".", configuration.directory());
        assertEquals("git://example.com/{{shorthand}}.git", configuration.shorthandResolver());
        assertEquals("/cache", configuration.storageCache());
        assertEquals("/completion", configuration.storageCompletion());
        assertEquals("/links", configuration.storageLinks());
        assertEquals("/registry", configuration.storageRegistry());
        assertEquals((long)12000, (long) configuration.timeout());
        assertEquals(".", configuration.tmp());
        assertThat(configuration.registry().publish(), is(registryURL));
    }

    @Test
    public void createConfigurationUsingRegistryObject() {
        try {
            configuration = new Configuration()
                    .registry(new Registry()
                            .all("http://localhost:8000",
                                    "https://bower.herokuapp.com")
                    );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assertThat(configuration.registry().publish(), is(registryURL));
    }
}
