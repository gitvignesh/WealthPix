package com.karnamic.wealthpix.data


data class Installment(
    val date: Long,
    val amount: Float,
    val nav: Float,
    val units: Float
)