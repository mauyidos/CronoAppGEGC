package com.mexiti.cronoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("cronos")
data class Cronos(
    @PrimaryKey(true)
    val id: Long = 0,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("crono")
    val crono: Long
)
