package com.example.kinocap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import com.example.kinocap.ui.home.HomeFragment
import retrofit2.Call
import retrofit2.Response

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)

        val timer = object: CountDownTimer(3000, 1000){

            override fun onTick(p0: Long) {
//
//                val log = MyRetrofit().getRetrofit()
//                val getApi = log.create(Api::class.java)
//                val hashMap: HashMap<String, String> = HashMap<String,String>()
//                val log_call:retrofit2.Call<Film> = getApi.getPremieres(hashMap)
//                val homeFragment: Fragment = HomeFragment()
//
//                log_call.enqueue(object: retrofit2.Callback<Film> {
//                    override fun onResponse(call: Call<Film>, response: Response<Film>) {
//                        if (response.isSuccessful){
//                            val intent = Intent(this@LaunchActivity, MainActivity::class.java)
//
//                            startActivity(intent)
//                        }
//                    }

//                    override fun onFailure(call: Call<Film>, t: Throwable) {
//                        Toast.makeText(this@LaunchActivity, t.message, Toast.LENGTH_SHORT).show()
//                    }
//                })
            }

            override fun onFinish() {
                val intent = Intent(this@LaunchActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}