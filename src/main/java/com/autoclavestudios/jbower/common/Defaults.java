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
package com.autoclavestudios.jbower.common;

/**
 * Created by stewart on 5/30/2015.
 */
public final class Defaults {

    private Defaults() {}

    public static <T> T getOrDefault( T variable, T defaultValue) {
        if (variable != null
                && !variable.toString().isEmpty()
                && !variable.toString().equals("0")) {
            return variable;
        } else {
            return defaultValue;
        }
    }
}
