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
            registryURL.add(new URL("https://bower.herokuapp.com"));
        } catch (MalformedURLException e) {
        System.out.println("Could not cast URL");
    }
    }

    @Test
    public void createAndRetrieveConfigurationUsingAPI() {

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
                .registry("https://bower.herokuapp.com");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assertEquals(configuration.cwd(), ".");
        assertEquals(configuration.directory(), ".");
        assertEquals(configuration.shorthandResolver(), "git://example.com/{{shorthand}}.git");
        assertEquals(configuration.storageCache(), "/cache");
        assertEquals(configuration.storageCompletion(), "/completion");
        assertEquals(configuration.storageLinks(), "/links");
        assertEquals(configuration.storageRegistry(), "/registry");
        assertEquals((long)configuration.timeout(), (long)12000);
        assertEquals(configuration.tmp(), ".");
        assertThat(configuration.registry().toPublish(), is(registryURL));
    }

}
