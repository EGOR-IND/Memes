package com.egor.memes.data.entity

import com.google.gson.annotations.SerializedName

data class ResponseEntity(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: MemeData
)

data class MemeData(
    @SerializedName("memes")
    val memes: List<MemeEntity>
)

data class MemeEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("box_count")
    val boxCount: Int
)