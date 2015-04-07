/**
 *    Copyright (C) 2015 Stewart Bonnick <stewart.bonnick@autoclavestudios.com>
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

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by stewart on 4/5/2015.
 */
public class Configuration {

    private String directory;
    private String cwd;
    private long timeout;
    private String tmp;
    private String storageCache;
    private String storageRegistry;
    private String storageLinks;
    private String storageCompletion;
    private String shorthandResolver;
    private Registries registries;

    //TODO: Config support for analytics
    //TODO: Config support for color
    //TODO: Config support for interactive
    //TODO: Config support for user-agent
    //TODO: Config support for proxy and https-proxy
    //TODO: Config support for strict-ssl
    //TODO: Config support for ca


    public Configuration() {
        directory = "bower_components";
        cwd = ""; //get working path
        timeout = 60000;
        tmp = ""; //get os tmp directory
        storageCache = "";
        storageRegistry = "";
        storageLinks = "";
        storageCompletion = "";
        shorthandResolver =  "git://github.com/{{owner}}/{{package}}.git";
        registries = new Registries();
    }

    public void load(){}

    public void create(String cwd) {}

    public String toJson() { return ""; }

    public Configuration fromJson(String json) { return this; }

    public Configuration fromJson(File json) { return this; }

    /*
     *  Getter and setter functions
     */

    public String directory() { return this.directory; }

    public Configuration directory(String path){
        this.directory = path;
        return this;
    }


    public String cwd() { return this.cwd; }

    public Configuration cwd(String path){
        this.cwd = path;
        return this;
    }


    public Long timeout() { return this.timeout; }

    public Configuration timeout(Long milliseconds){
        this.timeout = milliseconds;
        return this;
    }


    public String tmp() { return this.tmp; }

    public Configuration tmp(String path){
        this.tmp = path;
        return this;
    }

    public String storageCache() { return this.storageCache; }

    public Configuration storageCache(String path){
        this.storageCache = path;
        return this;
    }

    public String storageRegistry() { return this.storageRegistry; }

    public Configuration storageRegistry(String path){
        this.storageRegistry = path;
        return this;
    }


    public String storageLinks() { return this.storageLinks; }

    public Configuration storageLinks(String path){
        this.storageLinks = path;
        return this;
    }


    public String storageCompletion() { return this.storageCompletion; }

    public Configuration storageCompletion(String path){
        this.storageCompletion = path;
        return this;
    }


    public Registries registry() { return this.registries; }

    public Configuration registry(Registries registries) {
        this.registries = registries;
        return this;
    }

    public Configuration registry(String toAll) throws MalformedURLException {
        registries.toAll(toAll);
        return this;
    }

}
