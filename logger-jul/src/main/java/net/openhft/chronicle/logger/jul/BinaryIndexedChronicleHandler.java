/*
 * Copyright 2014 Higher Frequency Trading
 *
 * http://www.higherfrequencytrading.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.openhft.chronicle.logger.jul;

import net.openhft.chronicle.logger.ChronicleLogAppenderConfig;
import net.openhft.chronicle.logger.ChronicleLogWriters;

import java.io.IOException;
import java.util.logging.Level;

public class BinaryIndexedChronicleHandler extends AbstractBinaryChronicleHandler {
    private final ChronicleHandlerConfig handlerCfg;
    private final ChronicleLogAppenderConfig appenderCfg;
    private final String appenderPath;

    public BinaryIndexedChronicleHandler() throws IOException {
        this.handlerCfg = new ChronicleHandlerConfig(getClass());
        this.appenderCfg = handlerCfg.getIndexedAppenderConfig();
        this.appenderPath = handlerCfg.getString("path", null);

        setLevel(handlerCfg.getLevel("level", Level.ALL));
        setFilter(handlerCfg.getFilter("filter", null));

        setWriter(ChronicleLogWriters.binary(appenderCfg, appenderPath));
    }
}
