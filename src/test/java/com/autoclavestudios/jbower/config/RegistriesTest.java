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
public class RegistriesTest {

    Registries registries;
    String[] input;
    List<URL> output;
    List<URL> empty;

    @Before
    public void setUp() {
        empty = Collections.<URL>emptyList();
        input = new String[]{
                "http://null.autoclavestudios.com",
                "https://null.autoclavestudios.com"
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
        registries = new Registries().toAll( output.toArray(new URL[output.size()]) );

        assertThat(registries.toSearch(), is(output));
        assertThat(registries.toRegister(), is(output));
        assertThat(registries.toPublish(), is(output));
    }

    @Test
    public void addStringsToAllRegistries() {
        try {
            registries = new Registries().toAll( input );
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registries.toSearch(), is(output));
        assertThat(registries.toRegister(), is(output));
        assertThat(registries.toPublish(), is(output));
    }

    @Test
    public void addStringsToSearchRegistry() {
        try {
            registries = new Registries().toSearch(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registries.toSearch(), is(output));
        assertThat(registries.toRegister(), is(empty));
        assertThat(registries.toPublish(), is(empty));
    }

    @Test
    public void addStringsToRegisterRegistry() {
        try {
            registries = new Registries().toRegister(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registries.toSearch(), is(empty));
        assertThat(registries.toRegister(), is(output));
        assertThat(registries.toPublish(), is(empty));
    }

    @Test
    public void addStringsToPublishRegistry() {
        try {
            registries = new Registries().toPublish(input);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registries.toSearch(), is(empty));
        assertThat(registries.toRegister(), is(empty));
        assertThat(registries.toPublish(), is(output));
    }

    @Test
    public void clearRegistries() {
        try {
            registries = new Registries().toSearch(input).clear();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        assertThat(registries.toSearch(), is(empty));
        assertThat(registries.toRegister(), is(empty));
        assertThat(registries.toPublish(), is(empty));
    }
}
