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
package com.autoclavestudios.jbower.common;

import com.beust.jcommander.internal.Nullable;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

import com.autoclavestudios.jbower.common.Defaults;

/**
 * Created by stewart on 5/30/2015.
 */
public class DefaultsTest {

    @Test
    public void getOrDefaults_Null() {
        String rtnObject = Defaults.getOrDefault(null, "Default");
        assertEquals("Default", rtnObject);
    }

    @Test
    public void getOrDefaults_String() {
        String testObj = "Variable";
        String rtnObject = Defaults.getOrDefault(testObj, "Default");
        assertEquals("Variable", rtnObject);
    }

    @Test
    public void getOrDefaults_StringEmpty() {
        String testObj = "";
        String rtnObject = Defaults.getOrDefault(testObj, "Default");
        assertEquals("Default", rtnObject);
    }

    @Test
    public void getOrDefaults_Long() {
        Long testObj = (long) 345;
        Long rtnObject = Defaults.getOrDefault(testObj, (long)123);
        assertEquals((long)345, (long)rtnObject);
    }

    @Test
    public void getOrDefaults_LongZero() {
        Long testObj = (long) 0;
        Long rtnObject = Defaults.getOrDefault(testObj, (long)123);
        assertEquals((long)0, (long)rtnObject);
    }
}
