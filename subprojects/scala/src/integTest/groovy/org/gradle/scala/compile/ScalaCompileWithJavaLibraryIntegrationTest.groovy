/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package org.gradle.scala.compile

import org.gradle.integtests.fixtures.AbstractIntegrationSpec
import org.gradle.integtests.fixtures.TestResources
import org.gradle.integtests.fixtures.ZincScalaCompileFixture
import org.junit.Rule

class ScalaCompileWithJavaLibraryIntegrationTest extends AbstractIntegrationSpec {

    @Rule TestResources resources = new TestResources(temporaryFolder)
    @Rule public final ZincScalaCompileFixture zincScalaCompileFixture = new ZincScalaCompileFixture(executer, temporaryFolder)

    def setup() {
        executer.withRepositoryMirrors()
    }

    def javaLibraryCanDependOnScalaLibraryProject() {
        when:
        run ":compileJava"

        then:
        executedAndNotSkipped(":lib:compileScala")
        notExecuted(":lib:processResources", ":lib:jar")
    }

}
