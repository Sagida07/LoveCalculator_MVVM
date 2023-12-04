package com.example.lovecalculator_mvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator_mvvm.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM `love-table` ORDER BY fname ASC, sname ASC")
    fun getAllSort(): List<LoveModel>
}