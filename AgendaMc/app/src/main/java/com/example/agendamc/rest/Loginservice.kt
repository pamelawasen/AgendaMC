package com.example.agendamc.rest

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Loginservice {
    @POST("/login")
    @FormUrlEncoded
    fun loginUser(@Field("email")email: String,
                  @Field("password")password:String): Observable<String>

}