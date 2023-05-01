package com.chronojobber

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.string.shouldContainIgnoringCase

internal class PlaceholderTest : FreeSpec({

    "placeholder test" {
        Placeholder().veryFunIndeed() shouldContainIgnoringCase "literally fun"
    }
})
