package diy.mapleApi.models


import com.google.gson.annotations.SerializedName

data class character_Info(
    @SerializedName("character_class")
    var characterClass: String?,
    @SerializedName("character_class_level")
    var characterClassLevel: String?,
    @SerializedName("character_exp")
    var characterExp: Long?,
    @SerializedName("character_exp_rate")
    var characterExpRate: String?,
    @SerializedName("character_gender")
    var characterGender: String?,
    @SerializedName("character_guild_name")
    var characterGuildName: String?,
    @SerializedName("character_image")
    var characterImage: String?,
    @SerializedName("character_level")
    var characterLevel: Int?,
    @SerializedName("character_name")
    var characterName: String?,
    @SerializedName("date")
    var date: String?,
    @SerializedName("world_name")
    var worldName: String?
)