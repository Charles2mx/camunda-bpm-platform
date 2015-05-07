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
package org.camunda.bpm.qa.upgrade.scenarios.job;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.qa.upgrade.DescribesScenario;
import org.camunda.bpm.qa.upgrade.ScenarioSetup;
import org.camunda.bpm.qa.upgrade.Times;

/**
 * @author Thorben Lindhauer
 *
 */
public class AsyncSequentialMultiInstanceSubprocessScenario {

  @Deployment
  public static String deployAsyncBeforeProcess() {
    return "org/camunda/bpm/qa/upgrade/job/asyncBeforeSequentialMultiInstanceSubprocess.bpmn20.xml";
  }

  @DescribesScenario("initAsyncBefore")
  @Times(4)
  public static ScenarioSetup initializeAsyncBefore() {
    return new ScenarioSetup() {
      public void execute(ProcessEngine engine, String scenarioName) {
        engine
          .getRuntimeService()
          .startProcessInstanceByKey("AsyncBeforeSequentialMultiInstanceSubprocess", scenarioName);
      }
    };
  }
}
