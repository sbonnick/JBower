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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by stewart on 4/5/2015.
 */
public class Registry {

    private final List<URL> registrySearch;
    private final List<URL> registryRegister;
    private final List<URL> registryPublish;

    private final Logger logger = LoggerFactory.getLogger(Registry.class);

    public Registry() {
        registrySearch = new ArrayList<>();
        registryRegister = new ArrayList<>();
        registryPublish = new ArrayList<>();
    }


    /*
     *  General functions
     */

    public Registry clear() {
        registrySearch.clear();
        registryRegister.clear();
        registryPublish.clear();
        return this;
    }

    /**
     * Creates registry urls into all registries
     *
     * @param urls array of urls to add to all registries
     * @throws MalformedURLException if any url is malformed
     */
    public Registry all(final String ... urls) throws MalformedURLException {
        addUrl(registrySearch, urls);
        addUrl(registryRegister, urls);
        addUrl(registryPublish, urls);
        return this;
    }

    public Registry all(final URL ... urls) {
        addUrl(registrySearch, urls);
        addUrl(registryRegister, urls);
        addUrl(registryPublish, urls);
        return this;
    }


    /*
     *  Public meta functions
     */

    public boolean isSimple() {

        int baseSize = registrySearch.size();
        if ((registryRegister.size() == baseSize) &&
                (baseSize == registryPublish.size())) {

            if (baseSize == 1) {
                if (registryRegister.get(0).equals(registrySearch.get(0)) &&
                        registrySearch.get(0).equals(registryPublish.get(0))) {

                    return true;
                }
            } else if(baseSize == 0) {
                return true;
            }
        }
        return false;
    }


    /*
     *  Search registry methods
     */

    public List<URL> search() { return registrySearch; }

    public Registry search(final String ... urls) throws MalformedURLException {
        return addUrl(registrySearch, urls);
    }

    public Registry search(final URL ... urls) {
        return addUrl(registrySearch, urls);
    }


    /*
     *  Register registry methods
     */

    public List<URL> register() { return registryRegister; }

    public Registry register(final String ... urls) throws MalformedURLException {
        return addUrl(registryRegister, urls);
    }

    public Registry register(final URL ... urls) {
        return addUrl(registryRegister, urls);
    }


    /*
     *  Publish registry methods
     */

    public List<URL> publish() { return registryPublish; }

    public Registry publish(final String ... urls) throws MalformedURLException {
        return addUrl(registryPublish, urls);
    }

    public Registry publish(final URL ... urls) {
        return addUrl(registryPublish, urls);
    }


    /*
     *  Private helper functions
     */

    private Registry addUrl(final List<URL> registry, final String ... urls) throws MalformedURLException {
        for(final String url : urls) {
            try {
                registry.add(new URL(url));
            } catch (MalformedURLException e) {
                logger.error("URL is malformed: '{}'", url);
                throw e;
            }
        }
        return this;
    }

    private Registry addUrl(final List<URL> registry, final URL ... urls) {
        Collections.addAll(registry, urls);
        return this;
    }
}
