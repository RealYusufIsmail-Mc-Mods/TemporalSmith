/*
 * Copyright 2024 RealYusufIsmail.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
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
package io.github.realyusufismail.temporalsmith.logger

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.color.ANSIConstants
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase

/**
 * This class is used to colorize the log output.
 *
 * The debug output is colored blue. <br></br> The info output is colored green. <br></br> The warn
 * output is colored yellow. <br></br> The error output is colored red. <br></br> The fatal output
 * is colored magenta. <br></br> The trace output is colored cyan. <br></br> The default output is
 * colored the default logging colour.
 */
class LoggerColorScheme : ForegroundCompositeConverterBase<ILoggingEvent>() {
    override fun getForegroundColorCode(event: ILoggingEvent): String {
        return when (event.level.toInt()) {
            Level.DEBUG_INT -> ANSIConstants.BLUE_FG
            Level.INFO_INT -> ANSIConstants.GREEN_FG
            Level.WARN_INT -> ANSIConstants.YELLOW_FG
            Level.ERROR_INT -> ANSIConstants.RED_FG
            Level.TRACE_INT -> ANSIConstants.CYAN_FG
            else -> ANSIConstants.DEFAULT_FG
        }
    }
}
