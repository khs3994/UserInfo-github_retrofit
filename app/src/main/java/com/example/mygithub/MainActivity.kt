package com.example.mygithub

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mygithub.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val mbinding by lazy { ActivityMainBinding.inflate(layoutInflater) } //뷰 바인딩 선언
    val TAG: String="로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mbinding.root)

        mbinding.btn.setOnClickListener{
            RetrofitBuilder.api.getUserInfo().enqueue(object : retrofit2.Callback<UserInfo>{
                //통신 성공
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    val userinfo = response.body()!!
                    mbinding.followers.text = userinfo?.followers.toString()
                    mbinding.login.text = userinfo?.login
                    mbinding.following.text = userinfo?.following.toString()

                    Log.d(TAG, "onResponse: 유저아이디: ${userinfo?.login}, 팔로워: ${userinfo?.followers}, 팔로잉: ${userinfo?.following} ")
                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    //통신 실패
                    Log.d("error", t.message.toString())
                }
            })
        }
    }
}