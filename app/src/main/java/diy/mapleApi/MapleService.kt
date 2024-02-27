package diy.mapleApi

import diy.mapleApi.models.character_Info
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MapleService {



    @GET("maplestory/v1/character/basic?ocid=e0a4f439e53c369866b55297d2f5f4eb&date=2023-12-21")
    suspend fun getCharacter():Response<character_Info>
}