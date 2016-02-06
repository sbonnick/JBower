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
package com.autoclavestudios.jbower.config.internal;

import org.junit.Test;
import static net.trajano.commons.testing.UtilityClassTestUtil.assertUtilityClassWellDefined;

/**
 * Created by stewart on 5/31/2015.
 */
public class ConfigDefaultsTest {

    @Test
    public void classWellDefinedUtility() throws Exception {
        assertUtilityClassWellDefined(ConfigDefaults.class);
    }
}
