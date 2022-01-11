package com.example.roomdatabase

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class Converters {

    @TypeConverter
    fun fromDateToLong(value: Date):Long
    {
       return value.time
    }

    @TypeConverter
    fun fromLongToDate(value:Long):Date {
        return Date(value)
    }

}