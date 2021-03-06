/*
 * Copyright 2016 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.streaming

import org.apache.spark.util.ManualClock

import scala.concurrent.duration.FiniteDuration

// https://github.com/mkuthan/example-spark/blob/master/src/test/scala/org/mkuthan/spark/SparkStreamingSpec.scala
/** Ugly hack to access Spark private ManualClock class. */
object ClockWrapper {
  def advance(ssc: StreamingContext, timeToAdd: FiniteDuration): Unit = {
    val manualClock = ssc.scheduler.clock.asInstanceOf[ManualClock]
    manualClock.advance(timeToAdd.toMillis)
  }
}
