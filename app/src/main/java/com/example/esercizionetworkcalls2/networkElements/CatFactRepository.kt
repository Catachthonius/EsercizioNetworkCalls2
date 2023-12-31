package com.example.esercizionetworkcalls2.networkElements

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CatFactRepository {

    var catFactEndPoint: CatFactEndPoint? = null

    suspend fun catFact(): Response<CatFactData>? {
        if (catFactEndPoint == null) {
            catFactEndPoint = createRetrofitInstance().create(CatFactEndPoint::class.java)
        }

        return catFactEndPoint?.catFact()

    }

    private fun createRetrofitInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()
            ).build()
    }

}