package net.zabador.retrovault

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.zabador.retrovault.api.GameDatabaseApi
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class GameListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .build()


        val retrofit = Retrofit.Builder()
                .baseUrl("http://thegamesdb.net/api/")
                .client(httpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val gameDatabaseApi = retrofit.create(GameDatabaseApi::class.java)

        gameDatabaseApi.getPlatformList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    platformListDataDto ->
                    Log.d("Result", "There are ${platformListDataDto.platforms.size} Java developers in Lagos")
                }, { error ->
                    error.printStackTrace()
                })
    }
}
