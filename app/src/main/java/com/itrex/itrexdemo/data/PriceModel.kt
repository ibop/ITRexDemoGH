package com.itrex.itrexdemo.data

import java.io.Serializable

data class PriceModel (
    var key: String = "",
    var value: Float = 0f,
    var up: Boolean = true
) : Serializable