package com.karnamic.wealthpix.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instruments_table")
data class Instrument(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    var interestRate: Float,
    var installments: ArrayList<Installment>,
    var cagRate: Float,
    var averageNav: Float,
    var investedAmount: Float,
    var totalUnits: Float
)
