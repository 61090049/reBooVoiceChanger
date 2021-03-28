package com.example.dechproduct.rebooapplicationproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dechproduct.rebooapplicationproject.viewmodel.SplashState
import com.example.dechproduct.rebooapplicationproject.viewmodel.SplashViewModel

class SplashActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        splashViewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashState.MainActivity -> {
                    goToMainActivity()
                }
            }
        }
        )

    }
    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }}

//finish แล้วจ้า ไปเริ่มที่ Main Activity เลย