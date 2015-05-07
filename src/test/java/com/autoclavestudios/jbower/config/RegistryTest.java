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
package com.autoclavestudios.jbower.config;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by stewart on 4/5/2015.
 */
public class RegistryTest {

    Registry registry;
    String[] input;
    List<URL> output;
    List<URL> empty;

    @Before
    public void setUp() {
        empty = Collections.<URL>emptyList();
        input = new String[]{
                "https://bower.herokuapp.com",
                "http://localhost:8000"
        };
        output = new ArrayList<>();
        for(String url:input) {
            try {
                output.add(new URL(url));
            } catch (MalformedURLException e) {
                System.out.println("Could not cast URL: " + url);
            }
        }
    }

    @Test
    public void addUrlsToAllRegistries() {
        registry = new Registry().all(output.toArray(new URL[output.size()]));

        assertThat(registry.search(), is(output));
        assertThat(registry.register(), is(output));
        assertThat(registry.publish(), is(output));
    }

    @Test
    public void addURLtoAllRegistriesIndividually() {
        URL[] urlArray = output.toArray(new URL[output.size()]);

        registry = new Registry()
            .search(urlArray)
            .register(urlArray)
            .publish(urlArray);

        assertThat(registry.search(), is(output));
        assertThat(registry.register(), is(output));
        assertThat(registry.publish(), is(output));
    }

    @Test
    public void addStringsToAllRegistries() {
        try {
            registry = new Registry().all(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registry.search(), is(output));
        assertThat(registry.register(), is(output));
        assertThat(registry.publish(), is(output));
    }

    @Test
    public void addStringsToSearchRegistry() {
        try {
            registry = new Registry().search(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registry.search(), is(output));
        assertThat(registry.register(), is(empty));
        assertThat(registry.publish(), is(empty));
    }

    @Test
    public void addStringsToRegisterRegistry() {
        try {
            registry = new Registry().register(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registry.search(), is(empty));
        assertThat(registry.register(), is(output));
        assertThat(registry.publish(), is(empty));
    }

    @Test
    public void addStringsToPublishRegistry() {
        try {
            registry = new Registry().publish(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registry.search(), is(empty));
        assertThat(registry.register(), is(empty));
        assertThat(registry.publish(), is(output));
    }

    @Test
    public void clearRegistries() {
        try {
            registry = new Registry().search(input).clear();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registry.search(), is(empty));
        assertThat(registry.register(), is(empty));
        assertThat(registry.publish(), is(empty));
    }

    @Test
    public void IsSimpleWithNoUrls() {
        registry = new Registry();
        assertEquals(true, registry.isSimple());
    }

    @Test
    public void IsSimple() throws MalformedURLException {
        registry = new Registry().all("https://bower.herokuapp.com");
        assertEquals(true, registry.isSimple());
    }

    @Test
    public void IsNotSimpleWithOneUrl() throws MalformedURLException {
        registry = new Registry()
                .search("https://bower.herokuapp.com")
                .publish("http://localhost:8000")
                .register("https://bower.herokuapp.com");
        assertEquals(false, registry.isSimple());
    }

    @Test
    public void IsNotSimple() throws MalformedURLException {
        registry = new Registry()
                .search("https://bower.herokuapp.com")
                .publish("https://bower.herokuapp.com")
                .register("https://bower.herokuapp.com")
                .search("http://localhost:8000");
        assertEquals(false, registry.isSimple());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionDuringUrlConversion() throws MalformedURLException {
        thrown.expect(MalformedURLException.class);
        registry = new Registry().all("git://localhost:8000");
    }
}
