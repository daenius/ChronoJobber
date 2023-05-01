package com.chronojobber

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.time.Duration

internal suspend fun checkInfinityGauntlet(scope: CoroutineScope, count: Int, wait: Duration): Deferred<List<String>> =
    scope.async {
        (0 until count).map {
            delay(wait)
            "Time Gem not in gauntlet $it times"
        }
    }

