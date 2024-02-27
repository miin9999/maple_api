package diy.mapleApi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        thread(start = true){
            val url = URL("https://open.api.nexon.com/maplestory/v1/character/basic?ocid=a5d847df5c0bb31fd02da27f71067173&date=2024-02-27")

            val huc = url.openConnection() as HttpURLConnection
            huc.requestMethod = "GET"
            huc.setRequestProperty("accept","application/json")
            huc.setRequestProperty("x-nxopen-api-key","test_6001a8864a01e39f3699530260178f52ce16b1a2f30d5b150af21c5b2f9e83a1c75566dabf15ed9d65307cabf38a9c83")


            if(huc.responseCode==HttpURLConnection.HTTP_OK){
                val streamReader = InputStreamReader(huc.inputStream)
                val buffered = BufferedReader(streamReader)

                val content = StringBuilder()
                while(true){
                    val data = buffered.readLine() ?: break
                    content.append(data)
                }

                buffered.close()
                huc.disconnect()

                Log.d("결과값","${content}")
            }}



    }
}