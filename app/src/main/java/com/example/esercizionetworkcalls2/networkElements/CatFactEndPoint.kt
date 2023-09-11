package com.example.esercizionetworkcalls2.networkElements

import retrofit2.Response
import retrofit2.http.GET

interface CatFactEndPoint {

    @GET("fact")
    suspend fun catFact(): Response<CatFactData>

}