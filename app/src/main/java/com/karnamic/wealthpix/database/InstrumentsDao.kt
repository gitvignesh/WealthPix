package com.karnamic.wealthpix.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karnamic.wealthpix.data.Instrument

@Dao
interface InstrumentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(instrument: Instrument)


    @Query("DELETE * FROM instruments_table")
    suspend fun deleteAll()
}