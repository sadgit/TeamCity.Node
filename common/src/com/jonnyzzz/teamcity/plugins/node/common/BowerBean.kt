/*
 * Copyright 2013-2013 Eugene Petrenko
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

package com.jonnyzzz.teamcity.plugins.node.common


/**
 * Created by Eugene Petrenko (eugene.petrenko@gmail.com)
 * Date: 27.04.13 9:58
 */
public class BowerBean {
  public val bowerConfigurationParameter : String = "bower"

  public val runTypeName: String = "jonnyzzz.bower"
  public val file: String = "jonnyzzz.bower.file"
  public val targets: String = "jonnyzzz.bower.tasks"
  public val commandLineParameterKey : String = "jonnyzzz.commandLine"
  public val bowerMode : String = "jonnyzzz.bower.mode"
  public val bowerModeDefault : BowerExecutionMode = BowerExecutionMode.NPM

  public val bowerModes : List<BowerExecutionMode>
          get() = arrayListOf(*BowerExecutionMode.values())

  public fun parseMode(text : String?) : BowerExecutionMode?
         = bowerModes.firstOrNull { text == it.value } ?: bowerModeDefault

  public fun parseCommands(text: String?): Collection<String> {
    if (text == null)
      return listOf()
    else
      return text
              .split("[\r\n]+")
              .map { it.trim() }
              .filterNot { it.isEmpty() }
  }
}

public enum class BowerExecutionMode(val title : String,
                                     val value : String) {
  NPM : BowerExecutionMode("NPM package from project", "npm")
  GLOBAL : BowerExecutionMode("System-wide bower", "global")
}
