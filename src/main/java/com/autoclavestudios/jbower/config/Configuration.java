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

import com.autoclavestudios.jbower.common.Defaults;
import com.autoclavestudios.jbower.config.internal.ConfigDefaults;

import java.net.MalformedURLException;

/**
 * Created by stewart on 4/5/2015.
 */
public class Configuration {

    /*
     * TODO: getter/setter supported by annotations using fluid checkstyle
     *
     * In the future, this class can be converted to use a getter setter annotation checkstyle which maps to a generic
     * fluid checkstyle get and set methods.
     */

    private String directory;
    private String cwd;
    private long timeout;
    private String tmp;
    private String storageCache;
    private String storageRegistry;
    private String storageLinks;
    private String storageCompletion;
    private String shorthandResolver;
    private Registry registry;

    //TODO: Config support for analytics
    //TODO: Config support for color
    //TODO: Config support for interactive
    //TODO: Config support for user-agent
    //TODO: Config support for proxy and https-proxy
    //TODO: Config support for strict-ssl
    //TODO: Config support for ca

    public Configuration() {
        //directory           = ConfigDefaults.DIRECTORY;
        //cwd                 = ConfigDefaults.CWD;
        //timeout             = ConfigDefaults.TIMEOUT;
        //tmp                 = ConfigDefaults.TMP;
        //storageCache        = ConfigDefaults.STORAGE_CACHE;
        //storageRegistry     = ConfigDefaults.STORAGE_REGISTRY;
        //storageLinks        = ConfigDefaults.STORAGE_LINKS;
        //storageCompletion   = ConfigDefaults.STORAGE_COMPLETION;
        //shorthandResolver   = ConfigDefaults.SHORTHAND_RESOLVER;
        registry            = new Registry();
    }


    /*
     *  Getter and setter functions
     */

    public String directory() {
        return Defaults.getOrDefault(this.directory, ConfigDefaults.DIRECTORY);
    }

    public Configuration directory(final String path){
        this.directory = path;
        return this;
    }


    public String cwd() {
        return Defaults.getOrDefault(this.cwd, ConfigDefaults.CWD);
    }

    public Configuration cwd(final String path){
        this.cwd = path;
        return this;
    }


    public Long timeout() { return Defaults.getOrDefault(this.timeout, ConfigDefaults.TIMEOUT); }

    public Configuration timeout(final Long milliseconds){
        this.timeout = milliseconds;
        return this;
    }


    public String tmp() {
        return Defaults.getOrDefault(this.tmp, ConfigDefaults.TMP);
    }

    public Configuration tmp(final String path){
        this.tmp = path;
        return this;
    }

    public String storageCache() { return Defaults.getOrDefault(this.storageCache, ConfigDefaults.STORAGE_CACHE); }

    public Configuration storageCache(final String path){
        this.storageCache = path;
        return this;
    }

    public String storageRegistry() { return Defaults.getOrDefault(this.storageRegistry, ConfigDefaults.STORAGE_REGISTRY); }

    public Configuration storageRegistry(final String path){
        this.storageRegistry = path;
        return this;
    }


    public String storageLinks() { return Defaults.getOrDefault(this.storageLinks, ConfigDefaults.STORAGE_LINKS); }

    public Configuration storageLinks(final String path){
        this.storageLinks = path;
        return this;
    }


    public String storageCompletion() { return Defaults.getOrDefault(this.storageCompletion, ConfigDefaults.STORAGE_COMPLETION); }

    public Configuration storageCompletion(final String path){
        this.storageCompletion = path;
        return this;
    }


    public String shorthandResolver() { return Defaults.getOrDefault(this.shorthandResolver, ConfigDefaults.SHORTHAND_RESOLVER); }

    public Configuration shorthandResolver(final String shorthandResolver) {
        this.shorthandResolver = shorthandResolver;
        return this;
    }


    public Registry registry() { return this.registry; }

    public Configuration registry(final Registry registry) {
        this.registry = registry;
        return this;
    }

    public Configuration registry(final String url) throws MalformedURLException {
        registry.all(url);
        return this;
    }
}
