package com.example.starmoviehub.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    @TypeConverter
    fun fromStringToIntList(value: String): List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    fun fromIntListToString(list: List<Int>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

}