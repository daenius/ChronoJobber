package com.chronojobber

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.testCoroutineScheduler
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.time.Duration.Companion.days

@OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
internal class TimeGemTest : FreeSpec() {
    init {
        coroutineTestScope = true

        "this test is literally controlling time at will" {

            (1.days to 5).let { (waitTime, waitCount) ->
                // launch a coroutine that would normally sleep for 5 days
                val deferredResult = checkInfinityGauntlet(this, waitCount, waitTime)

                // move the clock on and the delay in the above coroutine will finish immediately.
                repeat(waitCount) {
                    testCoroutineScheduler.advanceTimeBy(waitTime.inWholeMilliseconds)
                }

                deferredResult
            }.await().also { resultsList: List<String> ->
                resultsList shouldHaveSize 5
                resultsList.forEachIndexed { index, result ->
                    result shouldBe "Time Gem not in gauntlet $index times"
                }
            }
        }
    }
}
