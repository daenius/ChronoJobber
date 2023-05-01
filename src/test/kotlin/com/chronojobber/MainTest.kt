package com.chronojobber

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FreeSpec

internal class MainTest : FreeSpec({

    "main" {
        shouldNotThrowAny {
            main()
        }
    }
})
