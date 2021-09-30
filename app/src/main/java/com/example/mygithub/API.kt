package com.example.mygithub

import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("users/{userid}")
    fun getUserInfo(@Path("userid")userid:String

    ):retrofit2.Call<UserInfo>
}