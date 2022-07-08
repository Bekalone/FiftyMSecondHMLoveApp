package com.example.fiftymsecondhmloveapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_model")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @SerializedName("fname")
    val firstName:String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
) : Serializable
