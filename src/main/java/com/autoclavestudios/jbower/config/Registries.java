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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stewart on 4/5/2015.
 */
public class Registries {

    private List<URL> registrySearch;
    private List<URL> registryRegister;
    private List<URL> registryPublish;


    public Registries() {
        registrySearch = new ArrayList<>();
        registryRegister = new ArrayList<>();
        registryPublish = new ArrayList<>();
    }


    /*
     *  General functions
     */

    public Registries clear() {
        registrySearch.clear();
        registryRegister.clear();
        registryPublish.clear();
        return this;
    };

    public Registries toAll(String ... urls) throws MalformedURLException {
        addUrl(registrySearch, urls);
        addUrl(registryRegister, urls);
        addUrl(registryPublish, urls);
        return this;
    }

    public Registries toAll(URL ... urls) {
        addUrl(registrySearch, urls);
        addUrl(registryRegister, urls);
        addUrl(registryPublish, urls);
        return this;
    }

    /*
     *  Search registry methods
     */

    public List<URL> toSearch() { return registrySearch; }

    public Registries toSearch(String ... urls) throws MalformedURLException {
        return addUrl(registrySearch, urls);
    }

    public Registries toSearch(URL ... urls) {
        return addUrl(registrySearch, urls);
    }


    /*
     *  Register registry methods
     */

    public List<URL> toRegister() { return registryRegister; }

    public Registries toRegister(String ... urls) throws MalformedURLException {
        return addUrl(registryRegister, urls);
    }

    public Registries toRegister(URL ... urls) {
        return addUrl(registryRegister, urls);
    }


    /*
     *  Publish registry methods
     */

    public List<URL> toPublish() { return registryPublish; }

    public Registries toPublish(String ... urls) throws MalformedURLException {
        return addUrl(registryPublish, urls);
    }

    public Registries toPublish(URL ... urls) {
        return addUrl(registryPublish, urls);
    }


    /*
     *  Private helper functions
     */

    private Registries addUrl(List<URL> registry, String ... urls) throws MalformedURLException {
        for(String url : urls) {
            try {
                registry.add(new URL(url));
            } catch (MalformedURLException e) {
                // LOG
                throw e;
            }
        }
        return this;
    }

    private Registries addUrl(List<URL> registry, URL ... urls) {
        for(URL url : urls) { registry.add(url); }
        return this;
    }
}
