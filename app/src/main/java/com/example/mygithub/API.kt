package com.example.mygithub

import retrofit2.http.GET

interface API {
    @GET("users/khs3994")
    fun getUserInfo(

    ):retrofit2.Call<UserInfo>
}