/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.rest.helper;

import org.camunda.bpm.engine.impl.TaskQueryImpl;
import org.mockito.ArgumentMatcher;

/**
 * @author Tassilo Weidner
 *
 */
public class TaskQueryOrMatcher extends ArgumentMatcher<TaskQueryImpl> {
  protected String taskDescription;
  protected String taskName;

  @Override
  public boolean matches(Object argument) {

    TaskQueryImpl argumentQuery = (TaskQueryImpl) argument;

    return taskDescription.equals(argumentQuery.getQueries().get(1).getDescription()) &&
        taskName.equals(argumentQuery.getQueries().get(2).getName());
  }

  public static TaskQueryOrMatcher evalOrQuery(String taskDescription, String taskName) {
    TaskQueryOrMatcher matcher = new TaskQueryOrMatcher();
    matcher.taskDescription = taskDescription;
    matcher.taskName = taskName;
    return matcher;
  }

}
