package diy.mapleApi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        thread(start = true){
            val url = URL("https://open.api.nexon.com/maplestory/v1/character/ability?ocid=a5d847df5c0bb31fd02da27f71067173&date=2024-02-27")

            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.setRequestProperty("accept","application/json")
            httpURLConnection.setRequestProperty("x-nxopen-api-key","test_6001a8864a01e39f3699530260178f52ce16b1a2f30d5b150af21c5b2f9e83a1c75566dabf15ed9d65307cabf38a9c83")

            val responseCode = httpURLConnection.responseCode

            val reader = BufferedReader(InputStreamReader(httpURLConnection.inputStream))
            val stringBuffer = StringBuffer(0)

            var line : String?
            while(reader.readLine().also{line=it}!=null) {
                stringBuffer.append(line)
            }
            reader.close()

            val data = stringBuffer.toString()
            Log.d("dadaddad",data)

            val root =JSONObject(data)

            val itemArray = root.getJSONArray("ability_info")

            for (idx in 0 until itemArray.length()) {

                // items의 기사들은 {}로 감싸져있기에 getJSONObject 이용해 idx 번째 JSONObject를 추출한다
                val itemObject = itemArray.getJSONObject(idx)
                // 원하는 데이터들을 추출한다
                val ability_no = itemObject.getString("ability_no")
                val ability_grade = itemObject.getString("ability_grade")
                val ability_value = itemObject.getString("ability_value")

                Log.d("ability_info", ability_no.toString())
                Log.d("ability_info", ability_grade.toString())
                Log.d("ability_info", ability_value.toString())

            }

            Log.d("remain_fame",root.getString("remain_fame").toString())


        } // thread의 "}"


    }
}