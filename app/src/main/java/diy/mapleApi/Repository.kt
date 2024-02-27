package diy.mapleApi

import android.net.Uri
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repository {

    //todo 메인에서 접근할 get 함수


    suspend fun getMapleCharacterInfo():String=
        mapleServieAPI.getCharacter()
            .body()
            ?.characterClass.toString()


    //todo retrofit 빌더

    private val mapleServieAPI: MapleService by lazy{
        Retrofit.Builder()
            .baseUrl(Url.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }





}